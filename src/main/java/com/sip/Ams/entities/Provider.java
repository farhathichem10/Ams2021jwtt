package com.sip.Ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

 
@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name is mandatory")
    @Size(min=3,max=15)
    @Column(name = "name")
    private String name;
    @NotBlank(message = "Address is mandatory")
    @Column(name = "address")
    private String address;
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;
    @Column(name = "logo")
    private String logo;

    public Provider() {
    }

    public Provider(String name, String address, String email) {
	this.name = name;
	this.address = address;
	this.email = email;
    }

    public void setId(long id) {
	this.id = id;
    }

    public long getId() {
	return id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getEmail() {

	return email;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getAddress() {
	return address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    
}