package co.edu.eam.ingesoft.stores_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.stores_ms.model.Person;
import co.edu.eam.ingesoft.stores_ms.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRespository;
	
	public void create(Person person) {
		personRespository.save(person);
	}
	
	public Person find(Integer id) {
		return personRespository.findById(id).get();
	}
}
