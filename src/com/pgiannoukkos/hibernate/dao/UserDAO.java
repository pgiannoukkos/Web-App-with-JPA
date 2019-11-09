package com.pgiannoukkos.hibernate.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class UserDAO {

	public static boolean userExists(String userName, String email) throws HibernateException {

		// Configure Hibernate
		Configuration configuration = new Configuration().configure();

		// Create SessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Get Session object
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		// SQL query
		String hql = "SELECT uname, email FROM users WHERE uname = :userName OR email = :email";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter("userName", userName);
		query.setParameter("email", email);

		List res = query.list();

		if (!res.isEmpty()) {
			System.out.println("\n\n User Exists \n");
			return true;
		}

		return false;
	}
}
