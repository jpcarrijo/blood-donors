package br.com.blooddonors.domain.entities;

import br.com.blooddonors.application.dto.DonorDTO;
import br.com.blooddonors.implementation.validation.DonorValidation;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_donor")
public class Donor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private LocalDate dateOfBirth;
    @OneToOne
    private PhysicalAttr physicalAttr;
    @OneToOne
    private Parent parent;
    @OneToOne
    private Address address;
    @OneToOne
    private Contact contact;

    public Donor() {
    }

    private Donor(Builder builder) {
	this.id = builder.id;
	this.name = builder.name;
	this.cpf = builder.cpf;
	this.rg = builder.rg;
	this.dateOfBirth = builder.dateOfBirth;
	this.physicalAttr = builder.physicalAttr;
	this.parent = builder.parent;
	this.address = builder.address;
	this.contact = builder.contact;
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

    public PhysicalAttr getPhysicalAttributes() {
	return physicalAttr;
    }

    public void setPhysicalAttributes(PhysicalAttr physicalAttr) {
	this.physicalAttr = physicalAttr;
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


    public static class Builder {


	private Long id;
	private String name;
	private String cpf;
	private String rg;
	private LocalDate dateOfBirth;
	private PhysicalAttr physicalAttr;
	private Parent parent;
	private Address address;
	private Contact contact;

	public Builder name(String name) {
	    this.name = name;
	    return this;
	}

	public Builder cpf(String cpf) {
	    this.cpf = cpf;
	    return this;
	}

	public Builder rg(String rg) {
	    this.rg = rg;
	    return this;
	}

	public Builder dateOfBirth(LocalDate dateOfBirth) {
	    this.dateOfBirth = dateOfBirth;
	    return this;
	}

	public Builder physicalAttr(PhysicalAttr physicalAttr) {
	    this.physicalAttr = physicalAttr;
	    return this;
	}

	public Builder parent(Parent parent) {
	    this.parent = parent;
	    return this;
	}

	public Builder address(Address address) {
	    this.address = address;
	    return this;
	}

	public Builder contact(Contact contact) {
	    this.contact = contact;
	    return this;
	}

	public Donor build() {
	    return new Donor(this);
	}
    }

    public static Donor builder(DonorDTO dto, PhysicalAttr physicalAttrArg, Parent parentArg, Address addressArg,
				Contact contactArg) {
	LocalDate date = DonorValidation.returnStringDate(dto.dateOfBirth());
	return new Builder()
	    .name(dto.name())
	    .cpf(dto.cpf())
	    .rg(dto.rg())
	    .dateOfBirth(date)
	    .physicalAttr(physicalAttrArg)
	    .parent(parentArg)
	    .address(addressArg)
	    .contact(contactArg)
	    .build();
    }
}
