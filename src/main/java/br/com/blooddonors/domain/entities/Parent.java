package br.com.blooddonors.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mother;
    private String father;

    public Parent() {
    }

    public Parent(Long id, String mother, String father) {
	this.id = id;
	this.mother = mother;
	this.father = father;
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
}
