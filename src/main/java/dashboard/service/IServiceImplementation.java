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
import dashboard.dto.OrderBaseResponseDTO;
import dashboard.dto.OrderDTO;
import dashboard.dto.OrderPageDTO;
import dashboard.dto.OrderResponseDTO;
import dashboard.dto.PageDTO;
import dashboard.dto.UserOrderDTO;
import dashboard.exceptions.BadRequestException;
import utils.WhatsappMessage;

@Service
public class IServiceImplementation implements IService, IOrders{


	@Autowired
	UserRepositorySql userRepo;
	@Autowired
	OrderRepositorySql orderRepo;
	@Autowired
	OrderItemRepository orderItemRepository;
	@Autowired
	ItemRepository itemRepository;
	
	public PageDTO getAllOrders(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		
		Page<OrderBaseResponseDTO> result = orderRepo.findAllOrdersJoinUsers(pageable);
		
		List<OrderResponseDTO> res = new ArrayList<OrderResponseDTO>(result.getContent().stream()
				.map(item -> convertToOrderResponseDTO(item))
				.collect(Collectors.toList())
				);
		Set<Integer> itemIdSet = result.getContent()
								.stream()
								.flatMap(response->{
									List<String> arrItems = Arrays.asList(response.getGoods().split(","));
									List<Integer> itemIds = arrItems.stream().filter((str) -> arrItems.indexOf(str)%2==0).map(str -> Integer.parseInt(str)).collect(Collectors.toList());
									return itemIds.stream();
								})
								.collect(Collectors.toSet());
		List<Item> listItems = itemRepository.findAllById(itemIdSet);
		int totalOrdersCount = orderRepo.findTotalCountOrders();
			
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


	private OrderResponseDTO convertToOrderResponseDTO(OrderBaseResponseDTO item) {
		OrderDTO order = new OrderDTO(item.getId(), item.getUnique_order_id(), item.getOrderstatus_id(), item.getUser_id(), item.getCoupon_name(), item.getAddress(), 
				item.getTax(), item.getRestaurant_charge(), item.getDelivery_charge(), item.getTotal(), item.getPayment_mode(), item.getOrder_comment(), item.getRestaurant_id(), 
				item.getTransaction_id(), item.getDelivery_type(), item.getPayable(), item.getWallet_amount(), item.getTip_amount(), item.getTax_amount(), 
				item.getCoupon_amount(), item.getSub_total());
		
		UserOrderDTO user = new UserOrderDTO(item.getUser_id(), item.getUserName(), item.getEmail(), item.getPhone(), item.getDefault_address_id(), 
				item.getDelivery_pin(), item.getDelivery_guy_detail_id(), item.getAvatar(), item.getUser_is_active(), item.getTax_number());
		String itemIds = item.getGoods();
		
		return new OrderResponseDTO(order, user, itemIds);
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
	public void editOrder(Integer orderId, OrderBaseResponseDTO orderData) {
		if (orderData == null || orderId == null) {
			throw new BadRequestException();
		}
		
		Orders orderEdit = orderRepo.findById(orderId).orElseThrow(() -> new BadRequestException());
		
		if(orderData.getAddress()!= null) {
			orderEdit.setAddress(orderData.getAddress());
		}
		if(orderData.getOrderstatus_id()!=null) {
			orderEdit.setOrderstatus_id(orderData.getOrderstatus_id());
		}
		if(orderData.getCoupon_amount()!= null) {
			orderEdit.setCoupon_amount(orderData.getCoupon_amount());
		}
		if(orderData.getCoupon_name()!=null) {
			orderEdit.setCoupon_name(orderData.getCoupon_name());
		}
		if(orderData.getTax()!=null) {
			orderEdit.setTax(orderData.getTax());
		}
		if(orderData.getRestaurant_charge()!=null) {
			orderEdit.setRestaurant_charge(orderData.getRestaurant_charge());
		}
		if(orderData.getDelivery_charge()!=null) {
			orderEdit.setDelivery_charge(orderData.getDelivery_charge());
		}
		if(orderData.getTotal()!=null) {
			orderEdit.setTotal(orderData.getTotal());
		}
		if(orderData.getPayment_mode()!=null) {
			orderEdit.setPayment_mode(orderData.getPayment_mode());
		}
		if(orderData.getOrder_comment()!=null) {
			orderEdit.setOrder_comment(orderData.getOrder_comment());
		}
		if(orderData.getRestaurant_id()!=null) {
			orderEdit.setRestaurant_id(orderData.getRestaurant_id());
		}
		if(orderData.getTransaction_id()!=null) {
			orderEdit.setTransaction_id(orderData.getTransaction_id());
		}
		if(orderData.getDelivery_type()!=null) {
			orderEdit.setDelivery_type(orderData.getDelivery_type());
		}
		if(orderData.getPayable()!=null) {
			orderEdit.setPayable(orderData.getPayable());
		}
		if(orderData.getWallet_amount()!=null) {
			orderEdit.setWallet_amount(orderData.getWallet_amount());
		}
		if(orderData.getTip_amount()!=null) {
			orderEdit.setTip_amount(orderData.getTip_amount());
		}
		if(orderData.getTax_amount()!=null) {
			orderEdit.setTax_amount(orderData.getTax_amount());
		}
		if(orderData.getSub_total()!=null) {
			orderEdit.setSub_total(orderData.getSub_total());
		}
		Date date = Date.valueOf(LocalDate.now());
		orderEdit.setUpdated_at(date);
		orderRepo.save(orderEdit);
		
		List<String> arrItems = Arrays.asList(orderData.getGoods().split(","));
		List<Integer> itemIds = arrItems.stream().filter((str) -> arrItems.indexOf(str)%2==0).map(str -> Integer.parseInt(str)).collect(Collectors.toList());
		itemIds.forEach(item -> System.out.println(item));
		
		List<Integer> itemQantity = arrItems.stream().filter((str) -> arrItems.indexOf(str)%2!=0).map(str -> Integer.parseInt(str)).collect(Collectors.toList());
		itemQantity.forEach(item->System.out.println(item));
		
		Iterable<OrderItem> itemsList= orderItemRepository.findAllById(itemIds);
		itemsList.forEach(item -> System.out.println(item.getItemName()));
		
		
	}


	@Override
	public Boolean sendWhatsapp(String orderId) {
		WhatsappMessage.getInstance().main("972524083393","Sssssssdfdfbg");
		return true;
	}



}
