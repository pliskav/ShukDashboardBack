package dashboard.service;

import java.util.List;


import dashboard.dao.Store;

public interface IStore {
	public List<Store> getAllStoreById(List<Integer> ids);
}
