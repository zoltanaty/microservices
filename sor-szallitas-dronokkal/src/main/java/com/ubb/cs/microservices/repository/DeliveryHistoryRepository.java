package com.ubb.cs.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.cs.microservices.repository.model.DeliveryHistory;

public interface DeliveryHistoryRepository extends JpaRepository<DeliveryHistory, Integer>{

}
