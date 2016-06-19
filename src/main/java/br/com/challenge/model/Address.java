package br.com.challenge.model;

public class Address {

    private String cep;
    private String neighborhood;
    private String state;
    private String city;

    public Address(String cep, String neighborhood, String state, String city) {
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.state = state;
        this.city = city;
    }

    public String getCep() {
        return cep;
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
