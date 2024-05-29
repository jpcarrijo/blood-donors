package br.com.blooddonors.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PhysicalAttributes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sex;
    private Double height;
    private Integer weight;
    private String bloodType;

    public PhysicalAttributes() {
    }

    public PhysicalAttributes(Long id, String sex, Double height, Integer weight, String bloodType) {
	this.id = id;
	this.sex = sex;
	this.height = height;
	this.weight = weight;
	this.bloodType = bloodType;
    }

    public Long getId() {
	return id;
    }

    public String getSex() {
	return sex;
    }

    public void setSex(String sex) {
	this.sex = sex;
    }

    public Double getHeight() {
	return height;
    }

    public void setHeight(Double height) {
	this.height = height;
    }

    public Integer getWeight() {
	return weight;
    }

    public void setWeight(Integer weight) {
	this.weight = weight;
    }

    public String getBloodType() {
	return bloodType;
    }

    public void setBloodType(String bloodType) {
	this.bloodType = bloodType;
    }
}
