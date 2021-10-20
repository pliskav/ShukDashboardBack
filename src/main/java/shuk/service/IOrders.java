package shuk.service;

import java.util.Map;

import shuk.dto.OrderResponseDTO;

public interface IOrders {
	
	public Map<String, OrderResponseDTO> getAllOrders();

}
