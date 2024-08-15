package za.co.wtc.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.wtc.library.dto.CustomerDto;
import za.co.wtc.library.model.Customer;
import za.co.wtc.library.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {


  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{idNumber}",
        produces = {"application/json"})
    public ResponseEntity<CustomerDto> findByIdNumber(@PathVariable("idNumber") String idNumber) {
    CustomerDto customer = customerService.findByIdNumber(idNumber);
      if (customer != null) {
        return new ResponseEntity<>(customer, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

      }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{email}",
    produces = {"application/json"})
    public ResponseEntity<Customer> findByEmail(@PathVariable("email") String email) {
    Customer customer = customerService.findByEmail(email);
    if (customer != null) {
      return new ResponseEntity<>(customer, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

    @PostMapping("/add")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customer) {
      CustomerDto saved = customerService.addCustomer(customer);
      return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Customer> editCustomerDetails(@PathVariable Long id, @RequestBody Customer customer) {
      Customer editedCustomer = customerService.editCustomerDetails(id, customer);
      if (editedCustomer != null) {
        return new ResponseEntity<>(editedCustomer, HttpStatus.OK);

      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

      }
    } 


}
