package com.ubb.cs.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.cs.microservices.repository.BeersPackageRepository;
import com.ubb.cs.microservices.repository.model.BeersPackage;

@RestController
@RequestMapping(value = "/api/v1/beerspackage")
public class BeersPackageController implements ICrudController<BeersPackage>{

	@Autowired
	private BeersPackageRepository beersPackageRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	@Override
	public BeersPackage create(BeersPackage entity) {
		return beersPackageRepository.saveAndFlush(entity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@Override
	public BeersPackage update(BeersPackage entity) {
		BeersPackage beersPackageToUpdate = beersPackageRepository.findById(entity.getId()).get();
		
		beersPackageToUpdate.setBeerType(entity.getBeerType());
		beersPackageToUpdate.setNumberOfBeers(entity.getNumberOfBeers());
		
		return beersPackageRepository.saveAndFlush(beersPackageToUpdate);
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public List<BeersPackage> getAll() {
		return beersPackageRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Override
	public BeersPackage getById(int id) {
		return beersPackageRepository.findById(id).get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Override
	public void delete(int id) {
		BeersPackage beersPackageToDelete = beersPackageRepository.findById(id).get();
		beersPackageRepository.delete(beersPackageToDelete);
	}

}
