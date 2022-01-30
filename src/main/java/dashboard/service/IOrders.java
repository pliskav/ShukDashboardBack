package dashboard.service;

import dashboard.dto.OrderResponseDTO;
import dashboard.dto.PageDTO;


public interface IOrders {
	
//	public PageDTO getAllOrders(Integer page, Integer size);
	
	public PageDTO findOrdersByFilters(String userEmail, String userPhone, String userName, String orderDate,
			String dateFrom, String dateTo, Integer storeId, String orderItem, Integer current_page, Integer items_on_page);
	

	public void editOrder(Integer orderId, OrderResponseDTO orderData);
	
	public void changeOrderStatus(Integer orderId, Integer orderStatus);

	public Boolean sendWhatsapp(String orderId);
	
	public Boolean setDefaultLanguageForUser(int userId, int languageId);

}
