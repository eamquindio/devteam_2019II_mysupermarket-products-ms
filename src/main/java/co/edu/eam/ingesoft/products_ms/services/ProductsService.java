package co.edu.eam.ingesoft.products_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;

/**
 * Bussiness class for product Entity.
 *
 * @author caferrerb
 *
 */
@Service
public class ProductsService {

  /**
   * product repository.
   */
  @Autowired
  private ProductsRepository productRepository;

}
