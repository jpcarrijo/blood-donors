package br.com.blooddonors.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private Integer houseNumber;
    private String neighborhood;
    private String city;
    private String state;
    private String cep;


    public Address() {
    }

    public Address(Long id, String address, Integer houseNumber, String neighborhood, String city, String state,
		   String cep) {
	this.id = id;
	this.address = address;
	this.houseNumber = houseNumber;
	this.neighborhood = neighborhood;
	this.city = city;
	this.state = state;
	this.cep = cep;
    }

    public Long getId() {
	return id;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public Integer getHouseNumber() {
	return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
	this.houseNumber = houseNumber;
    }

    public String getNeighborhood() {
	return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
	this.neighborhood = neighborhood;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getCep() {
	return cep;
    }

    public void setCep(String cep) {
	this.cep = cep;
    }
}
