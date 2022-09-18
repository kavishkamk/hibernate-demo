package io.github.kavishkamk.hibernate.demo;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.github.kavishkamk.jdbc.demo.entity.Student;

public class QueryStudent {

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

			// start a transaction
			session.beginTransaction();
			
			System.out.println("Query 1");
			// query student
			List<Student> students = session.createQuery("from Student").getResultList();
			
			for (Student tempStudent : students) {
				System.out.println(tempStudent);
			}
			
			System.out.println("Query 2");
			
			students = session.createQuery("from Student s where s.lastName='Madhushan'").getResultList();
			
			for (Student tempStudent : students) {
				System.out.println(tempStudent);
			}
			
			System.out.println("Query 3");
			
			students = session.createQuery("from Student s where s.firstName='Kavishka' OR"
					 + " lastName='Madhushan'").getResultList();
			
			for (Student tempStudent : students) {
				System.out.println(tempStudent);
			}
			
			System.out.println("Query 4");
			
			students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			for (Student tempStudent : students) {
				System.out.println(tempStudent);
			}
			
			// commit transaction
			session.getTransaction().commit();

		} catch (IllegalStateException ex) {
			ex.printStackTrace();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

}
