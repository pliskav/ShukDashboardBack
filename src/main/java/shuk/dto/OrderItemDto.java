package shuk.dto;

import lombok.Getter;
import lombok.Setter;

@Getter

public class OrderItemDto {
	int orderId;
	int item_id;
	String name;
	int quantity;
	float price;
	@Setter
	String restaurant_id;
	@Setter
	int item_category_id; 
	@Setter
	float old_price; 
	@Setter
	String image; 
	@Setter
	int is_recommended; 
	@Setter
	int is_popular;
	@Setter
	int is_new; 
	@Setter
	String desc; 
	@Setter
	String placeholder_image; 
	@Setter
	int is_active; 
	@Setter
	String is_veg; 
	@Setter
	String order_column;
	
	public OrderItemDto() {
		super();
	}

	public OrderItemDto(int orderId, int item_id, String name, int quantity, float price, String restaurant_id,
			int item_category_id, float old_price, String image, int is_recommended, int is_popular, int is_new,
			String desc, String placeholder_image, int is_active, String is_veg, String order_column) {
		super();
		this.orderId = orderId;
		this.item_id = item_id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.restaurant_id = restaurant_id;
		this.item_category_id = item_category_id;
		this.old_price = old_price;
		this.image = image;
		this.is_recommended = is_recommended;
		this.is_popular = is_popular;
		this.is_new = is_new;
		this.desc = desc;
		this.placeholder_image = placeholder_image;
		this.is_active = is_active;
		this.is_veg = is_veg;
		this.order_column = order_column;
	}

	


	
	
	
	
	
}
