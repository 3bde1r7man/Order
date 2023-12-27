package aamm.order.model;


public class Location {
    
    String nation;
    String city;
    String section;
    String street;

    public Location(String nation, String city, String street, String section) {
        this.nation = nation;
        this.city = city;
        this.street = street;
        this.section = section;
    }

    public String getNation() {
        return nation;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Location{" + "nation=" + nation + ", city=" + city + ", street=" + street + ", section=" + section + '}';
    }
}
