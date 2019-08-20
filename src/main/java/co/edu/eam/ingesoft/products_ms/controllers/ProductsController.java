package co.edu.eam.ingesoft.products_ms.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.eam.ingesoft.products_ms.model.Products;
import org.springframework.web.bind.annotation.*;
import co.edu.eam.ingesoft.products_ms.services.ProductsService;
@RequestMapping("api/products-ms/products")
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	
	@GetMapping(value="/find_by_category")
		public List<Products> findByCategory(@RequestParam String category) {
		   System.out.println(category);
		   return productsService.findByCategory(category);
			}	
}
