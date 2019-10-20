package coolschool.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import coolschool.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			//Student tempStudent = new Student("Eddi", "Juhnmo", "eddi@coolschool.orc");
			Student tempStudent = new Student("Jackse", "Lopib", "jackse@coolschool.orc");
			
			// start a transaction
			session.beginTransaction() ;
			
						
			// save the student object
			System.out.println(" Saving the student ");
			session.save(tempStudent) ;
			
			// commit transaction
			session.getTransaction().commit();
			
			//close session
			System.out.println(" Done ! ");
			
		session.close();
		}
		finally {
			
			factory.close();
		}
		
		
	}

}
