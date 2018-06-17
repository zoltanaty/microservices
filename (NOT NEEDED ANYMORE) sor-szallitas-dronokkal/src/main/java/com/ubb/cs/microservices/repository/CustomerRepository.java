package com.ubb.cs.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.cs.microservices.repository.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
