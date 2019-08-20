package co.edu.eam.ingesoft.products_ms.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.eam.ingesoft.products_ms.model.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products, String> {
	/**
	 * Method that list the products by category.
	 * category, data type String.
	 * return the products by their category.
	 */
	List<Products> findByCategory(String category);
	}
