package com.journaldev.orm.dao;

import java.util.List;

import com.journaldev.orm.model.Tb0237VehicleProject;

public interface ProductDao {

	void persist(Tb0237VehicleProject tb0237VehicleProject);

	List<Tb0237VehicleProject> findAll();

}