package dashboard.dto;

import dashboard.dao.ItemData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDataDto {
	Integer quantity;
	float price;
	String name;
	
}
