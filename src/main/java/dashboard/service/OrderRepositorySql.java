package dashboard.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dashboard.dao.Orders;
import dashboard.dto.OrderBaseResponseDTO;

@Repository
public interface OrderRepositorySql extends CrudRepository<Orders, Integer> {

	List<Orders> findAll();
	
	Orders findById(int id);
	
	@Query(value = "select count(distinct o.id) as total_count "
			 
			+ "FROM Orders o "
			+ "inner join Users u on o.user_id=u.id "
			+ "inner join OrderItem items on o.id=items.orderId "
			+ "where (:email is null or u.email=:email) "
			+ "and (:phone is null or u.phone = :phone) "
			+ "and (:username is null or u.userName = :username) "
			+ "and (:date is null or o.orderDate like :date) "
			+ "and (:restaurantId is null or o.restaurant_id = :restaurantId) "
			+ "and (:dateFrom is null or date(json_extract(o.orderDate, '$.date')) between date(:dateFrom) and date(:dateTo))"
//			+ "group by o.id "
			+ "having lower(group_concat(items.itemId, ',', items.quantity, ',', items.price, ',', items.itemName, ';')) like lower(:orderGoods) "
			+ "order by o.created_at desc",
			nativeQuery = false)
	Long findCountofAllOrdersJoinUsersWithAllFilters(@Param(value = "email") String email, 
																@Param("phone") String phone,
																@Param("username") String userName,
																@Param("date") String oredrDate,
																@Param("restaurantId") String restaurantId,
//																@Param("orderGoods") String goods,
																@Param("dateFrom") LocalDate from,
																@Param("dateTo") LocalDate to);

	
	@Query(value = "SELECT new dashboard.dto.OrderBaseResponseDTO(o.id, o.unique_order_id, o.orderstatus_id, o.user_id, o.coupon_name, o.address, o.tax, "
			+ "o.restaurant_charge, o.delivery_charge, o.total, o.payment_mode, o.order_comment, o.restaurant_id, o.transaction_id, o.delivery_type, o.payable, "
			+ "o.wallet_amount, o.tip_amount, o.tax_amount, o.coupon_amount, o.sub_total, o.created_at, o.is_scheduled, o.orderDate, o.orderTime, "
			+ "u.userName, u.phone, u.email, u.avatar, u.default_address_id, u.delivery_pin, u.delivery_guy_detail_id, u.userIs_active, u.tax_number, "
			+ "group_concat(items.itemId, ',', items.quantity, ',', items.price, ',', items.itemName, ';') as goods) "
			 
			+ "FROM Orders o "
			+ "inner join Users u on o.user_id=u.id "
			+ "inner join OrderItem items on o.id=items.orderId "
			+ "where (:email is null or u.email=:email) "
			+ "and (:phone is null or u.phone = :phone) "
			+ "and (:username is null or u.userName = :username) "
			+ "and (:date is null or o.orderDate like :date) "
			+ "and (:restaurantId is null or o.restaurant_id = :restaurantId) "
			+ "and (:dateFrom is null or date(json_extract(o.orderDate, '$.date')) between date(:dateFrom) and date(:dateTo))"
			+ "group by o.id "
			+ "having lower(group_concat(items.itemId, ',', items.quantity, ',', items.price, ',', items.itemName, ';')) like lower(:orderGoods) "
			+ "order by o.created_at desc",
			nativeQuery = false)
	Page<OrderBaseResponseDTO> findAllOrdersJoinUsersWithAllFilters(@Param(value = "email") String email, 
																@Param("phone") String phone,
																@Param("username") String userName,
																@Param("date") String oredrDate,
																@Param("restaurantId") String restaurantId,
																@Param("orderGoods") String goods,
																@Param("dateFrom") LocalDate from,
																@Param("dateTo") LocalDate to,
																Pageable pageable);
	
	
	@Query(value = "SELECT new dashboard.dto.OrderBaseResponseDTO(o.id, o.unique_order_id, o.orderstatus_id, o.user_id, o.coupon_name, o.address, o.tax, "
			+ "o.restaurant_charge, o.delivery_charge, o.total, o.payment_mode, o.order_comment, o.restaurant_id, o.transaction_id, o.delivery_type, o.payable, "
			+ "o.wallet_amount, o.tip_amount, o.tax_amount, o.coupon_amount, o.sub_total, o.created_at, o.is_scheduled, o.orderDate, o.orderTime, "
			+ "u.userName, u.phone, u.email, u.avatar, u.default_address_id, u.delivery_pin, u.delivery_guy_detail_id, u.userIs_active, u.tax_number, "
			+ "group_concat(items.itemId, ',', items.quantity, ',', items.price, ',', items.itemName, ';') as goods) "
			 
			+ "FROM Orders o "
			+ "inner join Users u on o.user_id=u.id "
			+ "inner join OrderItem items on o.id=items.orderId "
			+ "where (:email is null or u.email=:email) "
			+ "and (:phone is null or u.phone = :phone) "
			+ "and (:username is null or u.userName = :username) "
			+ "and (:date is null or o.orderDate like :date) "
			+ "and (:restaurantId is null or o.restaurant_id = :restaurantId) "
			+ "and (:dateFrom is null or date(json_extract(o.orderDate, '$.date')) between date(:dateFrom) and date(:dateTo))"
			+ "group by o.id "
			+ "order by o.created_at desc",
			nativeQuery = false)
	Page<OrderBaseResponseDTO> findAllOrdersJoinUserswithFilters(@Param(value = "email") String email, 
																@Param("phone") String phone,
																@Param("username") String userName,
																@Param("date") String oredrDate,
																@Param("restaurantId") String restaurantId,
																@Param("dateFrom") LocalDate from,
																@Param("dateTo") LocalDate to,
																Pageable pageable);
	
	@Query(value = "SELECT new dashboard.dto.OrderBaseResponseDTO(o.id, o.unique_order_id, o.orderstatus_id, o.user_id, o.coupon_name, o.address, o.tax, "
			+ "o.restaurant_charge, o.delivery_charge, o.total, o.payment_mode, o.order_comment, o.restaurant_id, o.transaction_id, o.delivery_type, o.payable, "
			+ "o.wallet_amount, o.tip_amount, o.tax_amount, o.coupon_amount, o.sub_total, o.created_at, o.is_scheduled, o.orderDate, o.orderTime, "
			+ "u.userName, u.phone, u.email, u.avatar, u.default_address_id, u.delivery_pin, u.delivery_guy_detail_id, u.userIs_active, u.tax_number, "
			+ "group_concat(items.itemId, ',', items.quantity, ',', items.price, ',', items.itemName, ';') as goods) "
			+ "FROM Orders o "
			+ "inner join Users u on o.user_id=u.id "
			+ "inner join OrderItem items on o.id=items.orderId " 
			+ "group by o.id "
			+ "order by o.created_at desc",
			nativeQuery = false)
	Page<OrderBaseResponseDTO> findAllOrdersJoinUsers(Pageable pageable);
	
	
	
	
	
	@Query(value = "select count(*)as total_count from orders",nativeQuery = true)
	int findTotalCountOrders();
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
}








