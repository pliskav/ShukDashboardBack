package service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dao.Item;
@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
	
	List<Item> findAll();
	Item findById(int id);
}
