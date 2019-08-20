package co.edu.eam.ingesoft.products_ms.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;

public class ProductsService {

	@Autowired
	private ProductsRepository productRepository;
	/**
	 * Method found by category
	 * @param category,data type String
	 * @return,by category the products
	 */
	public List<Products> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}
}
