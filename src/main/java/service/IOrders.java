package service;

import java.util.Map;

import dto.OrderResponseDTO;

public interface IOrders {
	
	public Map<String, OrderResponseDTO> getAllOrders();

}
