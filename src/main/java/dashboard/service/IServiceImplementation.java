package dashboard.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dashboard.dao.Users;
import dashboard.dto.OrderBaseResponseDTO;
import dashboard.dto.OrderDTO;
import dashboard.dto.OrderItemDto;
import dashboard.dto.OrderResponseDTO;
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
	
	public Map<String, OrderResponseDTO> getAllOrders() {
		
		List <OrderBaseResponseDTO> ordersJoinedResponseList = orderRepo.findAllOrdersJoinUsers();
		Map<String, OrderResponseDTO> map = new HashMap<>();
		ordersJoinedResponseList.stream().forEach(res -> {
			if(!map.containsKey(res.getUnique_order_id())) {
				
				OrderDTO orderDTO = new OrderDTO(res.getId(), res.getUnique_order_id(), res.getOrderstatus_id(), res.getUser_id(), 
						res.getCoupon_name(), res.getAddress(), res.getTax(), res.getRestaurant_charge(), res.getDelivery_charge(), 
						res.getTotal(), res.getPayment_mode(), res.getOrder_comment(), res.getRestaurant_id(), 
						res.getTransaction_id(), res.getDelivery_type(), res.getPayable(), res.getWallet_amount(), res.getTip_amount(), 
						res.getTax_amount(), res.getCoupon_amount(), res.getSub_total());
				
				UserOrderDTO userOrderDTO = new UserOrderDTO(res.getUser_id(), res.getUserName(), res.getEmail(), res.getPhone(), res.getDefault_address_id(), res.getDelivery_pin(), 
						res.getDelivery_guy_detail_id(), res.getAvatar(), res.getUser_is_active(), res.getTax_number());
				
				List<OrderItemDto> itemsDtos = new ArrayList<>();
				OrderItemDto itemDto = new OrderItemDto(res.getItemOrderId(), res.getItem_id(), res.getItemName(), res.getQuantity(), res.getPrice(), res.getRestaurant_id(), 
						res.getItem_category_id(), res.getOld_price(), res.getImage(), res.getIs_recommended(), res.getIs_popular(), res.getIs_new(), res.getDesc(), 
						res.getPlaceholder_image(), res.getItem_is_active(), res.getIs_veg(), res.getOrder_column());
				itemsDtos.add(itemDto);
				
				OrderResponseDTO orderDto = new OrderResponseDTO(orderDTO, userOrderDTO, itemsDtos);	
				map.put(res.getUnique_order_id(), orderDto);
			}
			else {
				OrderResponseDTO orderDTO = map.get(res.getUnique_order_id());
				List<OrderItemDto> itemsDtos = orderDTO.getOrderItemsDtos();
				OrderItemDto itemDto = new OrderItemDto(res.getItemOrderId(), res.getItem_id(), res.getItemName(), res.getQuantity(), res.getPrice(), res.getRestaurant_id(), 
						res.getItem_category_id(), res.getOld_price(), res.getImage(), res.getIs_recommended(), res.getIs_popular(), res.getIs_new(), res.getDesc(), 
						res.getPlaceholder_image(), res.getItem_is_active(), res.getIs_veg(), res.getOrder_column());
				itemsDtos.add(itemDto);
				orderDTO.setOrderItemsDtos(itemsDtos);
				map.put(res.getUnique_order_id(), orderDTO);
			}
		});
		
		return map;
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
