package com.journaldev.jaxrs.service;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.journaldev.orm.dao.ProductDaoImpl;
import com.journaldev.orm.service.ProductServiceImpl;

/**
 * Registers the components to be used by the JAX-RS application  
 * 
 * @author ama
 *
 */
public class MyDemoApplication extends ResourceConfig {

    /**
	* Register JAX-RS application components.
	*/	
	public MyDemoApplication(){
		register(RequestContextFilter.class);
		
		register(JacksonFeature.class);		
		
		register(RequestContextFilter.class);
		register(ProductDaoImpl.class);
		register(ProductServiceImpl.class);
		register(EmployeeJsonServiceImpl.class);
	}
}

