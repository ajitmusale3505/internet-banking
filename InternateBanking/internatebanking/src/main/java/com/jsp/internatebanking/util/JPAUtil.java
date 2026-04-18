package com.jsp.internatebanking.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ajit");

	private JPAUtil() {
		
	}
	
	public static EntityManager getEMF() {
		return emf.createEntityManager();
	}
}
