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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.eam.ingesoft.products_ms.services.ProductsService;

/**
 * REst controller for products entity. Products controller.
 *
 * Products controller.
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
  /**
   * list products to category.
   *
   * @param category category
   * @return list to products
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
	/**
	 * 
	 * @param id id product to delete
	 */
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable String id) {
	  productsService.delete(id);
	}
  /**
   * Method found by name.
   *
   * @param name name
   * @return list of products
   */
  @GetMapping(value = "/find_by_name")
  public List<Products> findByName(@RequestParam String name) {
    System.out.println(name);
    return productsService.findByName(name);
  }
}
