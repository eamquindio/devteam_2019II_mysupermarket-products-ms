package co.edu.eam.ingesoft.products_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.products_ms.model.Person;
import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.services.PersonService;
import co.edu.eam.ingesoft.products_ms.services.ProductsService;

@RestController
@RequestMapping("api/products-ms/products")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@PutMapping(value="/")
	public void edit(@RequestBody Products products) {
		productsService.update(products);
	}

}
