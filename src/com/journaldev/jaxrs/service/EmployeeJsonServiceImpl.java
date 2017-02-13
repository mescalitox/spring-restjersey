/**
 * 
 */
package com.journaldev.jaxrs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.journaldev.jaxrs.model.Employee;
import com.journaldev.jaxrs.model.GenericResponse;
import com.journaldev.orm.dao.ProductDao;
import com.journaldev.orm.model.Tb0237VehicleProject;
import com.journaldev.orm.service.ProductService;

/**
 * @author julien.aubert (AUBAY)
 * @date 27 janv. 2017
 * @version 1.0
 */
@Path("/employeeJson")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Component
public class EmployeeJsonServiceImpl implements EmployeeService {

	private static Map<Integer, Employee> emps = new HashMap<Integer, Employee>();

	@Override
	@POST
	@Path("/add")
	public Response addEmployee(Employee e) {
		GenericResponse response = new GenericResponse();
		if (emps.get(e.getId()) != null) {
			response.setStatus(false);
			response.setMessage("Employee Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		emps.put(e.getId(), e);
		response.setStatus(true);
		response.setMessage("Employee created successfully");
		return Response.ok(response).build();
	}

	@Override
	@DELETE
	@Path("/{id}/delete")
	public Response deleteEmployee(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse();
		if (emps.get(id) == null) {
			response.setStatus(false);
			response.setMessage("Employee Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build();
		}
		emps.remove(id);
		response.setStatus(true);
		response.setMessage("Employee deleted successfully");
		return Response.ok(response).build();
	}

	@Override
	@GET
	@Path("/{id}/get")
	public Employee getEmployee(@PathParam("id") int id) {
		return emps.get(id);
	}

	@GET
	@Path("/{id}/getDummy")
	public Employee getDummyEmployee(@PathParam("id") int id) {
		Employee e = new Employee();
		e.setSalary(8976.55);
		e.setName("Dummy");
		e.setId(id);
		return e;
	}

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductDao productDao;


	@Override
	@GET
	@Path("/getAll")
	public Employee[] getAllEmployees() {

		List<Tb0237VehicleProject> liste = productService.listAll();

		Set<Integer> ids = emps.keySet();
		Employee[] e = new Employee[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			e[i] = emps.get(id);
			i++;
		}
		return e;
	}



}