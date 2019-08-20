package co.edu.eam.ingesoft.products_ms.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.services.ProductsService;


@RestController
@RequestMapping("api/products-ms/products")
public class ProductsController {
  @Autowired
  private ProductsService productsService;

  @GetMapping(value="/find_by_category")
  public List<Products> findByCategory(@RequestParam String category) {
    return productsService.findByCategory(category);
 }
}
