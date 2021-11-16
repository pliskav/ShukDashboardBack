package dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dashboard.dto.OrderBaseResponseDTO;
import dashboard.dto.PageDTO;
import dashboard.service.IOrders;
import dashboard.service.IService;
import dashboard.service.ItemRepository;
import dashboard.service.OrderItemRepository;
import dashboard.service.OrderRepositorySql;
import dashboard.service.UserRepositorySql;

@CrossOrigin
@RestController
@RequestMapping()
public class DashboardController {
	
	@Autowired
	OrderRepositorySql repositorySql;
	@Autowired
	UserRepositorySql userRepositorySql;
	@Autowired
	IService service;
	@Autowired
	IOrders serviceOrders;
	@Autowired
	ItemRepository itemRepo;
	@Autowired
	OrderItemRepository orderItemRepo;
	
	
	@GetMapping("/")
	public PageDTO getAllOrders(
			@RequestParam(required=false) Integer current_page,
			@RequestParam(required=false) Integer items_on_page
			){
		if(current_page == null || items_on_page == null) {
			return serviceOrders.getAllOrders(0, 5);
		}
		else {
			return serviceOrders.getAllOrders(current_page, items_on_page);
		}	
	}
	
	
	@PutMapping("/order/{orderId}")
	public void editOrder(
			@RequestBody OrderBaseResponseDTO order,
			@PathVariable Integer orderId
			) {
			serviceOrders.editOrder(orderId, order);
	}
//	@PostMapping("/send-whatsapp")
//	public Boolean sendWhatsapp(@RequestBody String orderId) {
//		 serviceOrders.sendWhatsapp(orderId);
//		 return true;
//		 
//	}
	
//	@GetMapping("/items")
//	public List<Item> getallItems(){
//		return itemRepo.findAll();
//	}
//	
//	@GetMapping("/orderitems")
//	public List<OrderItem> getAllOrderItems(){
//		return orderItemRepo.findAll();
//	}
//	
//	
//	@GetMapping("/users")
//	public List<UserSql> getallUserSqls(){
//		return userRepositorySql.findAll();
//	}
//	
//	@PostMapping("/users")
//	public List<UserSql> getallUsersByIds(@RequestBody Iterable<Integer> ids) {
//		return service.findAllUsersById(ids);	
//	}
//	@PostMapping("/user/{id}")
//	public UserSql getuserbyid(@PathVariable int id) {
//		return userRepositorySql.findById(id);
//	}
//	@PostMapping("/order/{id}")
//	public OrderSql getorder(@PathVariable int id) {
//		return repositorySql.findById(id);
//	}
	
 
}
