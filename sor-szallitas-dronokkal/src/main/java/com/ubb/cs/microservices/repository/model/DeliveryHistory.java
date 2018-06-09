package com.ubb.cs.microservices.repository.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryHistory {
	@Id
	@GeneratedValue
	private int id;
	@OneToMany( targetEntity=Delivery.class )
	private List<Delivery> delivery;
}
