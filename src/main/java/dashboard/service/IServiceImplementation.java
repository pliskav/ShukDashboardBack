package dashboard.service;

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
import dashboard.dao.Users;
import dashboard.dto.OrderBaseResponseDTO;
import dashboard.dto.OrderDTO;
import dashboard.dto.OrderPageDTO;
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
		
		List<OrderResponseDTO> res = new ArrayList<OrderResponseDTO>(result.getContent().stream()
				.map(item -> convertToOrderResponseDTO(item))
				.collect(Collectors.toList())
				);
		Set<Integer> itemIds = result.getContent()
								.stream()
								.flatMap(response->{
									List<Integer> idList = Arrays.stream(response.getGoods().split(",")).filter(str -> str.indexOf(str)%2==0).map(str -> Integer.parseInt(str)).collect(Collectors.toList());
									return idList.stream();
								})
								.collect(Collectors.toSet());
		List<Item> listItems = itemRepository.findAllById(itemIds);		
			
		return PageDTO.builder()
				.current_page(page)
				.items_on_page(size)
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



}
