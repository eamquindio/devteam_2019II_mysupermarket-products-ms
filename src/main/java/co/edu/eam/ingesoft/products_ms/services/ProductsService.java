package co.edu.eam.ingesoft.products_ms.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;

/**
 * Service to perform bussines operations over Products entity. Bussiness class
 * for product Entity.
 *
 * @author caferrerb.
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
   * @param products products to update.
   * @return products edited
   */
  public Products update(Products products) {
    Products productsToUpdate = find(products.getId());

    if (productsToUpdate == null) {
      throw new EntityNotFoundException("products not exists");
    }

    return productRepository.save(products);
  }

  /**
   * List products by name.
   *
   * @param name name to looking for.
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

  /**
   * Metodo para crear un producto.
   *
   * @author Cristian Sinisterra Rivera.<br/>
   *         email: cristiansinisterra@hotmail.com<br/>
   *         Fecha: 6/08/2019<br/>
   * @param products producto que se desea crear.
   */
  public void create(Products products) {
    productRepository.save(products);
  }

  /**
   * Find a product.
   *
   * @param id id to ind the product
   * @return the product found
   */
  public Products find(String id) {
    return productRepository.findById(id).orElse(null);
  }
}
