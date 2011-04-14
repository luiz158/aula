package br.com.posruy.demo.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {

    private static EntityManagerFactory factory;

    private static EntityManagerFactory getFactory() {
	if (factory == null) {
	    factory = Persistence.createEntityManagerFactory("banco1");
	}

	return factory;
    }

    public static EntityManager create() {
	return getFactory().createEntityManager();
    }
}
