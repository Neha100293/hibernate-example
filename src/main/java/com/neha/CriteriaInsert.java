package com.neha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neha.model.Product;

public class CriteriaInsert {

	public static void main(String[] args) {
		Product product = new Product();
		product.setProductId(2);
		product.setProductName("Mouse");
		product.setPrice(999);
		Configuration cfg = new Configuration();
		cfg.configure("/com/neha/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

		System.out.println(sessionFactory);

	}

}
