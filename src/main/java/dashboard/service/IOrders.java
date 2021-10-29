package dashboard.service;

import dashboard.dto.PageDTO;

public interface IOrders {
	
	public PageDTO getAllOrders(int page, int size);

}
