package co.edu.eam.ingesoft.stores_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.stores_ms.model.Person;
import co.edu.eam.ingesoft.stores_ms.services.PersonService;

@RestController
@RequestMapping("api/stores-ms/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
    @PostMapping(value="/")
	public void create(@RequestBody Person person) {
		personService.create(person);
	}
	
    @GetMapping(value="/{id}")
	public Person find(@PathVariable Integer id) {
		return personService.find(id);
	}
}
