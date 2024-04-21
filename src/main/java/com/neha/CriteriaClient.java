package com.neha;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neha.model.Product;

public class CriteriaClient {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();

		cfg.configure("/com/neha/hibernate.cfg.xml");

		// create sessionFactory object
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		// session.save(product);

		// **creating CriteriaBuilder**
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);

		Root<Product> productRoot = criteriaQuery.from(Product.class);
		criteriaQuery.select(productRoot);

		// **Adding where clause**
		criteriaQuery.where(builder.equal(productRoot.get("price"), Double.valueOf(477)));
		List<Product> listProduct = session.createQuery(criteriaQuery).getResultList();

		System.out.println("List total size..._" + listProduct.size());
		Iterator<Product> itr = listProduct.iterator();

		while (itr.hasNext()) {
			Product product1 = (Product) itr.next();
			System.out.println(product1.getProductId() + " " + product1.getProductName() + " " + product1.getPrice());
			System.out.println("-----------------");
		}

		session.close();
		factory.close();
	}
}
