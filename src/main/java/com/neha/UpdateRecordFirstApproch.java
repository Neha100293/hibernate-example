package com.neha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.neha.model.UserDetails;

public class UpdateRecordFirstApproch {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("/com/neha/hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Object o = session.load(UserDetails.class, new Integer(4));
		UserDetails s = (UserDetails) o;

		Transaction tx = session.beginTransaction();

		s.setUserName("Neelima");

		tx.commit();

		System.out.println("user Updated successfully.!");
		session.close();
		factory.close();
	}

}
