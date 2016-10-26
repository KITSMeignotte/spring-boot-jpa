package com.kf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoPerson {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    
	public DoPerson() {
	}
	public DoPerson(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "DoPerson [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	
    
    


}
