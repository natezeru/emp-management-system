package com.emps.managementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data // because of lombok no need for boilerplate code
@Entity // specifies that the class is an entity
@Table(name = "employees") // specifies the table in the database with which this entity is mapped.
public class Employee {

	@Id // creates a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this annotation specifies the generation strategies for the
														// values of primary keys
	private long id;

	@Column(name = "first_name", nullable = false) // this allows us to provide column name details
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "role", nullable = false)
	private String role;

}
