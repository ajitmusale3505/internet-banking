package com.jsp.internatebanking.Driver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.internatebanking.entity.Users;

public class UserDriver {
	 
	static	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ajit");
	
	public  boolean createUser(String name,String email, String password, double balance) {
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
		Users user = new Users(name, email, password, balance);
		et.begin();
		em.persist(user);
		et.commit();
		return true;
	}
	
	public Users getUser(String email,String pass) {
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    try {
			String query = "SELECT u FROM Users u WHERE u.email = :email AND u.password = :pass";	
			Users user = em.createQuery(query,Users.class)
			.setParameter("email", email)
			.setParameter("pass", pass)
			.getSingleResult();
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
