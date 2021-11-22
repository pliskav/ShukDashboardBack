package dashboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemBriefDTO {
	
	Integer id;
//	Integer restaurantId;
//	int itemCategoryId; 
	String name;
	float price;
//	float old_price; 
	String image;
	Integer quantity;
	
//	int is_recommended; 
//	int is_popular;
//	int is_new; 
//	String created_at; 
//	String updated_at;
//	String desc; 
//	String placeholder_image; 
//	int is_active; 
//	String is_veg; 
//	String order_column;
	Integer limit;
//	Integer total;
	Long totalItemsAddon;
	public ItemBriefDTO(Integer id, String name, float price, String image, Integer quantity, Integer limit,
//			Integer total, 
			Long totalItemsAddon) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.limit = limit;
//		this.total = total;
		this.totalItemsAddon = totalItemsAddon;
	}
	public ItemBriefDTO() {
		super();
	}
	
	
		
	

}
