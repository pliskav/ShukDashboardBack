package dashboard.dto;

import java.util.HashMap;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ForXls {
	String id;
	String uniqueOrderId;
	int orderStatusId;
	int userId;
	String userName;
	String UserPhone;
	String userSecondPhone;
	String address;
	String storeName;
	String orderDate;
	String total;
	HashMap<String,Integer> itemData;

}
