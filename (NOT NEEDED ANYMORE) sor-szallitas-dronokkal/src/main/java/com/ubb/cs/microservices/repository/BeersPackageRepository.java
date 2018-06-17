package com.ubb.cs.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.cs.microservices.repository.model.BeersPackage;

public interface BeersPackageRepository extends JpaRepository<BeersPackage, Integer>{

}
