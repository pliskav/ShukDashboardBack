package dashboard.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dashboard.dao.OrderItem;
import dashboard.dto.ItemBriefDTO;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
	
	List<OrderItem> findAll();
	
	List<OrderItem> findAllById(Iterable<Integer> ids);
	
	List<OrderItem> findAllByOrderId(int orderid);
	
	OrderItem findById(int id);
	
//	SELECT shuk.orderitems.name,
//	(case when ISNULL(shuk.order_item_addons.addon_name) then SUM(shuk.orderitems.quantity) else sum(shuk.order_item_addons.addon_name)  end)   as total_items_addon
//FROM shuk.orderitems  
//left join shuk.order_item_addons on shuk.orderitems.id=shuk.order_item_addons.orderitem_id
//join shuk.orders on shuk.orders.id=shuk.orderitems.order_id
//where shuk.orders.unique_order_id = 'OD-10-19-TURZ-QG8LPB35N'
//GROUP BY shuk.orderitems.name
	
//	Integer id;
//	String name;
//  float price;
//	String image; 
// Integer quantity;
//	Integer limit;
//	Integer total;
	// Integer total_items_addon
	
//	Integer id, String name, float price, String image, Integer quantity, Integer limit,
//		Integer total_items_addon
	
	@Query(value = "SELECT new dashboard.dto.ItemBriefDTO(orderItems.id, orderItems.itemName, orderItems.price, item.image, orderItems.quantity, item.limit, "+
	"coalesce( SUM(addons.addonName), SUM(orderItems.quantity)))" +
			"FROM OrderItem orderItems " + 
			"left join OrderItemAddons addons on orderItems.id=addons.orderItemId "+
			"inner join Item item on orderItems.itemId=item.id "+
			"group by orderItems.itemId",
			nativeQuery = false)
	List<ItemBriefDTO> findAllNewItems();
	
	
}