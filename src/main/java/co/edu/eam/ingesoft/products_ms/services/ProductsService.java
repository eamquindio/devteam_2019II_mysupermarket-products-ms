package co.edu.eam.ingesoft.products_ms.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;
/**
 * Service to perform bussines operations over Products entity.
 *
 * Bussiness class for product Entity.
 *
 * @author caferrerb
 *
 */
@Service
public class ProductsService {

  /**
   * Products repository.
   */
  @Autowired
  private ProductsRepository productRepository;
  /**
   * Find all products.
   *
   * @return list products.
   */
  public List<Products> listAll() {
    return productRepository.findAll();
  }
  /**
   * Method found by category.
   *
   * @param category data type String.
   * @return by category the products.
   */
  public List<Products> findByCategory(String category) {
    return productRepository.findByCategory(category);
  }
  /**
   * Update a products.
   *
   * @param product product to update.
   */
  public void update(Products product) {
    productRepository.save(product);
  }
  /**
   * List products by name.
   *
   * @param name name to looking for
   * @return list of products with a name.
   */
  public List<Products> findByName(String name) {
    return productRepository.findByName(name);
  }
  /**
   * Delete a product.
   *
   * @param id id to delete
   */
  public void delete(String id) {
    productRepository.deleteById(id);
  }
}
