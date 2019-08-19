
package co.edu.eam.ingesoft.products_ms.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity products.
 *
 * @author caferrerb
 *
 */
@Entity
public class Products implements Serializable {

/**
 * id atribute.
 */
@Id
private String id;

/**
 * name atribute.
 */
private String name;

/**
 * price atribute.
 */
private Double price;

/**
 * description atribute.
 */
private String description;
/**
 * category atribute.
 */
private String category;

/**
 * @return the id
 */
public final String getId() {
return id;
}

/**
 * @param id the id to set
 */
public void setId(String id) {
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
public void setName(final String name) {
this.name = name;
}

/**
 * @return the price
 */
public final Double getPrice() {
return price;
}

/**
 * @param price the price to set
 */
public void setPrice(final Double price) {
this.price = price;
}

/**
 * @return the description
 */
public final String getDescription() {
return description;
}

/**
 * @param description the description to set
 */
public void setDescription(String description) {
this.description = description;
}

/**
 * @return the category
 */
public final String getCategory() {
return category;
}

/**
 * @param category the category to set
 */
public void setCategory(final String category) {
this.category = category;
}

}

