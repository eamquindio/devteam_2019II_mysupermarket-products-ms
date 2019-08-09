package co.edu.eam.ingesoft.products_ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.products_ms.model.Person;
import co.edu.eam.ingesoft.products_ms.services.PersonService;

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
    
    @DeleteMapping(value="/{id}")
	public void delete(@PathVariable Integer id) {
    	personService.delete(id);
	}
    
    @PutMapping(value="/")
	public void edit(@RequestBody Person person) {
		personService.create(person);
	}
    
    @GetMapping(value="/find_by_name/")
	public List<Person> findByName(@RequestParam String name) {
    	System.out.println(name);
    	return personService.findByName(name);
	}
    
    @GetMapping(value="/all")
	public List<Person> findAll() {
    	return personService.listAll();
	}
}
