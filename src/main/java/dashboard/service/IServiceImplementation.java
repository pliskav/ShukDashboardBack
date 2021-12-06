package dashboard.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dashboard.dao.Item;
import dashboard.dao.OrderItem;
import dashboard.dao.Orders;
import dashboard.dao.Users;
import dashboard.dto.ItemBriefDTO;
import dashboard.dto.ItemData;
import dashboard.dto.OrderBaseResponseDTO;
import dashboard.dto.OrderDTO;
import dashboard.dto.OrderPageDTO;
import dashboard.dto.OrderResponseDTO;
import dashboard.dto.PageDTO;
import dashboard.dto.UserOrderDTO;
import dashboard.exceptions.BadRequestException;
import dashboard.exceptions.NotFoundException;
import utils.WhatsappMessage;

@Service
public class IServiceImplementation implements IService, IOrders, IOrderItems{


	@Autowired
	UserRepositorySql userRepo;
	@Autowired
	OrderRepositorySql orderRepo;
	@Autowired
	OrderItemRepository orderItemRepository;
	@Autowired
	ItemRepository itemRepository;
	
	public PageDTO getAllOrders(int page, int size) {
		
		int totalOrdersCount = orderRepo.findTotalCountOrders();
		
		size = size!=0 ? size: totalOrdersCount;
		
		Pageable pageable = PageRequest.of(page, size);
					
		Page<OrderBaseResponseDTO> result = orderRepo.findAllOrdersJoinUsers(pageable);
		
		List<OrderResponseDTO> res = new ArrayList<OrderResponseDTO>(result.getContent().stream()
				.map(item -> convertToOrderResponseDTO(item))
				.collect(Collectors.toList())
				);
						
		Set<Integer> itemIdSet = res.stream().flatMap(order -> order.getOrderItemsDtos().stream().map(data -> data.getId())).collect(Collectors.toSet());

		List<Item> listItems = itemRepository.findAllById(itemIdSet);
		
			
		return PageDTO.builder()
				.current_page(page)
				.items_on_page(size)
				.total_count(totalOrdersCount)
				.orderPage(OrderPageDTO
						.builder()
						.orders(res)
						.items(listItems)
						.build())
				.build();
	}

	@Override
	public PageDTO findOrdersByFilters(String userEmail, String userPhone, String userName, String orderDate,
			Integer storeId, Integer page, Integer size) {
		System.out.println(userEmail);
		System.out.println(userPhone);
		System.out.println("+" + userPhone);
		System.out.println("first character " + userPhone.charAt(0) + " at phone number");
		if (userEmail==null||userEmail=="") {
			userEmail="";
		}
		if (userPhone==null||userPhone=="") {
			userPhone="";
		}
		if (userName==null||userName=="") {
			userName="";
		}
		if (orderDate==null||orderDate=="") {
			orderDate="";
		}
		if (storeId==null) {
			storeId=0;
		}
		
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<OrderBaseResponseDTO> result = orderRepo.findAllOrdersJoinUserswithFilters(userEmail, userPhone, pageable);
		System.out.println(result.getContent().size());
		
		List<OrderResponseDTO> res = new ArrayList<OrderResponseDTO>(result.getContent().stream()
				.map(item -> convertToOrderResponseDTO(item))
				.collect(Collectors.toList())
				);
		
				
		Set<Integer> itemIdSet = res.stream().flatMap(order -> order.getOrderItemsDtos().stream().map(data -> data.getId())).collect(Collectors.toSet());

		List<Item> listItems = itemRepository.findAllById(itemIdSet);
		int totalOrdersCount = orderRepo.findTotalCountOrders();
			
		return PageDTO.builder()
				.current_page(page)
				.items_on_page(res.size())
				.total_count(totalOrdersCount)
				.orderPage(OrderPageDTO
						.builder()
						.orders(res)
						.items(listItems)
						.build())
				.build();
	}

	private OrderResponseDTO convertToOrderResponseDTO(OrderBaseResponseDTO item) {
		OrderDTO order = new OrderDTO(item.getId(), item.getUnique_order_id(), item.getOrderstatus_id(), item.getUser_id(), item.getCoupon_name(), item.getAddress(), 
				item.getTax(), item.getRestaurant_charge(), item.getDelivery_charge(), item.getTotal(), item.getPayment_mode(), item.getOrder_comment(), item.getRestaurant_id(), 
				item.getTransaction_id(), item.getDelivery_type(), item.getPayable(), item.getWallet_amount(), item.getTip_amount(), item.getTax_amount(), 
				item.getCoupon_amount(), item.getSub_total(), item.getIs_scheduled(), item.getOrderDate(), item.getOrderTime());
		
		UserOrderDTO user = new UserOrderDTO(item.getUser_id(), item.getUserName(), item.getEmail(), item.getPhone(), item.getDefault_address_id(), 
				item.getDelivery_pin(), item.getDelivery_guy_detail_id(), item.getAvatar(), item.getUser_is_active(), item.getTax_number());
		
		String goodString = item.getGoods();
		if (goodString.endsWith(";")) {
			goodString = goodString.substring(0, (goodString.length()-1)); 
		}
		String[] strArray = goodString.split(";,");
		List<String> arrItems = Arrays.asList(strArray);
		List<ItemData> goodsList = arrItems.stream().map(arrayString -> arrayString.split(","))
		.map(array -> {
			return new ItemData(Integer.parseInt(array[0]), Integer.parseInt(array[1]), item.getId(), Float.parseFloat(array[2]));
		})
		.collect(Collectors.toList());
		
				
		
		return new OrderResponseDTO(order, user, goodsList);
	}


	@Override
	public List<Users> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Users findUserById(int Id) {
		return userRepo.findById(Id);
	}



	@Override
	public List<Users> findAllUsersById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void editOrder(Integer orderId, OrderResponseDTO orderData) {
		System.out.println("Editing order");
		if (orderData == null || orderId == null) {
			throw new BadRequestException();
		}
		System.out.println(orderId);
		System.out.println(orderData.toString());
		
		if(orderData.getOrder()!=null) {
			OrderDTO orderSent = orderData.getOrder();
			System.out.println(orderSent.toString());
			Orders orderEdit = orderRepo.findById(orderId).orElseThrow(() -> new BadRequestException());

			if(!orderSent.getAddress().equals(null)) {
				orderEdit.setAddress(orderSent.getAddress());
			}
			if(orderSent.getOrderstatus_id()!=null) {
				orderEdit.setOrderstatus_id(orderSent.getOrderstatus_id());
			}
			if(orderSent.getCoupon_amount()!= null) {
				orderEdit.setCoupon_amount(orderSent.getCoupon_amount());
			}
			if(orderSent.getCoupon_name()!=null) {
				orderEdit.setCoupon_name(orderSent.getCoupon_name());
			}
			if(orderSent.getTax()!=null) {
				orderEdit.setTax(orderSent.getTax());
			}
			if(orderSent.getRestaurant_charge()!=null) {
				orderEdit.setRestaurant_charge(orderSent.getRestaurant_charge());
			}
			if(orderSent.getDelivery_charge()!=null) {
				orderEdit.setDelivery_charge(orderSent.getDelivery_charge());
			}
			if(orderSent.getTotal()!=null) {
				orderEdit.setTotal(orderSent.getTotal());
			}
			if(orderSent.getPayment_mode()!=null) {
				orderEdit.setPayment_mode(orderSent.getPayment_mode());
			}
			if(orderSent.getOrder_comment()!=null) {
				orderEdit.setOrder_comment(orderSent.getOrder_comment());
			}
			if(orderSent.getRestaurant_id()!=null) {
				orderEdit.setRestaurant_id(orderSent.getRestaurant_id());
			}
			if(orderSent.getTransaction_id()!=null) {
				orderEdit.setTransaction_id(orderSent.getTransaction_id());
			}
			if(orderSent.getDelivery_type()!=null) {
				orderEdit.setDelivery_type(orderSent.getDelivery_type());
			}
			if(orderSent.getPayable()!=null) {
				orderEdit.setPayable(orderSent.getPayable());
			}
			if(orderSent.getWallet_amount()!=null) {
				orderEdit.setWallet_amount(orderSent.getWallet_amount());
			}
			if(orderSent.getTip_amount()!=null) {
				orderEdit.setTip_amount(orderSent.getTip_amount());
			}
			if(orderSent.getTax_amount()!=null) {
				orderEdit.setTax_amount(orderSent.getTax_amount());
			}
			if(orderSent.getSub_total()!=null) {
				orderEdit.setSub_total(orderSent.getSub_total());
			}
			Date date = Date.valueOf(LocalDate.now());
			orderEdit.setUpdated_at(date);
			orderRepo.save(orderEdit);
		}else {
			System.out.println("no new data on order itself");
		}
		
		if(orderData.getOrderItemsDtos()!=null) {
			Orders orderEdit = orderRepo.findById(orderId).orElseThrow(() -> new BadRequestException());
		
			String totalPrice = (orderData.getOrderItemsDtos()
					.stream()
					.map(item -> item.getPrice()*item.getQuantity())
					.reduce((float)0, Float::sum)).toString();
			System.out.println(totalPrice);
			orderEdit.setTotal(totalPrice);
			orderRepo.save(orderEdit);
		}
		
		List<ItemData> list = orderData.getOrderItemsDtos();
		List<Integer> itemIdList = list.stream().map(data -> data.getId()).collect(Collectors.toList());


		List<OrderItem> itemList = orderItemRepository.getAllByOrderIdAndItemIdIn(orderId, itemIdList);
		itemList.forEach(item -> System.out.println(item.getOrderId() + " order number, " + item.getItemName() + " item name from base"));
		

		itemList.stream().forEach(orderItem -> {
		
			ItemData itemEdited = list.stream()
					.filter(item ->(item.getId()==orderItem.getItemId()) && (item.getOrderId()==orderItem.getOrderId()))
					.findFirst().orElseThrow(() -> new NotFoundException());
			System.out.println(orderItem.getOrderId());
			System.out.println(itemEdited.getOrderId());
			orderItem.setQuantity(itemEdited.getQuantity());
		});	
		orderItemRepository.saveAll(itemList);
	}


	@Override
	public void changeOrderStatus(Integer orderId, Integer orderStatus) {
		if(orderId==null || orderStatus==null) {
			throw new BadRequestException();
		}
		Orders orderEdit = orderRepo.findById(orderId).orElseThrow(()-> new NotFoundException());
		orderEdit.setOrderstatus_id(orderStatus);
		orderRepo.save(orderEdit);
	}


	@Override
	public List<ItemBriefDTO> getAllBriefDTOs() {
		List<ItemBriefDTO> list = orderItemRepository.findAllNewItems();
		return list;
	}

	public Boolean sendWhatsapp(String orderId) {
		WhatsappMessage.getInstance().main("972524083393","Sssssssdfdfbg");
		return true;
	}


	




	



}
