package com.journaldev.orm.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.orm.dao.ProductDao;
import com.journaldev.orm.model.Tb0237VehicleProject;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	/* (non-Javadoc)
	 * @see com.journaldev.orm.service.ProductService#add(com.journaldev.orm.model.Tb0237VehicleProject)
	 */
	@Override
	@Transactional
	public void add(Tb0237VehicleProject tb0237VehicleProject) {
		productDao.persist(tb0237VehicleProject);
	}

	/* (non-Javadoc)
	 * @see com.journaldev.orm.service.ProductService#addAll(java.util.Collection)
	 */
	@Override
	@Transactional
	public void addAll(Collection<Tb0237VehicleProject> tb0237VehicleProjects) {
		for (Tb0237VehicleProject tb0237VehicleProject : tb0237VehicleProjects) {
			productDao.persist(tb0237VehicleProject);
		}
	}

	/* (non-Javadoc)
	 * @see com.journaldev.orm.service.ProductService#listAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Tb0237VehicleProject> listAll() {
		return productDao.findAll();

	}

}
