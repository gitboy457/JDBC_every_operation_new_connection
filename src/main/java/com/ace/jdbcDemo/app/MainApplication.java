package com.ace.jdbcDemo.app;

import java.sql.Date;

import com.ace.jdbcDemo.entity.Customer;
import com.ace.jdbcDemo.repository.CustomerRepository;
import com.ace.jdbcDemo.repository.CustomerRepositoryImp;

public class MainApplication {
	
	
	private static CustomerRepository customerRepository;
	
	static {
		customerRepository = new CustomerRepositoryImp();
	}
	


	public static void main(String[] args) {
		
		Customer customer= new Customer();
		customer.setCustId("anmol123");
		customer.setCreateDate(new Date(new java.util.Date().getTime()));
		customer.setCust_name("anmol");
		customer.setEmail("anmol123@gmail.com");
		customer.setMobile("8765432356");
				
	if (customerRepository.saveCustomer(customer))	{
		System.out.println("customer saved successfully");
	}
	else {
		System.out.println("customer cannot saved ");
	}
		
	
	Customer cust= new Customer();
	cust.setCustId("ranhu134");
	cust.setCreateDate(new Date(new java.util.Date().getTime()));
	cust.setCust_name("ranhul");
	cust.setEmail("ranhu134@gmail.com");
	cust.setMobile("8765432356");
			
if (customerRepository.saveCustomer(cust))	{
	System.out.println("customer saved successfully");
}
else {
	System.out.println("customer cannot saved ");
}
	
		//System.out.println(	customerRepository.getByCustId("anil123"));
		
	}

}
