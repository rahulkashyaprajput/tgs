package com.tgs.learning;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer  {

//private static final long serialVersionUID = -2343243243242432341L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

Customer(String fName,String lName){
	this.firstName = fName;
	this.lastName = lName;
	
}
@Override
public String toString() {
	return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
}
Customer(){
	
}

@Column(name = "firstname")
private String firstName;

@Column(name = "lastname")
private String lastName;

public String getFirstName() {
	return firstName;
}


public String getLastName() {
	return lastName;
}


//Setters, getters and constructors
}
