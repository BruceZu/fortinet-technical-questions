package com.fortinet.cc.question5.ws.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortinet.cc.question5.ws.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	Session session;
	@Autowired
	SessionFactory sessionFactory;
	
	public void openConnection() {
		this.session = sessionFactory.openSession();
		
	}

	public Customer saveCustomerDetails(Customer customer) {
		this.session.beginTransaction();
        this.session.save(customer);
        this.session.getTransaction().commit();
        return customer;
	}

	public void closeConnection() {
		this.session.close();
		
	}
	
}
