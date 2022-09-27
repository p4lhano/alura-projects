package dev.palhano.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public static EntityManager getEntityManagerFactory() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja-persistem-unity");
		return factory.createEntityManager() ;		
	}
	
}
