package com.jsp.internatebanking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jsp.internatebanking.entity.BankTransaction;
import com.jsp.internatebanking.entity.Users;
import com.jsp.internatebanking.util.JPAUtil;

public class TransactionDao {

	public static boolean isValidUSer(String email) {
		EntityManager em = JPAUtil.getEMF();
		System.out.println("Email from TransactionDao : "+email);
		try {
			Query query = em.createQuery("from Users u where u.email=:email");
			query.setParameter("email", email);
			Object singleResult = query.getSingleResult();
			System.out.println("Result : "+singleResult);
			return true;
		} catch (Exception e) {
			 return false;
		}
	}
	
	public static Users getUserId(String email) {
		EntityManager em = JPAUtil.getEMF();
		try {
			Query query = em.createQuery("from Users u where u.email=:email");
			query.setParameter("email", email);
			Users user = (Users) query.getSingleResult();
			System.out.println("Result : "+user);
			return user;
		} catch (Exception e) {
			 return  null;
		}
	}
	
	public static List<BankTransaction> getAllTransactions(int userId) {
	    EntityManager em = JPAUtil.getEMF();
	    try {
	        Query query = em.createQuery(
	            "from BankTransaction b where b.reciverID = :rid or b.senderID = :sid"
	        );

	        query.setParameter("rid", userId);
	        query.setParameter("sid", userId);

	        return query.getResultList();

	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
}
