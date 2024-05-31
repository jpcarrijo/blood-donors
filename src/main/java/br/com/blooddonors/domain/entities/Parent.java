package br.com.blooddonors.domain.entities;

import br.com.blooddonors.application.dto.DonorDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_parent")
public class Parent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mother;
    private String father;

    private Parent(Builder builder) {
	this.id = builder.id;
	this.mother = builder.mother;
	this.father = builder.father;
    }

    public Parent() {
    }

    public Long getId() {
	return id;
    }

    public String getMother() {
	return mother;
    }

    public void setMother(String mother) {
	this.mother = mother;
    }

    public String getFather() {
	return father;
    }

    public void setFather(String father) {
	this.father = father;
    }


    public static class Builder {


	private Long id;
	private String mother;
	private String father;

	public Builder id(Long id) {
	    this.id = id;
	    return this;
	}

	public Builder mother(String mother) {
	    this.mother = mother;
	    return this;
	}

	public Builder father(String father) {
	    this.father = father;
	    return this;
	}

	public Parent build() {
	    return new Parent(this);
	}
    }

    public static Parent builder(DonorDTO dto) {
	return new Builder()
	    .mother(dto.mother())
	    .father(dto.father())
	    .build();
    }
}
