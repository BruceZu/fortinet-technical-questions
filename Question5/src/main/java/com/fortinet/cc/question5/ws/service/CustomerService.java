package com.fortinet.cc.question5.ws.service;

import com.fortinet.cc.question5.ws.bean.CustomerBean;
import com.fortinet.cc.question5.ws.model.Customer;

public interface CustomerService {
	
	public Customer saveCustomerDetails(CustomerBean customer);
}
