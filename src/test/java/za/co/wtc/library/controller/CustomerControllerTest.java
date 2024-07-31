package za.co.wtc.library.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import za.co.wtc.library.exception.LibraryExceptionHandler;
import za.co.wtc.library.model.Customer;
import za.co.wtc.library.service.CustomerService;

@WebMvcTest(CustomerController.class)
@ContextConfiguration(classes = {CustomerController.class, LibraryExceptionHandler.class})
class CustomerControllerTest {

  @MockBean
  private CustomerService customerService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testFindByIdNumberSuccess() throws Exception {

    Mockito.when(customerService.findByIdNumber(Mockito.anyString()))
            .thenReturn(new Customer());

    mockMvc.perform(MockMvcRequestBuilders.get("/customers/10000")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

  }

  @Test
  public void testFindByIdNumberError() throws Exception {

    Mockito.when(customerService.findByIdNumber(Mockito.anyString()))
        .thenThrow(RuntimeException.class);

    mockMvc.perform(MockMvcRequestBuilders.get("/customers/10000")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isInternalServerError());

  }
}