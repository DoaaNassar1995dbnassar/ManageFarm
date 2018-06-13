package co.neprass.managefarm.Objects;

/**
 * Created by AL-Qema on 05/06/18.
 */

public class AddFarmObject {
    String name;
    String type ;
    String idNumber ;
    String country ;
    String address ;
    String bac ;

    public AddFarmObject(String name, String type, String idNumber, String country, String address, String bac) {
        this.name = name;
        this.type = type;
        this.idNumber = idNumber;
        this.country = country;
        this.address = address;
        this.bac = bac;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBac() {
        return bac;
    }

    public void setBac(String bac) {
        this.bac = bac;
    }
}
