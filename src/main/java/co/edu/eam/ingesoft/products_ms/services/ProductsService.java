package co.edu.eam.ingesoft.products_ms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.products_ms.model.Person;
import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productRepository;

	public List<Products> listAll() {
		return productRepository.findAll();
	}

	/**
	 * 
	 * @param name - this is used to list the search by name
	 * @return
	 */
	public List<Products> findByName(String name) {
		return productRepository.findByName(name);
	}
	
}
