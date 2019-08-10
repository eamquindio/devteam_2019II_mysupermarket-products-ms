package co.edu.eam.ingesoft.products_ms.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.eam.ingesoft.products_ms.model.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products, String> {
	List<Products> findAll();
	List<Products> findByName(String name);
}
