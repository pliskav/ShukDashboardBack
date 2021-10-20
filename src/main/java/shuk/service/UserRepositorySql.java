package shuk.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import shuk.dao.UserSql;
@Repository
public interface UserRepositorySql extends CrudRepository<UserSql, Integer> {
	
	List<UserSql> findAll();
	
	UserSql findById(int Id);
	
	List<UserSql> findAllById (Iterable<Integer> ids);

}
