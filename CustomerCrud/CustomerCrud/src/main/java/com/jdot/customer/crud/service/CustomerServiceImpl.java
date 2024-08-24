package com.jdot.customer.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdot.customer.crud.entity.Customer;
import com.jdot.customer.crud.error.RecordNotFoundException;
import com.jdot.customer.crud.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerrepository;

	@Override
	public Customer saveCustomer(Customer cust) {
		
		return customerrepository.save(cust);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		Optional<Customer> customerDb=customerrepository.findById(customerId);
		if(customerDb.isPresent())
		{
			Customer cust=customerDb.get();
			return cust;
		}
		else
		{
			throw new RecordNotFoundException("Record not found!!");
		}
	}

	@Override
	public List<Customer> getCustomers() {
		
		return customerrepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		Optional<Customer> customerDb=customerrepository.findById(cust.getCustomerId());
		
		if(customerDb.isPresent())
		{
			Customer customerUpdate=customerDb.get();
			customerUpdate.setOrderNo(cust.getOrderNo());
			customerUpdate.setOrderDate(cust.getOrderDate());
			customerUpdate.setOrderTotal(cust.getOrderTotal());
			customerrepository.save(customerUpdate);
			return customerUpdate;		
		}
		else
		{
			throw new RecordNotFoundException("Record not found!!");
		}
	}

	@Override
	public void deleteCustomer(int customerId) {
Optional<Customer> customerDb = customerrepository.findById(customerId);
		
		if(customerDb.isPresent())
		{
			customerrepository.delete(customerDb.get());
		}
       
		else {
			throw new RecordNotFoundException("Record not found!");
		}
		
	}

}
