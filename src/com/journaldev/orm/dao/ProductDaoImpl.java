package com.journaldev.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.journaldev.orm.model.Tb0237VehicleProject;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see com.journaldev.orm.dao.ProductDao#persist(com.journaldev.orm.model.Tb0237VehicleProject)
	 */
	@Override
	public void persist(Tb0237VehicleProject tb0237VehicleProject) {
		em.persist(tb0237VehicleProject);
	}

	/* (non-Javadoc)
	 * @see com.journaldev.orm.dao.ProductDao#findAll()
	 */
	@Override
	public List<Tb0237VehicleProject> findAll() {
		return em.createQuery("SELECT p FROM Tb0237VehicleProject p").getResultList();
	}

}
