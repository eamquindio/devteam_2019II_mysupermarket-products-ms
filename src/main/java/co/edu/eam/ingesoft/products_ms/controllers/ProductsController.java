package co.edu.eam.ingesoft.products_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.products_ms.services.ProductsService;

/**
 * Products controller.
 * @author caferrerb
 *
 */
@RestController
@RequestMapping("api/products-ms/products")
public class ProductsController {

  /**
   * product service.
   */
  @Autowired
  private ProductsService productsService;

}
