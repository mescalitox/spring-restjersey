/**
 * 
 */
package com.journaldev.jaxrs.service;

import javax.ws.rs.core.Response;

import com.journaldev.jaxrs.model.Employee;

/**
 * @author julien.aubert (AUBAY)
 * @date 27 janv. 2017
 * @version 1.0
 */
public interface EmployeeService {

	Response addEmployee(Employee e);

	Response deleteEmployee(int id);

	Employee getEmployee(int id);

	Employee[] getAllEmployees();

}
