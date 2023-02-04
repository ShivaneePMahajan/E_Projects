package com.daoImplementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.dao.LibraryDao;
import com.entity.Book;
import com.entity.User;
import com.utility.hibernateUtility;

public class LibraryDaoImplementation implements LibraryDao {

	@Override
	public void createUser() {
		SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		LocalDate time = LocalDate.now();
		LocalDate submit_time = null;

		// ------------------------------------User------------------------------------------//

		User u1 = new User(1001, "Shivanee", "Burhanpur", 900968035, 1, time, submit_time);

		User u2 = new User(1002, "Bhushan", "Mumbai", 984628759, 2, time, submit_time);

		User u3 = new User(1003, "Vaishnavi", "Khandwa", 867945739, 3, time, submit_time);

		// ------------------------------------Book------------------------------------------//
		Book b1 = new Book(1, "IT", "Head First Java", "Kathy Sierra", 1000);
		Book b2 = new Book(2, "IT", "Head First C", "David Griffiths", 1100);
		Book b3 = new Book(3, "Story Book", "Panchtantra ki kahaniya", "Premchand", 300);
		Book b4 = new Book(4, "Comic Book", "Amar Chitra Katha", "Anant Pai", 500);

		u1.setBook(b1);
		u2.setBook(b2);
		u3.setBook(b4);

		session.save(b1);
		session.save(u1);

		session.save(b2);
		session.save(u2);

		session.save(b4);
		session.save(u3);

		System.out.println("Inserted Successfully");
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

	@Override
	public List<User> loadUser() {
		SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query<User> query1 = session.createQuery("from User");

		List<User> result = query1.list();

		for (User u : result) {
			System.out.println(u.getUserId());
			System.out.println(u.getUserName());
			System.out.println(u.getBook());
			System.out.println(u.getTime());
			System.out.println(u.getSubmit_time());

		}

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

		return result;
	}

	@Override
	public void updateUser(int id) {

		SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		User user = (User) session.get(User.class, id);
		user.setSubmit_time(LocalDate.now());

		System.out.println("Updated Successfully");
		session.getTransaction().commit();
		sessionFactory.close();

	}

	@Override
	public void deleteCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the user id number");
		int id = sc.nextInt();
		SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		User u = (User) session.load(User.class, id);
		session.delete(u);

		System.out.println("Deleted Successfully");
		session.getTransaction().commit();
		sessionFactory.close();
	}

}
