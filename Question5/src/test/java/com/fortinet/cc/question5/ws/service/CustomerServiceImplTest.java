package com.fortinet.cc.question5.ws.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import com.fortinet.cc.question5.ws.TestConfiguration;
import com.fortinet.cc.question5.ws.bean.CustomerBean;
import com.fortinet.cc.question5.ws.dao.CustomerDao;
import com.fortinet.cc.question5.ws.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class )
public class CustomerServiceImplTest {

	@Mock
	CustomerDao customerDao;
	
	@Autowired
	@InjectMocks
    @Qualifier("customerService")
	CustomerService customerService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSaveCustomer() {
		doNothing().when(customerDao).openConnection();
        doNothing().when(customerDao).closeConnection();
        
        Customer customer = Customer.getBuilder()
        							.firstName("TestFName")
        							.lastName("TestLName")
        							.email("TestUser@gmail.com")
        							.phoneNo("999-999-9999")
        							.build();
                
        when(customerDao.saveCustomerDetails(any(Customer.class))).thenReturn(customer);
        
        CustomerBean bean = new CustomerBean();
        bean.setCustomerFirstName("TestFName");
        bean.setCustomerLastName("TestLName");
        bean.setCustomerEmail("TestUser@gmail.com");
        bean.setCustomerPhoneNo("999-999-9999");
        
        Customer result = customerService.saveCustomerDetails(bean);
        
        Assert.assertNotNull(result);
        Assert.assertEquals(customer.getCustomerFirstName(), result.getCustomerFirstName());
        Assert.assertEquals(customer.getCustomerLastName(), result.getCustomerLastName());
        Assert.assertEquals(customer.getCustomerEmail(), result.getCustomerEmail());
        Assert.assertEquals(customer.getCustomerPhoneNo(), result.getCustomerPhoneNo());
        
	}
	
}
