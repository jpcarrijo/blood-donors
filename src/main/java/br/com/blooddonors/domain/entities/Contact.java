package br.com.blooddonors.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String landline;
    private String cellPhone;

    public Contact() {
    }

    public Contact(Long id, String email, String landline, String cellPhone) {
	this.id = id;
	this.email = email;
	this.landline = landline;
	this.cellPhone = cellPhone;
    }

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
}
