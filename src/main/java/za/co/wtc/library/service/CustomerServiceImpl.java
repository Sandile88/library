package za.co.wtc.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.wtc.library.model.Customer;
import za.co.wtc.library.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


  @Override
  public Customer findByIdNumber(String idNumber) {
    logger.info("search for customer with id {}", idNumber);
    try {
      Customer customer = customerRepository.findByIdNumber(idNumber);
      if (customer != null) {
        logger.info("Found customer with id-number {} details {}", idNumber, customer);
      }
      return customer;
    } catch (Exception exception) {
      String message = "Error while searching for customer with id-number " + idNumber
          + exception.getMessage();
      logger.error(message, exception);
      throw new RuntimeException(message, exception);
    }
  }
}
