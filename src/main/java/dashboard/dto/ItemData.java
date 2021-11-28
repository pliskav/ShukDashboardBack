package dashboard.dto;

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
public class ItemData {
	Integer id;
	Integer quantity;
	Integer orderId;
	float price;
	@Override
	public String toString() {
		return "ItemData [id=" + id + ", quantity=" + quantity + ", orderId=" + orderId + ", price=" + price + "]";
	}
	
	
}
