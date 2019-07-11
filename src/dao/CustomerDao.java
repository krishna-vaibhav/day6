package dao;

import java.util.List;

import pojos.Customer;

public interface CustomerDao {
	String registerCustomer(Customer c);
	//retrieve customer details
	Customer getCustomerDetails(int custId);
	//get all customer details
	List<Customer> fetchAllCustomers();
}

