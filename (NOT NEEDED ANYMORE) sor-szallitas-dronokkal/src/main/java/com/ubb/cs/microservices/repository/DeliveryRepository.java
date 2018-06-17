package com.ubb.cs.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.cs.microservices.repository.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{

}
