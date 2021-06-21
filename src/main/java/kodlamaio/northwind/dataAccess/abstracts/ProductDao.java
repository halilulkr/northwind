package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer>{

	  Product getByProductName(String productName);
	  
	  //list dönmediğimiz için ilk bulduğu veriyi getirecek.
	  Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	  
	  //İki koşula da aynı anda bağlı olmadığı için birden fazla ürü gelebilir o yüzzden list döndük.
	  List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	  
	  //Bu metot Category içinden tipi integer olanları gönder demek yani id'leri.
	  List<Product> getByCategoryIn(List<Integer> categories);
	  
	  List<Product> getByProductNameContains(String productName);
	  
	  //Ürün ismiyle başlayanları getir demek
	  List<Product> getByProductNameStartsWith(String productName);
	  
	  //list döndüğümüz için bulduğu bütün veriyi getirecek.
	  //jpql sql sorgusunu entitylerimizde ki sütunlar üzerinden yazıyoruz.
	  @Query("From Product where productName=:productName and category.categoryId=:categoryId")
	  List<Product> getByNameAndCategory(String productName, int categoryId);
	  
	  @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	  List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
