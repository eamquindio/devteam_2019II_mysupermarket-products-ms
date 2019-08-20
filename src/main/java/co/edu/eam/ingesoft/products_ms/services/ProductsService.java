package co.edu.eam.ingesoft.products_ms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;

/**
 * Bussiness class for product Entity.
 *
 * @author caferrerb
 *
 */
@Service
public class ProductsService {

  /**
   * product repository.
   */
  @Autowired
  private ProductsRepository productRepository;

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
}
