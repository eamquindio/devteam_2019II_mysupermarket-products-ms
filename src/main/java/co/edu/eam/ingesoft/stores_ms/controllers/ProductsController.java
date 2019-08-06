package co.edu.eam.ingesoft.stores_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.stores_ms.model.Products;
import co.edu.eam.ingesoft.stores_ms.services.ProductsService;


@RestController
@RequestMapping("api/products-ms/products")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	/**
	 * Metodo que llama al servicio realizado para crear un producto
	 * @author Cristian Sinisterra Rivera<br/>
	 *         email: cristiansinisterra@hotmail.com <br/>
	 *         Fecha: 6/08/2019<br/>
	 * @param products
	 */
	    @PostMapping(value="/")
		public void create(@RequestBody Products products) {
	   productsService.create(products);
		}

}
