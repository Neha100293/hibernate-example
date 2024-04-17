package com.neha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.neha.model.UserDetails;

public class DeleteRecord {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("/com/neha/hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.load(UserDetails.class, new Integer(2));
		UserDetails s = (UserDetails) o;

		Transaction tx = session.beginTransaction();
		session.delete(s);
		System.out.println("User Deleted successfully.....!!");
		tx.commit();
		session.close();
		factory.close();

	}

}
