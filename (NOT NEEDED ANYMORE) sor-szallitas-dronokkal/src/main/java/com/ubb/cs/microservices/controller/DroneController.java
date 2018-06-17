package com.ubb.cs.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.cs.microservices.repository.DroneRepository;
import com.ubb.cs.microservices.repository.model.Drone;

@RestController
@RequestMapping(value = "/api/v1/drone")
public class DroneController implements ICrudController<Drone>{
	
	@Autowired
	private DroneRepository droneRepository;

	@RequestMapping(method = RequestMethod.POST)
	@Override
	public Drone create(Drone entity) {
		return droneRepository.saveAndFlush(entity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@Override
	public Drone update(Drone entity) {
		Drone droneToUpdate = droneRepository.findById(entity.getId()).get();
		
		droneToUpdate.setModelName(entity.getModelName());
		droneToUpdate.setModelType(entity.getModelType());
		droneToUpdate.setCapacity(entity.getCapacity());
		
		return droneRepository.saveAndFlush(droneToUpdate);
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public List<Drone> getAll() {
		return droneRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Override
	public Drone getById(int id) {
		return droneRepository.findById(id).get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Override
	public void delete(int id) {
		Drone droneToDelete = droneRepository.findById(id).get();
		droneRepository.delete(droneToDelete);
		
	}
}
