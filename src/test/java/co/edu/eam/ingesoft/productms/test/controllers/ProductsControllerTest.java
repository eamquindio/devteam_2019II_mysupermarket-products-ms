package co.edu.eam.ingesoft.productms.test.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

  public static final String EDIT = Router.PRODUCTS_PATH + Router.EDIT_PRODUCTS;

  @Autowired
  private ProductsRepository productsRepository;

  @Before
  public void beforeEach() {
    productsRepository.deleteAll();
  }

  @Test
  public void test() {
    assertTrue(true);
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
