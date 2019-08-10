package co.edu.eam.ingesoft.products_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	
	public Products find(Integer id) {
		return productsRepository.findById(id).get();
	}
}
