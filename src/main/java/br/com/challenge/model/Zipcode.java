package br.com.challenge.model;

public class Zipcode {

    private String zipcode;
    private String neighborhood;
    private String state;
    private String city;

    public Zipcode(String zipcode, String neighborhood, String state, String city) {
        this.zipcode = zipcode;
        this.neighborhood = neighborhood;
        this.state = state;
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
