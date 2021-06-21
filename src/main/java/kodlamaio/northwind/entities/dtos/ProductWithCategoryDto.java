package kodlamaio.northwind.entities.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {

	private int productId;
	
	private String productName;
	
	private String categoryName;
	
	
}
