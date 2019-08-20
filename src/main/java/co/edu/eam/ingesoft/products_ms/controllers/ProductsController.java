package co.edu.eam.ingesoft.products_ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.services.ProductsService;

/**
 * Products controller.
 *
 * @author caferrerb
 */
@RestController
@RequestMapping("api/products-ms/products")
public class ProductsController {
  /**
   * product service.
   */
  @Autowired
  private ProductsService productsService;

  /**
   * Method found by category.
   *
   * @param category data type String.
   * @return by category the products.
   */
  @GetMapping(value = "/find_by_category")
  public List<Products> findByCategory(@RequestParam String category) {
    return productsService.findByCategory(category);
  }

  /**
   * Edit a products.
   *
   * @param product product to edit
   */
  @PutMapping(value = "/")
  public void edit(@RequestBody Products product) {
    productsService.update(product);
  }

}
