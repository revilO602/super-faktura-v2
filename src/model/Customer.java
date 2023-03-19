
package model;

/**
 *
 * @author leont
 */
public class Customer {
    private String name;
    private String address;
    private String city;
    private String postalCode;

    public Customer(String name, String address, String city, String postalCode) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }
    
    //Copy constructor
    public Customer(Customer customer){
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.city = customer.getCity();
        this.postalCode = customer.getPostalCode();
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
    
}
