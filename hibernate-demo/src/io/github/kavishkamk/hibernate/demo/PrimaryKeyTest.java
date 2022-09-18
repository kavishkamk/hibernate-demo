package io.github.kavishkamk.hibernate.demo;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.github.kavishkamk.jdbc.demo.entity.Student;

public class PrimaryKeyTest {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Student student1 = new Student("kavishka", "Madhushan", "kavishka@gmail.com");
		Student student2 = new Student("kavishka", "Madhushan", "kavishka@gmail.com");
		Student student3 = new Student("kavishka", "Madhushan", "kavishka@gmail.com");
		
		try {
			session.beginTransaction();
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
		} catch (IllegalStateException ex) {
			ex.printStackTrace();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
