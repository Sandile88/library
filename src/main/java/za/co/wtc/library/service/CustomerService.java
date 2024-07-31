package za.co.wtc.library.service;

import za.co.wtc.library.model.Customer;

public interface CustomerService {

  Customer findByIdNumber(String idNumber);
}
