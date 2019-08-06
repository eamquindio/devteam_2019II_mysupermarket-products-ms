package co.edu.eam.ingesoft.stores_ms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.eam.ingesoft.stores_ms.model.Person;
import co.edu.eam.ingesoft.stores_ms.model.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products, String>{

}
