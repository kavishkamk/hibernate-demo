package io.github.kavishkamk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.github.kavishkamk.jdbc.demo.entity.Student;

public class DeleteStudent {

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

			// delete

			// start a transaction
			session.beginTransaction();

			Student student = session.get(Student.class, 2);
			
			session.delete(student);
			
			session.createQuery("delete from Student where id=3").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
