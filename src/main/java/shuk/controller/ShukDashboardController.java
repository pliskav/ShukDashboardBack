package shuk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shuk.dto.OrderResponseDTO;
import shuk.service.IOrders;
import shuk.service.IService;
import shuk.service.ItemRepository;
import shuk.service.OrderItemRepository;
import shuk.service.OrderRepositorySql;
import shuk.service.UserRepositorySql;

@CrossOrigin
@RestController
@RequestMapping()
public class ShukDashboardController {
	
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
	public Map<String, OrderResponseDTO> getAllOrders() {
		return serviceOrders.getAllOrders();
	}
	
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
