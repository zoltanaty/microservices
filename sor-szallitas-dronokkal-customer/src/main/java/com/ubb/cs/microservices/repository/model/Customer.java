package com.ubb.cs.microservices.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
    @GeneratedValue
    private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
}
