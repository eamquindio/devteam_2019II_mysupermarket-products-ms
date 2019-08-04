package co.edu.eam.ingesoft.products_ms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.products_ms.model.Person;
import co.edu.eam.ingesoft.products_ms.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRespository;
	
	public void create(Person person) {
		personRespository.save(person);
	}
	
	public void update(Person person) {
		personRespository.save(person);
	}
	
	public Person find(Integer id) {
		return personRespository.findById(id).get();
	}
	
	public void delete(Integer id) {		
		personRespository.deleteById(id);
	}
	
	public List<Person> listAll() {
		return personRespository.findAll();
	}
	
	public List<Person> findByName(String name) {
		return personRespository.findByName(name);
	}
	
}
