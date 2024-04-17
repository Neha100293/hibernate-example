package com.neha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neha.model.UserDetails;

public class InsertRecord {

	public static void main(String [] args) {
	System.out.println("project Started");
	
	UserDetails userDetails = new UserDetails();
    userDetails.setUserId(2);
    userDetails.setUserName("Kratika");
    
	Configuration cfg = new Configuration();
	cfg.configure("/com/neha/hibernate.cfg.xml");
	SessionFactory sessionFactory =cfg.buildSessionFactory();
	 Session session = sessionFactory.openSession();
     session.beginTransaction();
     session.save(userDetails);
     session.getTransaction().commit();
     session.close();
     sessionFactory.close();
     
	System.out.println(sessionFactory);
	}
}