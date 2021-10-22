package dashboard.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dashboard.dao.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
	
	List<OrderItem> findAll();
	
	List<OrderItem> findAllByOrderId(int orderid);
	
	OrderItem findById(int id);
	
	
}
	
//	static List<OrderItem> findOrderInnerJoin(){
//		String queryString = ""; 
//		return executeQuery(queryString);
//	}
//	List<ArticleWithAuthor> articleInnerJoinAuthor() {
//	    String query = "SELECT ARTICLE.TITLE, AUTHOR.LAST_NAME, AUTHOR.FIRST_NAME "
//	      + "FROM ARTICLE INNER JOIN AUTHOR ON AUTHOR.ID=ARTICLE.AUTHOR_ID";
//	    return executeQuery(query);
//	}

