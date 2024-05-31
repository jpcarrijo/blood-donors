package br.com.blooddonors.domain.entities;

import br.com.blooddonors.application.dto.DonorDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_address")
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

    private Address(Builder builder) {
	this.id = builder.id;
	this.address = builder.address;
	this.houseNumber = builder.houseNumber;
	this.neighborhood = builder.neighborhood;
	this.city = builder.city;
	this.state = builder.state;
	this.cep = builder.cep;
    }

    public Address() {
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


    public static class Builder {


	private Long id;
	private String address;
	private Integer houseNumber;
	private String neighborhood;
	private String city;
	private String state;
	private String cep;

	public Builder id(Long id) {
	    this.id = id;
	    return this;
	}

	public Builder address(String address) {
	    this.address = address;
	    return this;
	}

	public Builder houseNumber(Integer houseNumber) {
	    this.houseNumber = houseNumber;
	    return this;
	}

	public Builder neighborhood(String neighborhood) {
	    this.neighborhood = neighborhood;
	    return this;
	}

	public Builder city(String city) {
	    this.city = city;
	    return this;
	}

	public Builder state(String state) {
	    this.state = state;
	    return this;
	}

	public Builder cep(String cep) {
	    this.cep = cep;
	    return this;
	}

	public Address build() {
	    return new Address(this);
	}
    }

    public static Address builder(DonorDTO dto) {
	return new Builder()
	    .address(dto.address())
	    .houseNumber(dto.houseNumber())
	    .neighborhood(dto.neighborhood())
	    .city(dto.city())
	    .state(dto.state())
	    .cep(dto.cep())
	    .build();
    }
}
