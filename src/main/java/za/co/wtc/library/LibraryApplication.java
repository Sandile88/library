package za.co.wtc.library;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import za.co.wtc.library.dto.AddressDTO;
import za.co.wtc.library.dto.CustomerDto;
import za.co.wtc.library.model.Address;
import za.co.wtc.library.model.Customer;
import za.co.wtc.library.service.CustomerServiceImpl;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

  @Autowired
  private CustomerServiceImpl customerService;

  public static void main(String[] args) {
    SpringApplication.run(
        LibraryApplication.class, args);

  }

  @Override
  public void run(String... args) throws Exception {
//    CustomerDto customer1 = new CustomerDto();
//    customer1.setName("Test");
//    AddressDTO address1 = new AddressDTO();
//    address1.setAddress1("Test line");
//    customer1.setAddressDTOS(Set.of(address1));
//    customerService.addCustomer(customer1);
  }
}
