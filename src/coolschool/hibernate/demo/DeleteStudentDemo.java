package coolschool.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import coolschool.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
					
					// find out the students id : primary key
					System.out.println(" Saved student. Generated id: " + studentId);
					
					
					// now get a new session and start transaction
					session = factory.getCurrentSession();
					session.beginTransaction() ;
					
					// retrieve student based on the id: primary key
					System.out.println("\nGetting student with id : " + studentId);
					
					Student myStudent = session.get(Student.class, studentId ) ;
					 
					System.out.println(" Updating student ... : " + myStudent);
					myStudent.setFirstName("Scooby");
					
					session.getTransaction().commit();
					// commit the transaction
					
					// NEW CODE
					
					session = factory.getCurrentSession();
					session.beginTransaction() ;
					
					// commit the transaction
					session.getTransaction() ;
					
					// update email for studentId = 3
					studentId  = 3;
					session.createQuery("update Student set email='secOps@coolschool.orc' where id=" + studentId)
					.executeUpdate();
					
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
