package co.edu.eam.ingesoft.productms.test.controllers;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import co.edu.eam.ingesoft.products_ms.Application;
import co.edu.eam.ingesoft.products_ms.model.Products;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;
import co.edu.eam.ingesoft.products_ms.routes.Router;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { Application.class })
public class ProductsControllerTest {

  @Autowired
  private MockMvc mockMvc;
 
  public static final String FIND_ALL_PRODUCTS = Router.PRODUCTS_PATH + Router.FIND_ALL_PRODUCTS;
  public static final String EDIT = Router.PRODUCTS_PATH + Router.EDIT_PRODUCTS;
  public static final String SAVE = Router.PRODUCT_PATH + Router.CREATE_PRODUCTS;
  public static final String FIND_BY_CATEGORY = Router.PRODUCT_PATH + Router.FIND_BY_CATEGORY;

  @Autowired
private ProductsRepository productsRepository;

  @Before
 public void beforeEach() {
   productsRepository.deleteAll();
  }
  @Test
  public void listAllTest() throws Exception {
    productsRepository.saveAll(Lists.list(new Products("1","Pc",(double) 1200,"Description","Portatil"),new Products("2","Mouse",(double) 100,"Description","G")));
    mockMvc.perform(get(FIND_ALL_PRODUCTS)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].name", is("Pc"))).andExpect(jsonPath("$[1].name", is("Mouse")));
  }
  @Test

  public void listAllEmptyTest() throws Exception {
    mockMvc.perform(get(FIND_ALL_PRODUCTS)).andExpect(status().isNoContent());
  }

  @Test
  public void save() throws Exception {
    String content = "{\"name\":\"cafe\",\"price\":\"1000\",\"category\":\"bebida\",\"description\":\"bebida\",\"id\":1 }";
    mockMvc.perform(post(SAVE).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    Products productToAssert = productsRepository.findById(new String("1")).get();
    assertEquals("cafe", productToAssert.getName());
    assertEquals(new String("1"), productToAssert.getId());
  }

  @Test
  public void saveAlreadyExists() throws Exception {
    productsRepository.saveAll(Lists.list(new Products("1", "cafe", (double) 1000, "bebida", "bebida")));
    String content = "{\"name\":\"cafe\",\"price\":\"1000\",\"category\":\"bebida\",\"description\":\"bebida\",\"id\":1 }";
    mockMvc.perform(post(SAVE).content(content).contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().is(409));
  }
  
  @Test
  public void listByCategoryEmptyTest() throws Exception {
    mockMvc.perform(get(FIND_BY_CATEGORY + "?category=lacteos")).andExpect(status().isNoContent());
  }
  
  @Test
  public void listByCatgegory() throws Exception {

    productsRepository.saveAll(Lists.list(new Products("1", "leche", (double) 2000, "bebida", "lacteos")));

    mockMvc.perform(get(FIND_BY_CATEGORY + "?category=lacteos")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].category", is("lacteos")));
  }
  
  @Test
  public void edit() throws Exception {
    productsRepository.saveAll(Lists.list(new Products("1", "camilo", 12.000, "products", "electonic")));
    String content = "{\"name\":\"claudia\",\"id\":\"1\",\"price\":12.000,\"description\":\"products\",\"category\":\"electronic 2\" }";
    mockMvc.perform(put(EDIT).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    Products productsToAssert = productsRepository.findById(new String("1")).get();
    assertEquals("claudia", productsToAssert.getName());
    assertEquals(new String("1"), productsToAssert.getId());
    assertEquals(new Double(12.000), productsToAssert.getPrice());
    assertEquals("products", productsToAssert.getDescription());
    assertEquals("electronic 2", productsToAssert.getCategory());

  }

  @Test
  public void editNotExists() throws Exception {
    String content = "{\"name\":\"claudia\",\"id\":\"3\",\"price\":12.000,\"description\":\"products\",\"category\":\"electronic\" }";

    mockMvc.perform(put(EDIT).content(content).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

}
