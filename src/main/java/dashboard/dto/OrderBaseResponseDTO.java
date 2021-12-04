package dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderBaseResponseDTO {
	int id;
	String unique_order_id;
	Integer orderstatus_id;
	int user_id;
	String coupon_name;
	String address;
	String tax;
	String restaurant_charge;
	String delivery_charge;
	String total;
	String payment_mode;
	String order_comment;
	String restaurant_id;
	String transaction_id;
	String delivery_type;
	String payable;
	String wallet_amount;
	String tip_amount;
	String tax_amount;
	String coupon_amount;
	String sub_total;
	
	String is_scheduled;
	String orderDate;
	String orderTime;
	
	String userName;
	String phone;
	String email;
	String avatar;
	String default_address_id;
	String delivery_pin;
	String delivery_guy_detail_id;
	String user_is_active;
	String tax_number;
	String goods;

	

}
