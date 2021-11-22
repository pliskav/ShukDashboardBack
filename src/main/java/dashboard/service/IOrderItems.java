package dashboard.service;

import java.util.List;

import dashboard.dto.ItemBriefDTO;

public interface IOrderItems {
	
	public List<ItemBriefDTO> getAllBriefDTOs();
}
