package co.edu.eam.ingesoft.productms.test.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import co.edu.eam.ingesoft.products_ms.Application;
import co.edu.eam.ingesoft.products_ms.repositories.ProductsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { Application.class })
public class ProductsControllerTest {

  @Autowired
  private MockMvc mockMvc;

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
}
