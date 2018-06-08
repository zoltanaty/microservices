package com.ubb.cs.microservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.cs.microservices.repository.CustomerRepository;
import com.ubb.cs.microservices.repository.model.Customer;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerController implements ICrudController<Customer> {
	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(method = RequestMethod.POST)
	@Override
	public Customer create(@RequestParam Customer entity) {
		return customerRepository.saveAndFlush(entity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@Override
	public Customer update(@RequestParam Customer entity) {
		Optional<Customer> customerToUpdate = customerRepository.findById(entity.getId());
		return customerRepository.saveAndFlush(customerToUpdate.get());
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Override
	public Customer getById(@PathVariable int id) {
		return customerRepository.findById(id).get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Override
	public void delete(@RequestParam int id) {
		Customer customerToDelete = customerRepository.findById(id).get();
		customerRepository.delete(customerToDelete);

	}
}
