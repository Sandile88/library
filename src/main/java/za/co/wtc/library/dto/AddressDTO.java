package za.co.wtc.library.dto;


public class AddressDTO {
  private Long id;
  private String address1;
  private String address2;
  private String province;
  private int postalCode;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }
}
