package br.com.challenge.model;

public class Address {

    private String cep;
    private String neighborhood;
    private String state;
    private String city;

    public Address() {
        
    }

    public Address(String cep, String neighborhood, String state, String city) {
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.state = state;
        this.city = city;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
