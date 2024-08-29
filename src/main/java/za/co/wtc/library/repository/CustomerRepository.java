package za.co.wtc.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.wtc.library.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  @Query("select c from Customer c "
      + "where c.idNumber = :idNumber")
  Customer findByIdNumber(String idNumber);

  @Query("select c from Customer c "
  + "where c.email = :email")
Customer findByEmail(String email);

// Customer editCustomerDetails(Long id, Customer customer);
}
