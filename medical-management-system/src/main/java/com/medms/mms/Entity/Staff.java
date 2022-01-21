package com.medms.mms.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class Staff {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "first_name", nullable = false)
private String firstName;

@Column(name = "last_name", nullable = false)
private String lastName;

@Column(name = "title", nullable = false)
private String title;



//Default constructor

public Staff () {
	
}

//Generated constructor using fields
public Staff(String firstName, String lastName, String title) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.title = title;
}


//Generated getters and setters

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}


	
	
	
}
