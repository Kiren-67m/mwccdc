package com.itccloud.mwccdc.model;

public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;

    public Address() {
    }

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public static Address fromString(String rawAddress) {
        if (rawAddress == null) {
            return new Address();
        }

        String[] parts = rawAddress.split(",");
        String street = parts.length > 0 ? parts[0].trim() : "";
        String city = parts.length > 1 ? parts[1].trim() : "";
        String state = parts.length > 2 ? parts[2].trim() : "";
        String zip = parts.length > 3 ? parts[3].trim() : "";
        return new Address(street, city, state, zip);
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }
}