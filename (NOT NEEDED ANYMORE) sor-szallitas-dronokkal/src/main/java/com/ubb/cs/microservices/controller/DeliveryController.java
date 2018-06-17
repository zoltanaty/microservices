package com.ubb.cs.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.cs.microservices.repository.DeliveryRepository;
import com.ubb.cs.microservices.repository.model.Delivery;

@RestController
@RequestMapping(value = "/api/v1/delivery")
public class DeliveryController implements ICrudController<Delivery> {

	@Autowired
	private DeliveryRepository deliveryRepository;

	@RequestMapping(method = RequestMethod.POST)
	@Override
	public Delivery create(Delivery entity) {
		return deliveryRepository.saveAndFlush(entity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@Override
	public Delivery update(Delivery entity) {
		Delivery deliveryToUpdate = deliveryRepository.findById(entity.getId()).get();

		deliveryToUpdate.setBeerPackage(entity.getBeerPackage());
		deliveryToUpdate.setDateOfOrder(entity.getDateOfOrder());
		deliveryToUpdate.setDateOfDelivery(entity.getDateOfDelivery());
		deliveryToUpdate.setDrone(entity.getDrone());

		return deliveryRepository.saveAndFlush(deliveryToUpdate);
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public List<Delivery> getAll() {
		return deliveryRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Override
	public Delivery getById(int id) {
		return deliveryRepository.findById(id).get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Override
	public void delete(int id) {
		Delivery deliveryToDelete = deliveryRepository.findById(id).get();
		deliveryRepository.delete(deliveryToDelete);
	}

}
