package com.jdot.customer.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdot.customer.crud.entity.Customer;
import com.jdot.customer.crud.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerservice;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer cust) // http://localhost:9002/customer
	{
		return ResponseEntity.ok().body(customerservice.saveCustomer(cust));
	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) // http://localhost:9002/customer/1
	{
		return ResponseEntity.ok().body(customerservice.getCustomerById(customerId));
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() // http://localhost:9002/customers
	{
		return ResponseEntity.ok().body(customerservice.getCustomers());
	}

	@PutMapping("/customer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int customerId, @RequestBody Customer cust) // http://localhost:9002/customer/1
	{
		cust.setCustomerId(customerId);
		return ResponseEntity.ok().body(customerservice.updateCustomer(cust));
	}

	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) // http://localhost:9002/customer/1
	{
		customerservice.deleteCustomer(customerId);
		return ResponseEntity.ok().body("Record deleted!");
	}


}
