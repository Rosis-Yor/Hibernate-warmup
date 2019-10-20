package coolschool.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import coolschool.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory() ;				
		
		// create session
		Session session = factory.getCurrentSession() ;
		
		try {
			
					
			// start a transaction
			session.beginTransaction() ;
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList() ;
			
			// display the students
		displayStudents(theStudents);
		
		// query students : last name = 'Duck'
		theStudents = session.createQuery("from Student s where s.lastName='Duck'").list() ;
		// display the students
		System.out.println("\n\n The students, who have the last name of Duck ");
				displayStudents(theStudents);
		
				
			// query students : lastName = 'Fyo' and firstName = 'Sikha'
			theStudents = session.createQuery("from Student s where " 
			+ "s.lastName='Fyo' or s.firstName = 'Sikha'").getResultList() ;
				
			
			System.out.println("\n\n Students who have last name \"Fyo\" or First name \"Sikha\"");
			displayStudents(theStudents);	
			
			// query student where email LIKE '%coolschool.orc'
			theStudents = session.createQuery("from Student s where s.email LIKE '%coolschool.orc'").getResultList() ; 
			
			System.out.println("\n\n Students who have email LIKE '%coolschool.orc'");
			displayStudents(theStudents);	
			
			// commit transaction
			session.getTransaction().commit();
			
			//close session
			System.out.println(" Done ! ");
			
		
		}
		finally {
			
			factory.close();
		}
		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			
			System.out.println(tempStudent);
		}
	}

}
