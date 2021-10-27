package dashboard.service;

import java.util.List;

import dashboard.dto.OrderBaseResponseDTO;
import dashboard.dto.PageDTO;

public interface IOrders {
	
	public PageDTO getAllOrders(int page, int size);

}
