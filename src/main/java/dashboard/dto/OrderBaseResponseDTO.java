package dashboard.dto;

public class OrderBaseResponseDTO {
	int id;
	String unique_order_id;
	int orderstatus_id;
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
	String userName;
	String phone;
	String email;
	String avatar;
	String default_address_id;
	String delivery_pin;
	String delivery_guy_detail_id;
	String user_is_active;
	String tax_number;
//	
//	int itemOrderId;
//	int itemId;
//	String itemName;
//	float price;
//	int quantity;
//	float old_price;
//	String image;
//	int item_category_id;
//	int is_recommended;
//	int is_popular;
//	int is_new;
//	String desc;
//	String placeholder_image;
//	int item_is_active;
//	String is_veg;
//	String order_column;
	String goods;
public OrderBaseResponseDTO(int id, String unique_order_id, int orderstatus_id, int user_id, String coupon_name,
		String address, String tax, String restaurant_charge, String delivery_charge, String total, String payment_mode,
		String order_comment, String restaurant_id, String transaction_id, String delivery_type, String payable,
		String wallet_amount, String tip_amount, String tax_amount, String coupon_amount, String sub_total,
		String userName, String phone, String email, String avatar, String default_address_id, String delivery_pin,
		String delivery_guy_detail_id, String user_is_active, String tax_number, String goods) {
	super();
	this.id = id;
	this.unique_order_id = unique_order_id;
	this.orderstatus_id = orderstatus_id;
	this.user_id = user_id;
	this.coupon_name = coupon_name;
	this.address = address;
	this.tax = tax;
	this.restaurant_charge = restaurant_charge;
	this.delivery_charge = delivery_charge;
	this.total = total;
	this.payment_mode = payment_mode;
	this.order_comment = order_comment;
	this.restaurant_id = restaurant_id;
	this.transaction_id = transaction_id;
	this.delivery_type = delivery_type;
	this.payable = payable;
	this.wallet_amount = wallet_amount;
	this.tip_amount = tip_amount;
	this.tax_amount = tax_amount;
	this.coupon_amount = coupon_amount;
	this.sub_total = sub_total;
	this.userName = userName;
	this.phone = phone;
	this.email = email;
	this.avatar = avatar;
	this.default_address_id = default_address_id;
	this.delivery_pin = delivery_pin;
	this.delivery_guy_detail_id = delivery_guy_detail_id;
	this.user_is_active = user_is_active;
	this.tax_number = tax_number;
	this.goods = goods;
}
public OrderBaseResponseDTO() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUnique_order_id() {
	return unique_order_id;
}
public void setUnique_order_id(String unique_order_id) {
	this.unique_order_id = unique_order_id;
}
public int getOrderstatus_id() {
	return orderstatus_id;
}
public void setOrderstatus_id(int orderstatus_id) {
	this.orderstatus_id = orderstatus_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getCoupon_name() {
	return coupon_name;
}
public void setCoupon_name(String coupon_name) {
	this.coupon_name = coupon_name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTax() {
	return tax;
}
public void setTax(String tax) {
	this.tax = tax;
}
public String getRestaurant_charge() {
	return restaurant_charge;
}
public void setRestaurant_charge(String restaurant_charge) {
	this.restaurant_charge = restaurant_charge;
}
public String getDelivery_charge() {
	return delivery_charge;
}
public void setDelivery_charge(String delivery_charge) {
	this.delivery_charge = delivery_charge;
}
public String getTotal() {
	return total;
}
public void setTotal(String total) {
	this.total = total;
}
public String getPayment_mode() {
	return payment_mode;
}
public void setPayment_mode(String payment_mode) {
	this.payment_mode = payment_mode;
}
public String getOrder_comment() {
	return order_comment;
}
public void setOrder_comment(String order_comment) {
	this.order_comment = order_comment;
}
public String getRestaurant_id() {
	return restaurant_id;
}
public void setRestaurant_id(String restaurant_id) {
	this.restaurant_id = restaurant_id;
}
public String getTransaction_id() {
	return transaction_id;
}
public void setTransaction_id(String transaction_id) {
	this.transaction_id = transaction_id;
}
public String getDelivery_type() {
	return delivery_type;
}
public void setDelivery_type(String delivery_type) {
	this.delivery_type = delivery_type;
}
public String getPayable() {
	return payable;
}
public void setPayable(String payable) {
	this.payable = payable;
}
public String getWallet_amount() {
	return wallet_amount;
}
public void setWallet_amount(String wallet_amount) {
	this.wallet_amount = wallet_amount;
}
public String getTip_amount() {
	return tip_amount;
}
public void setTip_amount(String tip_amount) {
	this.tip_amount = tip_amount;
}
public String getTax_amount() {
	return tax_amount;
}
public void setTax_amount(String tax_amount) {
	this.tax_amount = tax_amount;
}
public String getCoupon_amount() {
	return coupon_amount;
}
public void setCoupon_amount(String coupon_amount) {
	this.coupon_amount = coupon_amount;
}
public String getSub_total() {
	return sub_total;
}
public void setSub_total(String sub_total) {
	this.sub_total = sub_total;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAvatar() {
	return avatar;
}
public void setAvatar(String avatar) {
	this.avatar = avatar;
}
public String getDefault_address_id() {
	return default_address_id;
}
public void setDefault_address_id(String default_address_id) {
	this.default_address_id = default_address_id;
}
public String getDelivery_pin() {
	return delivery_pin;
}
public void setDelivery_pin(String delivery_pin) {
	this.delivery_pin = delivery_pin;
}
public String getDelivery_guy_detail_id() {
	return delivery_guy_detail_id;
}
public void setDelivery_guy_detail_id(String delivery_guy_detail_id) {
	this.delivery_guy_detail_id = delivery_guy_detail_id;
}
public String getUser_is_active() {
	return user_is_active;
}
public void setUser_is_active(String user_is_active) {
	this.user_is_active = user_is_active;
}
public String getTax_number() {
	return tax_number;
}
public void setTax_number(String tax_number) {
	this.tax_number = tax_number;
}
public String getGoods() {
	return goods;
}
public void setGoods(String goods) {
	this.goods = goods;
}
	

}
