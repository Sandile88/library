package za.co.wtc.library.mapper;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import za.co.wtc.library.dto.AddressDTO;
import za.co.wtc.library.dto.CustomerDto;
import za.co.wtc.library.model.Address;
import za.co.wtc.library.model.Customer;

@Component
public class CustomerMapper {

  public CustomerDto toDto(Customer customer) {
    CustomerDto customerDto = new CustomerDto();
    customerDto.setId(customer.getId());
    customerDto.setName(customer.getName());
    customerDto.setEmail(customerDto.getEmail());
    // map the rest of the fields

    Set<AddressDTO> addressDTOS = customer.getAddresses().stream()
        .map(address -> {
          AddressDTO addressDto = new AddressDTO();
          addressDto.setId(address.getId());
          addressDto.setAddress1(address.getAddress1());
          // map rest of the fields
          return addressDto;
        }).collect(Collectors.toSet());

    customerDto.setAddressDTOS(addressDTOS);


    return customerDto;
  }


  public Customer toEntity(CustomerDto customerDto) {
    Customer customer = new Customer();
    customer.setId(customerDto.getId());
    customer.setName(customerDto.getName());
    customer.setEmail(customerDto.getEmail());
    Set<AddressDTO> addressesDto = customerDto.getAddressDTOS();
    if (addressesDto != null) {
      Set<Address> addresses = addressesDto.stream()
          .map(addressDTO -> {
            Address address = new Address();
            address.setAddress1(addressDTO.getAddress1());
            //map rest of fields
            return address;
          }).collect(Collectors.toSet());

      customer.setAddresses(addresses);
    }
    return customer;
  }

}
