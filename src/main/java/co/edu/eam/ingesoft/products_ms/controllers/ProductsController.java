package co.edu.eam.ingesoft.products_ms.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.services.ProductsService;

/**
 * REst controller for products entity.
 *
 * @author caferrerb
 *
 */

@RestController

@RequestMapping("api/products-ms/products")
public class ProductsController {

  /**
   * products service.
   */
@Autowired
private ProductsService productsService;

  /**
   * list all products.
   *
   * @return list of all products
   */
@GetMapping(value = "/all")
public List<Products> findAll() {
return productsService.listAll();
}

}

