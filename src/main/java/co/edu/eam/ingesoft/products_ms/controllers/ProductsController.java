package co.edu.eam.ingesoft.products_ms.controllers;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.routes.Router;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import co.edu.eam.ingesoft.products_ms.services.ProductsService;

/**
 * REst controller for products entity. Products controller.
 * Products controller.
 * @author caferrerb.
 */
@RestController
@RequestMapping(Router.PRODUCTS_PATH)
public class ProductsController {
  /**
   * products service.
   */
  @Autowired
  private ProductsService productsService;
  /**
   * list all persons.
   * @param response httpresponse
   * @return list of all persons
   */
  @GetMapping(value = Router.FIND_ALL_PRODUCTS)
  public List<Products> findAll(HttpServletResponse response) {
    List<Products> products = productsService.listAll();

    if (products.isEmpty()) {
      response.setStatus(HttpStatus.NO_CONTENT.value());
    }

    return products;
  }
  /**
   * list products to category.
   * @param category category.
   * @return list to product.s
   */

  @GetMapping(value = "/find_by_category")
  public List<Products> findByCategory(@RequestParam String category) {
    return productsService.findByCategory(category);
  }
  /**
   * Edit a products.
   * @param product product
   * @return product to edit.
   */
  @PutMapping(value = Router.EDIT_PRODUCTS)
  public Products edit(@RequestBody Products product) {
    return productsService.update(product);
  }
  /**
   * @param id id product to delete
   */
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable String id) {
    productsService.delete(id);
  }
  /**
   * Method found by name.
   * @param name name.
   * @return list of products.
   */
  @GetMapping(value = "/find_by_name")
  public List<Products> findByName(@RequestParam String name) {
    System.out.println(name);
    return productsService.findByName(name);
  }

  /**
   * Metodo que llama al servicio realizado para crear un producto.
   * @author Cristian Sinisterra Rivera.<br/>
   * email: cristiansinisterra@hotmail.com.<br/>
   * Fecha: 6/08/2019<br/>
   * @param products que se desea crear.
   */
  @PostMapping(value = Router.CREATE_PRODUCTS)
  public void create(@RequestBody Products products) {
    productsService.create(products);
  }

}
