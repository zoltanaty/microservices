package com.ubb.cs.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.cs.microservices.repository.model.Drone;

public interface DroneRepository extends JpaRepository<Drone, Integer>{

}
