package dashboard.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	int id;
	@Column(name = "name")
	String userName;
	String email;
	String email_verified_at;
	String password;
	String remember_token; 
	String created_at;
	String updated_at; 
	String auth_token; 
	String phone;
	String second_phone;
	String default_address_id; 
	String delivery_pin;
	String delivery_guy_detail_id; 
	String avatar;
	@Column(name = "is_active")
	String userIs_active; 
	String tax_number;
	int default_language;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_verified_at() {
		return email_verified_at;
	}
	public void setEmail_verified_at(String email_verified_at) {
		this.email_verified_at = email_verified_at;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemember_token() {
		return remember_token;
	}
	public void setRemember_token(String remember_token) {
		this.remember_token = remember_token;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getAuth_token() {
		return auth_token;
	}
	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getUserIs_active() {
		return userIs_active;
	}
	public void setUserIs_active(String userIs_active) {
		this.userIs_active = userIs_active;
	}
	public String getTax_number() {
		return tax_number;
	}
	public void setTax_number(String tax_number) {
		this.tax_number = tax_number;
	}
	public Users(int id, String userName, String email, String email_verified_at, String password,
			String remember_token, String created_at, String updated_at, String auth_token, String phone,
			String default_address_id, String delivery_pin, String delivery_guy_detail_id, String avatar,
			String userIs_active, String tax_number) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.email_verified_at = email_verified_at;
		this.password = password;
		this.remember_token = remember_token;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.auth_token = auth_token;
		this.phone = phone;
		this.default_address_id = default_address_id;
		this.delivery_pin = delivery_pin;
		this.delivery_guy_detail_id = delivery_guy_detail_id;
		this.avatar = avatar;
		this.userIs_active = userIs_active;
		this.tax_number = tax_number;
	}
	public Users() {
		super();
	}
	public int getDefault_language() {
		return default_language;
	}
	public void setDefault_language(int default_language) {
		this.default_language = default_language;
	}
	
	
	
	
	
}
