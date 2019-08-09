package co.edu.eam.ingesoft.products_ms.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productRepository;
	
	/**
	 * method for delete product in the store
	 * @param id take the id respective product to delete
	 */
	public void delete(String id) {
		productRepository.deleteById(id);
	}

	/**
	 * Metodo para crear un producto
	 * 
	 * @author Cristian Sinisterra Rivera<br/>
	 *         email: cristiansinisterra@hotmail.com <br/>
	 *         Fecha: 6/08/2019<br/>
	 * @param products, producto que se desea crear
	 */

	public void create(Products products){
		productRepository.save(products);
	}

	public List<Products> listAll() {
		return productRepository.findAll();
	}

	/**
	 * 
	 * @param name - this is used to list the search by name
	 * @return
	 */
	public List<Products> findByName(String name) {
		return productRepository.findByName(name);
	}
	
}
