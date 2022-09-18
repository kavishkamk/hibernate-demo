package io.github.kavishkamk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.github.kavishkamk.jdbc.demo.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {

		// create session factory
		// mention the hibernate.cfg.xml is optional
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// use session object to save the student save object

			// create Student object
			Student student = new Student("Kavishak", "Madhushan", "kavishka@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(student);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
