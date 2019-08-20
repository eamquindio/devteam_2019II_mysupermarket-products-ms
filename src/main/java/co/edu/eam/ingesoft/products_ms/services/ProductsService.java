package co.edu.eam.ingesoft.products_ms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;

/**
 * Service to perform bussines operations over Products entity.
 *
 * @author caferrerb
 *
 */

@Service
public class ProductsService {
  /**
   * Products repository.
   */
@Autowired
private ProductsRepository productRepository;
  /**
 * Find all products.
 * @return list products.
 */
public List<Products> listAll() {
return productRepository.findAll();
}

}
