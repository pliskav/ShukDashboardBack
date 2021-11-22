package dashboard.service;

import dashboard.dto.OrderBaseResponseDTO;
import dashboard.dto.OrderResponseDTO;
import dashboard.dto.PageDTO;


public interface IOrders {
	
	public PageDTO getAllOrders(int page, int size);
	

	public void editOrder(Integer orderId, OrderResponseDTO orderData);
	
	public void changeOrderStatus(Integer orderId, Integer orderStatus);

	public void editOrder(Integer orderId, OrderBaseResponseDTO orderData);
	
	public Boolean sendWhatsapp(String orderId);

}
