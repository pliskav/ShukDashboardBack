package dashboard.service;

import dashboard.dto.OrderResponseDTO;

public interface IOrders {
	
	public Iterable<OrderResponseDTO> getAllOrders();

}
