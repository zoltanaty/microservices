package com.ubb.cs.microservices.controller.epo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryEpo {
	private int id;
	private Date dateOfOrder;
	private Date dateOfDelivery;
	private Customer customer;
	private BeersPackage beersPackage;
	private Drone drone;
}
