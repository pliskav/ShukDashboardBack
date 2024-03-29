package dashboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dashboard.dao.Store;


@Repository
public interface StoreRepository  extends CrudRepository<Store, Integer> {
	List<Store> findAllById (Iterable<Integer> ids);
	Optional<Store> findById(Integer id);
}
