package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orderitems")
@Getter
@Setter
public class OrderItem {
	@Id
	int id;
	@Column(name = "order_id")
	int orderId;
	int item_id;
	String name;
	int quantity;
	float price;
	String created_at;
	String updated_at;
	public OrderItem(int id, int orderId, int item_id, String name, int quantity, float price, String created_at,
			String updated_at) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.item_id = item_id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public OrderItem() {
		super();
	}
	
	
}
