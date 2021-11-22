package dashboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemBriefDTO {
	
	Integer id;
	String name;
	float price;
	String image;
	Integer quantity;
	Integer limit;
	Long totalItemsAddon;
	public ItemBriefDTO(Integer id, String name, float price, String image, Integer quantity, Integer limit,
			Long totalItemsAddon) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.limit = limit;
		this.totalItemsAddon = totalItemsAddon;
	}
	public ItemBriefDTO() {
		super();
	}
	
	
		
	

}
