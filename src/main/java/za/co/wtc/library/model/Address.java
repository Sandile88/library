package za.co.wtc.library.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "address_line_1")
    private String address1;

    @Column(name = "address_line_2")
    private String address2;

    @Column(name = "province")
    private String province;

    @Column(name = "postal_code")
    private int postalCode;


    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getCustomerId(){
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    public String getAddress1(){
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }


    public String getAddress2(){
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }


    public String getProvince(){
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public int getPostalCode(){
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}