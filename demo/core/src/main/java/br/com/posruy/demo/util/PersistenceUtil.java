package br.com.posruy.demo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static EntityManagerFactory factory;

    private static EntityManagerFactory getFactory() {
	if (factory == null) {
	    factory = Persistence.createEntityManagerFactory("banco1");
	}

	return factory;
    }

    public static EntityManager createEntityManager() {
	return getFactory().createEntityManager();
    }
}
