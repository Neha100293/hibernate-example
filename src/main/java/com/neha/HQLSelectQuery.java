package com.neha;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neha.model.UserDetails;

public class HQLSelectQuery {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("/com/neha/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserDetails userDetails ");

		List l = query.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o = (Object) it.next();
			UserDetails userDetails = (UserDetails) o;
			System.out.println("User id : " + userDetails.getUserId());
			System.out.println("UserName : " + userDetails.getUserName());

			System.out.println("----------------------");
			session.close();
			sessionFactory.close();
		}
	}

}
