package co.edu.eam.ingesoft.stores_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.stores_ms.model.Products;
import co.edu.eam.ingesoft.stores_ms.repository.ProductsRepository;


@Service
public class ProductsService {
	
	//Inyecto el repositorio de productos
	@Autowired
	private ProductsRepository productsRepository;
	
	/**
	 * Metodo para crear un producto
	 * @author Cristian Sinisterra Rivera<br/>
	 *         email: cristiansinisterra@hotmail.com <br/>
	 *         Fecha: 6/08/2019<br/>
	 * @param products, producto que se desea crear
	 */
	public void create(Products products){
		productsRepository.save(products);
	}
	
	
	

}