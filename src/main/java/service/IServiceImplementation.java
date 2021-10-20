package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserSql;
import dto.OrderBaseResponseDTO;
import dto.OrderDTO;
import dto.OrderItemDto;
import dto.OrderResponseDTO;
import dto.UserOrderDTO;

@Service
public class IServiceImplementation implements IService, IOrders{
	private static EntityManager em;
    private static EntityManagerFactory emFactory;

	@Autowired
	UserRepositorySql userRepo;
	@Autowired
	OrderRepositorySql orderRepo;
	@Autowired
	OrderItemRepository orderItemRepository;
	@Autowired
	ItemRepository itemRepository;
	
	public Map<String, OrderResponseDTO> getAllOrders() {
		emFactory = Persistence.createEntityManagerFactory("shuk_dashboard_back");
        em = emFactory.createEntityManager();
//        List<Long> employeeIds = em.createNamedQuery("FridayEmployees").getResultList();
		List <OrderBaseResponseDTO> ordersJoinedResponseList = em.createNamedQuery("OrdersJoinedRequest", OrderBaseResponseDTO.class).getResultList();
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
	public List<UserSql> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserSql findUserById(int Id) {
		return userRepo.findById(Id);
	}



	@Override
	public List<UserSql> findAllUsersById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}
}
