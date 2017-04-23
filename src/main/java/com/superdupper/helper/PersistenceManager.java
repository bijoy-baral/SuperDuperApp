package com.superdupper.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Bijoy
 * @version 1.0
 * This class instantiates entity manager factory for establishing DB connection using Hibernate JPA implementation
 * for SuperDupper Jackson Jersey JAXRS REST Application.
 *
 */
public enum PersistenceManager {
	INSTANCE;
	private EntityManagerFactory emFactory;
	
	private PersistenceManager() {
		emFactory = Persistence.createEntityManagerFactory("super-dupper");
	}
	
	/**
	 * Get instance of Hibernate entity manager.
	 * @return
	 */
	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
	
	/**
	 * Close the DB connection once user perform 
	 * insert/update/delete operations.
	 */
	public void close() {
		emFactory.close();
	}
}
