package br.com.blooddonors.domain.entities;

import br.com.blooddonors.application.dto.DonorDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_physical_attributes")
public class PhysicalAttr {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sex;
    private Double height;
    private Integer weight;
    private String bloodType;

    private PhysicalAttr(Builder builder) {
	this.id = builder.id;
	this.sex = builder.sex;
	this.height = builder.height;
	this.weight = builder.weight;
	this.bloodType = builder.bloodType;
    }

    public PhysicalAttr() {
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

    public static class Builder {


	private Long id;
	private String sex;
	private Double height;
	private Integer weight;
	private String bloodType;

	public Builder id(Long id, String sex, Double height, Integer weight, String bloodType) {
	    this.id = id;
	    return this;
	}

	public Builder sex(String sex) {
	    this.sex = sex;
	    return this;
	}

	public Builder height(Double height) {
	    this.height = height;
	    return this;
	}

	public Builder weight(Integer weight) {
	    this.weight = weight;
	    return this;
	}

	public Builder bloodType(String bloodType) {
	    this.bloodType = bloodType;
	    return this;
	}

	public PhysicalAttr build() {
	    return new PhysicalAttr(this);
	}
    }

    public static PhysicalAttr builder(DonorDTO dto) {
	return new Builder()
	    .sex(dto.sex())
	    .height(dto.height())
	    .weight(dto.weight())
	    .bloodType(dto.bloodType())
	    .build();
    }

}
