package com.neha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.neha.model.UserDetails;

public class UpdateRecordSecondApproch {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("/com/neha/hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();	

		UserDetails p=new UserDetails();
		p.setUserId(1);
		p.setUserName("Neha Dhameniya");  
		Transaction tx = session.beginTransaction();
			session.update(p);
		tx.commit();

		System.out.println("user Updated successfully.");
		session.close();
		factory.close();
	}

}
