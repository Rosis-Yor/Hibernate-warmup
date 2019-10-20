package coolschool.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import coolschool.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory() ;				
				
				// create session
				Session session = factory.getCurrentSession() ;
				
				try {
					// use the session object to save Java object
					// create a student object
					System.out.println(" Creating new student object ... ");
					Student tempStudent = new Student("Duffy", "Duck", "duffy@coolschool.orc");
					
					// start a transaction
					session.beginTransaction() ;
					
								
					// save the student object
					System.out.println(" Saving the student ");
					session.save(tempStudent) ;
					
					// commit transaction
					session.getTransaction().commit();
					
					// MY NEW CODE
					// find out the students id : primary key
					System.out.println(" Saved student. Generated id: " + tempStudent.getId());
					
					
					// now get a new session and start transaction
					session = factory.getCurrentSession();
					session.beginTransaction() ;
					
					// retrieve student based on the id: primary key
					System.out.println("\nGetting student with id : " + tempStudent.getId());
					
					Student myStudent = session.get(Student.class, tempStudent.getId()) ;
					 
					System.out.println("Get complete : " + myStudent);

					session.getTransaction().commit();
					// commit the transaction
					
					
					
					
					
					//close session
					System.out.println(" Done ! ");
					
				
				}
				finally {
					
					factory.close();
				}
	}
}