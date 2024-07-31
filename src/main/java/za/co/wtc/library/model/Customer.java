package za.co.wtc.library.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "title")
  private String title;

  @Column(name = "id_number")
  private String idNumber;

  @Column(name = "email")
  private String email;

  @Column(name = "membership_start_date")
  private LocalDateTime memberShipStartDate;

  @Column(name = "membership_expire_date")
  private LocalDateTime memberShipExpireDate;

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
}
