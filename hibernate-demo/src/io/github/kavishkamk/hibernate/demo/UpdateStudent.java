package io.github.kavishkamk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.github.kavishkamk.jdbc.demo.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		// create session factory
		// mention the hibernate.cfg.xml is optional
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();
		
		int studentId = 1;

		try {
			
			// update

			// start a transaction
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId);
			
			student.setFirstName("Elone");
			
			session.createQuery("update Student set email='sample@gmail.com' ").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
