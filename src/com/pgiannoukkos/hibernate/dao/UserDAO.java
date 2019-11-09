package com.pgiannoukkos.hibernate.dao;

import com.pgiannoukkos.hibernate.bean.User;
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

		// SQL query
		String hql = "SELECT uname, email FROM users WHERE uname = :userName OR email = :email";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter("userName", userName);
		query.setParameter("email", email);

		List res = query.list();

		if (!res.isEmpty()) {
			System.out.println("\n\n User Exists \n");
			session.close();
			sessionFactory.close();
			return true;
		}

		session.close();
		sessionFactory.close();
		return false;
	}

	public static void createUser(String userName, String passWord, String email) throws HibernateException {

		// Configure Hibernate
		Configuration configuration = new Configuration().configure();

		// Create SessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Get Session object
		Session session = sessionFactory.openSession();

		// Starting Transaction
		Transaction transaction = session.beginTransaction();

		// Create User object and add to database
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setEmail(email);

		session.save(user);
		transaction.commit();

		System.out.println("\n\n User Added \n");

		// Close the Transacrion
		session.close();
		sessionFactory.close();
	}

	public static boolean checkUserLogin(String userName, String password) throws HibernateException {

		// Configure Hibernate
		Configuration configuration = new Configuration().configure();

		// Create SessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Get Session object
		Session session = sessionFactory.openSession();

		// SQL query
		String hql = "SELECT uname, password FROM users WHERE uname = :userName";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter("userName", userName);

		List<User[]> res = query.list();

		if (res.isEmpty()) {
			System.out.println("\n\n User not Found \n");
			session.close();
			sessionFactory.close();
			return true;
		} else {
			for (User[] row: res) {
				System.out.println(row[0].toString() + "\t" + row[1].toString());
			}
		}

		return false;
	}
}
