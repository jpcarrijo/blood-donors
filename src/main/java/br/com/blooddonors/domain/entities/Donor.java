package br.com.blooddonors.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Donor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private LocalDate dateOfBirth;
    @OneToOne
    private PhysicalAttributes physicalAttributes;
    @OneToOne
    private Parent parent;
    @OneToOne
    private Address address;
    @OneToOne
    private Contact contact;

    public Donor() {
    }

    public Donor(Long id, String name, String cpf, String rg, LocalDate dateOfBirth,
		 PhysicalAttributes physicalAttributes, Parent parent, Address address, Contact contact) {
	this.id = id;
	this.name = name;
	this.cpf = cpf;
	this.rg = rg;
	this.dateOfBirth = dateOfBirth;
	this.physicalAttributes = physicalAttributes;
	this.parent = parent;
	this.address = address;
	this.contact = contact;
    }

    public Long getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public String getRg() {
	return rg;
    }

    public void setRg(String rg) {
	this.rg = rg;
    }

    public LocalDate getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public PhysicalAttributes getPhysicalAttributes() {
	return physicalAttributes;
    }

    public void setPhysicalAttributes(PhysicalAttributes physicalAttributes) {
	this.physicalAttributes = physicalAttributes;
    }

    public Parent getParent() {
	return parent;
    }

    public void setParent(Parent parent) {
	this.parent = parent;
    }

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

    public Contact getContact() {
	return contact;
    }

    public void setContact(Contact contact) {
	this.contact = contact;
    }
}
