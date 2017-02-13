package com.journaldev.orm.service;

import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.journaldev.orm.model.Tb0237VehicleProject;

public interface ProductService {

	void add(Tb0237VehicleProject tb0237VehicleProject);

	void addAll(Collection<Tb0237VehicleProject> tb0237VehicleProjects);

	List<Tb0237VehicleProject> listAll();

}