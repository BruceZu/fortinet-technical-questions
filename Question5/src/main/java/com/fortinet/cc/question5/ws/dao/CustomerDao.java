package com.fortinet.cc.question5.ws.dao;

import com.fortinet.cc.question5.ws.model.Customer;

public interface CustomerDao {
	public void openConnection();
	public Customer saveCustomerDetails(Customer customer);
	public void closeConnection(); 
}
