package config.xml.beans;

public class Address {
    private String city;
    private String street;
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public  String toString(){
        return String.format("city %s  , street %s ",this.city,this.street);
    }
}
