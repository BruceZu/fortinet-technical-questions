package com.fortinet.cc.question5.ws.model;

import javax.persistence.*;

/*
 * 
 * Customer model
 * 
 */

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	
	@Column(name = "customerFirstName")
	private String customerFirstName;
	
	@Column(name = "customerLastName")
	private String customerLastName;
	
	@Column(name = "customerEmail")
	private String customerEmail;
	
	@Column(name = "customerPhoneNo")
	private String customerPhoneNo;

	public Customer() {
		
	}
	
	public static Builder getBuilder() {
        return new Builder();
    }
	
		
	public long getCustomerId() {
		return customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	
	public static class Builder {

        private Customer customer;

        public Builder() {
        	customer = new Customer();        	        	
        }

        public Customer build() {
            return customer;
        }
        
        public Builder id(long id) {
        	customer.customerId = id;
        	return this;
        }
        
        public Builder firstName(String firstName) {
        	customer.customerFirstName = firstName;
            return this;
        }
        
        public Builder lastName(String lastName) {
        	customer.customerLastName = lastName;
            return this;
        }
        
        public Builder email(String email) {
        	customer.customerEmail = email;
            return this;
        }
        
        public Builder phoneNo(String phoneNo) {
        	customer.customerPhoneNo = phoneNo;
            return this;
        }
        
	}

}
