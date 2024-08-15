package za.co.wtc.library.service;

import za.co.wtc.library.dto.CustomerDto;
import za.co.wtc.library.model.Customer;

public interface CustomerService {

  CustomerDto findByIdNumber(String idNumber);

  Customer findByEmail(String email);

  CustomerDto addCustomer(CustomerDto customer);

  Customer editCustomerDetails(Long id, Customer customer);
}
