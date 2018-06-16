package com.ubb.cs.microservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ubb.cs.microservices.controller.epo.BeersPackage;
import com.ubb.cs.microservices.controller.epo.Customer;
import com.ubb.cs.microservices.controller.epo.DeliveryEpo;
import com.ubb.cs.microservices.controller.epo.Drone;
import com.ubb.cs.microservices.repository.DeliveryRepository;
import com.ubb.cs.microservices.repository.model.Delivery;

@RestController
@RequestMapping(value = "/api/v1/delivery")
public class DeliveryController {
	
	private static final String CUSTOMER_SERVICE_BASE_URL = "http://127.0.0.1:8001/api/v1/namespaces/default/services/sor-szallitas-dronokkal-customer/proxy/";
	private static final String BEERS_PACKAGE_SERVICE_BASE_URL = "http://127.0.0.1:8001/api/v1/namespaces/default/services/sor-szallitas-dronokkal-beerspackage/proxy/";
	private static final String DRONE_SERVICE_BASE_URL = "http://127.0.0.1:8001/api/v1/namespaces/default/services/sor-szallitas-dronokkal-drone/proxy/";

	@Autowired
	private DeliveryRepository deliveryRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Delivery create(@RequestParam Delivery entity) {
		return deliveryRepository.saveAndFlush(entity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Delivery update(@RequestParam Delivery entity) {
		Delivery deliveryToUpdate = deliveryRepository.findById(entity.getId()).get();

		deliveryToUpdate.setCustomerId(entity.getCustomerId());
		deliveryToUpdate.setBeerPackageId(entity.getBeerPackageId());
		deliveryToUpdate.setDroneId(entity.getDroneId());
		deliveryToUpdate.setDateOfOrder(entity.getDateOfOrder());
		deliveryToUpdate.setDateOfDelivery(entity.getDateOfDelivery());

		return deliveryRepository.saveAndFlush(deliveryToUpdate);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<DeliveryEpo> getAll() {
		List<Delivery> deliveryList = deliveryRepository.findAll();
		List<DeliveryEpo> deliveryEpoList = new ArrayList<>();
		
		for(Delivery delivery : deliveryList) {
			RestTemplate restTemplate = new RestTemplate();
	        Customer customer = restTemplate.getForObject(CUSTOMER_SERVICE_BASE_URL + "api/v1/customer/" + delivery.getCustomerId(), Customer.class);
	        Drone drone = restTemplate.getForObject(DRONE_SERVICE_BASE_URL + "api/v1/drone/" + delivery.getCustomerId(), Drone.class);
	        BeersPackage beersPackage = restTemplate.getForObject(BEERS_PACKAGE_SERVICE_BASE_URL + "api/v1/beerspackage/" + delivery.getCustomerId(), BeersPackage.class);
			
			DeliveryEpo deliveryEpo = new DeliveryEpo();
			deliveryEpo.setId(delivery.getId());
			deliveryEpo.setDateOfOrder(delivery.getDateOfOrder());
			deliveryEpo.setDateOfDelivery(delivery.getDateOfDelivery());
			deliveryEpo.setCustomer(customer);
			deliveryEpo.setBeersPackage(beersPackage);
			deliveryEpo.setDrone(drone);
			
			deliveryEpoList.add(deliveryEpo);
		}
		
		return deliveryEpoList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DeliveryEpo getById(@PathVariable int id) {
		Delivery delivery = deliveryRepository.findById(id).get();
		
		RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(CUSTOMER_SERVICE_BASE_URL + "api/v1/customer/" + delivery.getCustomerId(), Customer.class);
        Drone drone = restTemplate.getForObject(DRONE_SERVICE_BASE_URL + "api/v1/drone/" + delivery.getCustomerId(), Drone.class);
        BeersPackage beersPackage = restTemplate.getForObject(BEERS_PACKAGE_SERVICE_BASE_URL + "api/v1/beerspackage/" + delivery.getCustomerId(), BeersPackage.class);
		
		DeliveryEpo deliveryEpo = new DeliveryEpo();
		deliveryEpo.setId(delivery.getId());
		deliveryEpo.setDateOfOrder(delivery.getDateOfOrder());
		deliveryEpo.setDateOfDelivery(delivery.getDateOfDelivery());
		deliveryEpo.setCustomer(customer);
		deliveryEpo.setBeersPackage(beersPackage);
		deliveryEpo.setDrone(drone);
		
		return deliveryEpo;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		Delivery deliveryToDelete = deliveryRepository.findById(id).get();
		deliveryRepository.delete(deliveryToDelete);
	}

}
