package dashboard.dto;

public class OrderResponseDTO {
	OrderDTO order;
	UserOrderDTO user;
	String orderItemsDtos;
	
	
	public OrderResponseDTO() {
		super();
	}
	public OrderResponseDTO(OrderDTO order, UserOrderDTO user, String orderItemsDtos) {
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
	public String getOrderItemsDtos() {
		return orderItemsDtos;
	}
	public void setOrderItemsDtos(String orderItemsDtos) {
		this.orderItemsDtos = orderItemsDtos;
	}
	
	
	
}
