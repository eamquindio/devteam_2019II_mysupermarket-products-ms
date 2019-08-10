package co.edu.eam.ingesoft.products_ms.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.products_ms.model.Person;
import co.edu.eam.ingesoft.products_ms.model.Products;

@RestController
@RequestMapping("api/products-ms/xxxx")
public class ProductsController {
	
	 @GetMapping(value="/all")
		public List<Products> findAll() {
	    	return productService.listAll();
		}

}
