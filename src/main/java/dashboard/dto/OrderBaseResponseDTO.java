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
	int id;//o.id
	String unique_order_id;//o.uniqueOrderId
	int orderstatus_id;//o.orderstatus_id
	int user_id;//o.user_id
	String coupon_name;//o.coupon_name
	String address;// o.address
	String location;//o.location
	String tax;//o.tax
	String restaurant_charge;//o.restaurant_charge
	String delivery_charge;//o.delivery_charge
	String total;//o.total
	String payment_mode;//o.payment_mode
	String order_comment;//o.order_comment
	String restaurant_id;//o.restaurant_id
	String transaction_id;//o.transaction_id
	String delivery_type;//o.delivery_type
	String payable;//o.payable
	String wallet_amount;//o.wallet_amount
	String tip_amount;//o.tip_amount
	String tax_amount;//o.tax_amount
	String coupon_amount;//o.coupon_amount
	String sub_total;//o.sub_total
	String createdAt;//o.created_at
	String is_scheduled;//o.is_scheduled
	String orderDate;//o.orderDate
	String orderTime;// o.orderTime
		String userName;//u.userName
	String phone;//u.phone
	String second_phone;
	String email;//u.email
	String avatar;// u.avatar
	String default_address_id;//u.default_address_id
	String delivery_pin;//u.delivery_pin
	String delivery_guy_detail_id;//u.delivery_guy_detail_id
	String user_is_active;// u.userIs_active
	String tax_number;// u.tax_number
	String store_name;//
	String goods;//
	
	

	
	@Override
	public String toString() {
		return "OrderBaseResponseDTO [id=" + id + ", unique_order_id=" + unique_order_id + ", orderstatus_id="
				+ orderstatus_id + ", user_id=" + user_id + ", coupon_name=" + coupon_name + ", address=" + address
				+ ", tax=" + tax + ", restaurant_charge=" + restaurant_charge + ", delivery_charge=" + delivery_charge
				+ ", total=" + total + ", payment_mode=" + payment_mode + ", order_comment=" + order_comment
				+ ", restaurant_id=" + restaurant_id + ", transaction_id=" + transaction_id + ", delivery_type="
				+ delivery_type + ", payable=" + payable + ", wallet_amount=" + wallet_amount + ", tip_amount="
				+ tip_amount + ", tax_amount=" + tax_amount + ", coupon_amount=" + coupon_amount + ", sub_total="
				+ sub_total + ", createdAt=" + createdAt + ", is_scheduled=" + is_scheduled + ", orderDate=" + orderDate
				+ ", orderTime=" + orderTime + ", userName=" + userName + ", phone=" + phone + ", email=" + email + ", avatar=" + avatar + ", default_address_id="
				+ default_address_id + ", delivery_pin=" + delivery_pin + ", delivery_guy_detail_id="
				+ delivery_guy_detail_id + ", user_is_active=" + user_is_active + ", tax_number=" + tax_number
				+ ", goods=" + goods + "]";
	}
}
