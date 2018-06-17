package com.ubb.cs.microservices.repository.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
	@Id
	@GeneratedValue
	private int id;
	private Date dateOfOrder;
	private Date dateOfDelivery;
	@OneToOne
	private Drone drone;
	@OneToOne
	private BeersPackage beerPackage;
}
