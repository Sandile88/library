package za.co.wtc.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import za.co.wtc.library.dto.CustomerDto;
import za.co.wtc.library.mapper.CustomerMapper;
import za.co.wtc.library.model.Customer;
import za.co.wtc.library.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

  public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
  public CustomerDto findByIdNumber(String idNumber) {
    logger.info("search for customer with id {}", idNumber);
    try {
      Customer customer = customerRepository.findByIdNumber(idNumber);
      if (customer != null) {
        logger.info("Found customer with id-number {} details {}", idNumber, customer);
      }
      return customerMapper.toDto(customer);
    } catch (Exception exception) {
      String message = "Error while searching for customer with id-number " + idNumber
          + exception.getMessage();
      logger.error(message, exception);
      throw new RuntimeException(message, exception);
    }
  }

  @Override
  public Customer findByEmail(String email) {
    logger.info("search for customer with email {}", email);
    try {
      Customer customer = customerRepository.findByIdNumber(email);
      if (customer != null) {
        logger.info("Found customer with email {} details {}", email, customer);
      }
      return customer;
    } catch (Exception exception) {
      String message = "Error while searching for customer with email " + email
          + exception.getMessage();
      logger.error(message, exception);
      throw new RuntimeException(message, exception);
    }
  }

  @Override
  public CustomerDto addCustomer(CustomerDto customerDto) {

   final Customer customer =  customerMapper.toEntity(customerDto);
    customer.getAddresses().forEach(address -> {
      address.setCustomer(customer);
    });

    Customer saved =  customerRepository.save(customer);
    return customerMapper.toDto(saved);
  }

  @Override
  public Customer editCustomerDetails(Long id, Customer editedCustomer) {
    if (customerRepository.existsById(id)) {
        editedCustomer.setId(id);
        return customerRepository.save(editedCustomer);
    } else {
      throw new RuntimeException("Customer with id: " + id + " could not be found");
    }
  }
}
