package com.jdot.customer.crud.service;

import java.util.List;

import com.jdot.customer.crud.entity.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer cust);

	public Customer getCustomerById(int customerId);

	public List<Customer> getCustomers();

	public Customer updateCustomer(Customer cust);

	public void deleteCustomer(int customerId);

}
