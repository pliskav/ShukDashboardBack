package service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dao.OrderSql;
import dto.OrderBaseResponseDTO;
@Repository
public interface OrderRepositorySql extends CrudRepository<OrderSql, Integer> {

	List<OrderSql> findAll();
	
	OrderSql findById(int id);
	
	@Query(value = "SELECT o.id, o.unique_order_id, o.orderstatus_id, o.user_id, o.coupon_name, o.address, o.tax, o.restaurant_charge, o.delivery_charge, o.total, o.payment_mode, o.order_comment, o.restaurant_id, o.transaction_id, o.delivery_type, o.payable, o.wallet_amount, o.tip_amount, o.tax_amount, o.coupon_amount, o.sub_total, u.name as userName, u.phone, u.email, u.avatar, u.default_address_id, u.delivery_pin, u.delivery_guy_detail_id, u.is_active as user_is_active, u.tax_number, items.order_id as itemOrderId, items.item_id, items.name as itemName, items.price, items.quantity, i.old_price, i.image, i.item_category_id, i.is_recommended, i.is_popular, i.is_new, i.desc, i.placeholder_image, i.is_active as item_is_active, i.is_veg, i.order_column FROM shuk.orders as o inner join shuk.users as u on o.user_id=u.id inner join shuk.orderitems as items on o.id=items.order_id inner join shuk.items as i on i.id=items.item_id", nativeQuery = true)
	List<OrderBaseResponseDTO> findAllOrdersJoinUsers();
}






