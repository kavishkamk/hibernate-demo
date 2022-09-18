package io.github.kavishkamk.hibernate.demo;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.github.kavishkamk.jdbc.demo.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Student student = new Student("kavishka", "Madhushan", "kavishka@gmail.com");
		
		try {
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
			// get the new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// get the Student
			Student resStudent = session.get(Student.class, student.getId());
			
			session.getTransaction().commit();
			
			System.out.println(resStudent);
		} catch (IllegalStateException ex) {
			ex.printStackTrace();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
