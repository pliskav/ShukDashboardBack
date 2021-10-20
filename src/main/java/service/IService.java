package service;

import java.util.List;

import dao.UserSql;

public interface IService {
	
	public List<UserSql> findAllUsers();
	
	public UserSql findUserById(int Id);
	
	List<UserSql> findAllUsersById(Iterable<Integer> ids);
}
