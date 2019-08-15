package co.edu.eam.ingesoft.products_ms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.products_ms.model.Person;
import co.edu.eam.ingesoft.products_ms.repositories.PersonRepository;

/**
 * Service to perform bussines operations over Person entity.
 *
 * @author caferrerb
 *
 */
@Service
public class PersonService {

  /**
   * PErson repository.
   */
  @Autowired
  private PersonRepository personRespository;

  /**
   * Craete a person.
   *
   * @param person person to create.
   */
  public void create(Person person) {
    personRespository.save(person);
  }

  /**
   * Update a person.
   *
   * @param person person to update.
   */
  public void update(Person person) {
    personRespository.save(person);
  }

  /**
   * Find a person.
   *
   * @param id id to ind the person
   * @return the person found
   */
  public Person find(Integer id) {
    return personRespository.findById(id).get();
  }

  /**
   * Delete a person.
   *
   * @param id id to delete
   */
  public void delete(Integer id) {
    personRespository.deleteById(id);
  }

  /**
   * List all persons.
   *
   * @return list of all persons
   */
  public List<Person> listAll() {
    return personRespository.findAll();
  }

  /**
   * List persons by name.
   *
   * @param name name to looking for
   * @return list fo person with a name.
   */
  public List<Person> findByName(String name) {
    return personRespository.findByName(name);
  }

}
