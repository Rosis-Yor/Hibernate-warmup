package coolschool.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import coolschool.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory() ;				
				
				// create session
				Session session = factory.getCurrentSession() ;
				
				try {
				
					int studentId = 1;
					
					// now get a new session and start transaction
					session = factory.getCurrentSession();
					session.beginTransaction() ;
					
					Student myStudent = session.get(Student.class, studentId ) ;
					 
					System.out.println(" Deleting sdtudent .. " + myStudent);
					session.delete(myStudent);
					
					
					// commit the transaction
					session.getTransaction().commit();
					
					
					
					//close session
					System.out.println(" Done ! ");
					
				
				}
				finally {
					
					factory.close();
				}
	}
}
