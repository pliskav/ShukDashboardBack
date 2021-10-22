package dashboard.service;

import java.util.Map;

import dashboard.dto.OrderResponseDTO;

public interface IOrders {
	
	public Map<String, OrderResponseDTO> getAllOrders();

}
