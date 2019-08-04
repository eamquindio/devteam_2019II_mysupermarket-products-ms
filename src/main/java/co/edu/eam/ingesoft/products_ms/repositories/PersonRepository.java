package co.edu.eam.ingesoft.products_ms.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.eam.ingesoft.products_ms.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

	List<Person> findAll();
	
	List<Person> findByName(String name);
}
