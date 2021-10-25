package dashboard.service;

import dashboard.dto.PageDTO;

public interface IOrders {
	

	public void sendWhatsapp(String orderId);

	public PageDTO getAllOrders();


}
