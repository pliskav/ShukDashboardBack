package dashboard.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dashboard.dao.Users;
import dashboard.dto.OrderBaseResponseDTO;
import dashboard.dto.OrderDTO;
import dashboard.dto.OrderItemDto;
import dashboard.dto.OrderResponseDTO;
import dashboard.dto.PageDTO;
import dashboard.dto.UserOrderDTO;

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
		
		PageDTO res = new PageDTO(page, size, result.getContent().stream()
				.map(item -> convertToOrderResponseDTO(item))
				.collect(Collectors.toList())
				);
		
		result.stream().forEach(i -> System.out.println(i.getGoods()));
		
//		Map<String, OrderResponseDTO> map = new HashMap<>();
//		ordersJoinedResponseList.stream().forEach(res -> {
//			if(!map.containsKey(res.getUnique_order_id())) {
//				
//				OrderDTO orderDTO = new OrderDTO(res.getId(), res.getUnique_order_id(), res.getOrderstatus_id(), res.getUser_id(), 
//						res.getCoupon_name(), res.getAddress(), res.getTax(), res.getRestaurant_charge(), res.getDelivery_charge(), 
//						res.getTotal(), res.getPayment_mode(), res.getOrder_comment(), res.getRestaurant_id(), 
//						res.getTransaction_id(), res.getDelivery_type(), res.getPayable(), res.getWallet_amount(), res.getTip_amount(), 
//						res.getTax_amount(), res.getCoupon_amount(), res.getSub_total());
//				
//				UserOrderDTO userOrderDTO = new UserOrderDTO(res.getUser_id(), res.getUserName(), res.getEmail(), res.getPhone(), res.getDefault_address_id(), res.getDelivery_pin(), 
//						res.getDelivery_guy_detail_id(), res.getAvatar(), res.getUser_is_active(), res.getTax_number());
//				
//				List<OrderItemDto> itemsDtos = new ArrayList<>();
//				OrderItemDto itemDto = new OrderItemDto(res.getItemOrderId(), res.getItem_id(), res.getItemName(), res.getQuantity(), res.getPrice(), res.getRestaurant_id(), 
//						res.getItem_category_id(), res.getOld_price(), res.getImage(), res.getIs_recommended(), res.getIs_popular(), res.getIs_new(), res.getDesc(), 
//						res.getPlaceholder_image(), res.getItem_is_active(), res.getIs_veg(), res.getOrder_column());
//				itemsDtos.add(itemDto);
//				
//				OrderResponseDTO orderDto = new OrderResponseDTO(orderDTO, userOrderDTO, itemsDtos);	
//				map.put(res.getUnique_order_id(), orderDto);
//			}
//			else {
//				OrderResponseDTO orderDTO = map.get(res.getUnique_order_id());
//				List<OrderItemDto> itemsDtos = orderDTO.getOrderItemsDtos();
//				OrderItemDto itemDto = new OrderItemDto(res.getItemOrderId(), res.getItem_id(), res.getItemName(), res.getQuantity(), res.getPrice(), res.getRestaurant_id(), 
//						res.getItem_category_id(), res.getOld_price(), res.getImage(), res.getIs_recommended(), res.getIs_popular(), res.getIs_new(), res.getDesc(), 
//						res.getPlaceholder_image(), res.getItem_is_active(), res.getIs_veg(), res.getOrder_column());
//				itemsDtos.add(itemDto);
//				orderDTO.setOrderItemsDtos(itemsDtos);
//				map.put(res.getUnique_order_id(), orderDTO);
//			}
//		});
//		
		return new PageDTO(page, size, result.getContent());
	}


	private OrderResponseDTO convertToOrderResponseDTO(OrderBaseResponseDTO item) {
		OrderDTO order = new OrderDTO(item.getId(), item.getUnique_order_id(), item.getOrderstatus_id(), item.getUser_id(), item.getCoupon_name(), item.getAddress(), 
				item.getTax(), item.getRestaurant_charge(), item.getDelivery_charge(), item.getTotal(), item.getPayment_mode(), item.getOrder_comment(), item.getRestaurant_id(), 
				item.getTransaction_id(), item.getDelivery_type(), item.getPayable(), item.getWallet_amount(), item.getTip_amount(), item.getTax_amount(), 
				item.getCoupon_amount(), item.getSub_total());
		
		UserOrderDTO user = new UserOrderDTO(item.getUser_id(), item.getUserName(), item.getEmail(), item.getPhone(), item.getDefault_address_id(), 
				item.getDelivery_pin(), item.getDelivery_guy_detail_id(), item.getAvatar(), item.getUser_is_active(), item.getTax_number());
		System.out.println(item.getGoods());
		List<String> list = new ArrayList<String>();
		list.add(item.getGoods());
		return new OrderResponseDTO(order, user, list);
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



}
