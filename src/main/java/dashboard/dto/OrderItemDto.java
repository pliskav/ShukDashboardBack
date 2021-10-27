package dashboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class OrderItemDto {
//	int orderId;
//	int item_id;
//	String name;
//	int quantity;
//	float price;
//	@Setter
//	String restaurant_id;
//	@Setter
//	int item_category_id; 
//	@Setter
//	float old_price; 
//	@Setter
//	String image; 
//	@Setter
//	int is_recommended; 
//	@Setter
//	int is_popular;
//	@Setter
//	int is_new; 
//	@Setter
//	String desc; 
//	@Setter
//	String placeholder_image; 
//	@Setter
//	int is_active; 
//	@Setter
//	String is_veg; 
//	@Setter
//	String order_column;
	
	int orderId;
	int itemId;
	String itemName;
	float price;
	int quantity;
	float old_price;
	String image;
	int itemCategoryId;
	int is_recommended;
	int is_popular;
	int is_new;
	int is_active;
	String desc;
	String placeholder_image; 
	String is_veg;
	String order_column;
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setOld_price(float old_price) {
		this.old_price = old_price;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}
	public void setIs_recommended(int is_recommended) {
		this.is_recommended = is_recommended;
	}
	public void setIs_popular(int is_popular) {
		this.is_popular = is_popular;
	}
	public void setIs_new(int is_new) {
		this.is_new = is_new;
	}
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setPlaceholder_image(String placeholder_image) {
		this.placeholder_image = placeholder_image;
	}
	public void setIs_veg(String is_veg) {
		this.is_veg = is_veg;
	}
	public void setOrder_column(String order_column) {
		this.order_column = order_column;
	}
	public OrderItemDto(int orderId, int itemId, String itemName, float price, int quantity, float old_price,
			String image, int itemCategoryId, int is_recommended, int is_popular, int is_new, int is_active,
			String desc, String placeholder_image, String is_veg, String order_column) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.old_price = old_price;
		this.image = image;
		this.itemCategoryId = itemCategoryId;
		this.is_recommended = is_recommended;
		this.is_popular = is_popular;
		this.is_new = is_new;
		this.is_active = is_active;
		this.desc = desc;
		this.placeholder_image = placeholder_image;
		this.is_veg = is_veg;
		this.order_column = order_column;
	}
	public OrderItemDto() {
		super();
	}

	


	
	
	
	
	
}
