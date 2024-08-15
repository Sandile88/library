package za.co.wtc.library.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class CustomerDto {
  private Long id;
  private String name;
  private String surname;
  private String title;
  private String idNumber;
  private String email;
  private LocalDateTime memberShipStartDate;
  private LocalDateTime memberShipExpireDate;
  private Set<AddressDTO> addressDTOS = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getMemberShipStartDate() {
    return memberShipStartDate;
  }

  public void setMemberShipStartDate(LocalDateTime memberShipStartDate) {
    this.memberShipStartDate = memberShipStartDate;
  }

  public LocalDateTime getMemberShipExpireDate() {
    return memberShipExpireDate;
  }

  public void setMemberShipExpireDate(LocalDateTime memberShipExpireDate) {
    this.memberShipExpireDate = memberShipExpireDate;
  }

  public Set<AddressDTO> getAddressDTOS() {
    return addressDTOS;
  }

  public void setAddressDTOS(Set<AddressDTO> addressDTOS) {
    this.addressDTOS = addressDTOS;
  }
}
