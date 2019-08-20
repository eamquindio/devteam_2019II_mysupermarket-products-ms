package co.edu.eam.ingesoft.products_ms.services;
import java.util.List;
import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;
/**
 * 
 * @author juan
 *
 */
public class ProductsService {

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
