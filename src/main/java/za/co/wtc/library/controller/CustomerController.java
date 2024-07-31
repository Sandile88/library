package za.co.wtc.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.wtc.library.model.Customer;
import za.co.wtc.library.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @RequestMapping(method = RequestMethod.GET, value = "/{idNumber}",
      produces = {"application/json"})
  public ResponseEntity<Customer> findByIdNumber(@PathVariable("idNumber") String idNumber) {
    Customer customer = customerService.findByIdNumber(idNumber);
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }
}
