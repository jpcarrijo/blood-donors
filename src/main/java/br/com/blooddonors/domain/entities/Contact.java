package br.com.blooddonors.domain.entities;

import br.com.blooddonors.application.dto.DonorDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_contact")
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String landline;
    private String cellPhone;

    private Contact(Builder builder) {
	this.id = builder.id;
	this.email = builder.email;
	this.landline = builder.landline;
	this.cellPhone = builder.cellPhone;
    }

    public Contact() { }

    public Long getId() {
	return id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getLandline() {
	return landline;
    }

    public void setLandline(String landline) {
	this.landline = landline;
    }

    public String getCellPhone() {
	return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
	this.cellPhone = cellPhone;
    }


    public static class Builder {


	private Long id;
	private String email;
	private String landline;
	private String cellPhone;

	public Builder id(Long id) {
	    this.id = id;
	    return this;
	}

	public Builder email(String email) {
	    this.email = email;
	    return this;
	}

	public Builder landline(String landline) {
	    this.landline = landline;
	    return this;
	}

	public Builder cellPhone(String cellPhone) {
	    this.cellPhone = cellPhone;
	    return this;
	}

	public Contact build() {
	    return new Contact(this);
	}
    }

    public static Contact builder(DonorDTO dto) {
	return new Builder()
	    .email(dto.email())
	    .landline(dto.landline())
	    .cellPhone(dto.cellPhone())
	    .build();
    }
}
