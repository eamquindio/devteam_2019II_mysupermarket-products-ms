package co.edu.eam.ingesoft.products_ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(value = "/all")
	public List<Products> findAll() {
		return productsService.listAll();
	}

	@GetMapping(value = "/find_by_name")
	public List<Products> findByName(@RequestParam String name) {
		System.out.println(name);
		return productsService.findByName(name);
	}

	/**
	 * Metodo que llama al servicio realizado para crear un producto
	 * 
	 * @author Cristian Sinisterra Rivera<br/>
	 *         email: cristiansinisterra@hotmail.com <br/>
	 *         Fecha: 6/08/2019<br/>
	 * @param products
	 */
	@PostMapping(value = "/")
	public void create(@RequestBody Products products) {
		productsService.create(products);
	}

}
