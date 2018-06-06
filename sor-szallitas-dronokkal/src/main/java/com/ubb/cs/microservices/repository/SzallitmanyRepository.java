package com.ubb.cs.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.cs.microservices.repository.model.Szallitmany;

public interface SzallitmanyRepository extends JpaRepository<Szallitmany, Integer> {

}