package co.edu.eam.ingesoft.products_ms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity person.
 *
 * @author caferrerb
 *
 */
@Entity
public class Person implements Serializable {

  /**
   * Entity Primary key.
   */
  @Id
  private Integer id;

  /**
   * Person`s name.
   */
  @Column(name = "name")
  private String name;

  /**
   * @return the id
   */
  public final Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public final void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public final String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public final void setName(String name) {
    this.name = name;
  }

}
