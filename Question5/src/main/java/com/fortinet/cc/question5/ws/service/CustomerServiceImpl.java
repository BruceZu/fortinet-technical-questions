package com.fortinet.cc.question5.ws.service;

import org.springframework.stereotype.Service;

import com.fortinet.cc.question5.ws.bean.CustomerBean;
import com.fortinet.cc.question5.ws.dao.CustomerDao;
import com.fortinet.cc.question5.ws.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao;
	
	public Customer saveCustomerDetails(CustomerBean customerBean) {
		Customer customerData = Customer.getBuilder()
									.firstName(customerBean.getCustomerFirstName())
									.lastName(customerBean.getCustomerLastName())
									.email(customerBean.getCustomerEmail())
									.phoneNo(customerBean.getCustomerPhoneNo())
									.build();
		
		Customer customer = null;
		try {
			this.customerDao.openConnection();
			customer = customerDao.saveCustomerDetails(customerData);
			
		} finally {
			this.customerDao.closeConnection();
		}
		return customer;
		
		
	}
	
}
