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
	
	String i_uniqueOrderId;
	int j_orderStatusId;
	int k_userId;
	String b_userName;
	String c_userPhone;
	String d_userSecondPhone;
	String e_address;
	String h_storeName;
	String f_orderDate;
	String a_total;
	HashMap<String,String> g_itemData;

}
