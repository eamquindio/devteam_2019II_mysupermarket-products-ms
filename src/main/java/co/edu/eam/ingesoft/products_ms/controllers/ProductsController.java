package co.edu.eam.ingesoft.products_ms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.products_ms.model.Products;

@RestController
@RequestMapping("api/products-ms/products")
public class ProductsController {

	
	private ProductsController productsService;

	@GetMapping(value="/{id}")
	public Products find(@PathVariable Integer id) {
		productsService = null;
		return productsService.find(id);
	}
}
