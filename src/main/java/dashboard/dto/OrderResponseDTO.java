package dashboard.dto;

import java.util.List;

public class OrderResponseDTO {
	OrderDTO order;
	UserOrderDTO user;
	List<OrderItemDto> orderItemsDtos;
	
	
	public OrderResponseDTO() {
		super();
	}
	public OrderResponseDTO(OrderDTO order, UserOrderDTO user, List<OrderItemDto> orderItemsDtos) {
		super();
		this.order = order;
		this.user = user;
		this.orderItemsDtos = orderItemsDtos;
	}
	public OrderDTO getOrder() {
		return order;
	}
	public void setOrder(OrderDTO order) {
		this.order = order;
	}
	public UserOrderDTO getUser() {
		return user;
	}
	public void setUser(UserOrderDTO user) {
		this.user = user;
	}
	public List<OrderItemDto> getOrderItemsDtos() {
		return orderItemsDtos;
	}
	public void setOrderItemsDtos(List<OrderItemDto> orderItemsDtos) {
		this.orderItemsDtos = orderItemsDtos;
	}
	
	
	
}