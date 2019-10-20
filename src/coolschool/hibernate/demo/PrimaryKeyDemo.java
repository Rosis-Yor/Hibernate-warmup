package coolschool.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import coolschool.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
					// create 3 student objects
					System.out.println(" Creating 3 student objects ... ");
					Student tempStudent1 = new Student("Hugo", "Kimny", "hugo@coolschool.orc");
					Student tempStudent2 = new Student("Percy", "Fyo", "percy@coolschool.orc");
					Student tempStudent3 = new Student("Omni", "Swute", "Omni@coolschool.orc");
					
					
					
					// start a transaction
					session.beginTransaction() ;
					
								
					// save the student object
					System.out.println(" Saving the students .. ");
					session.save(tempStudent1) ;
					session.save(tempStudent2) ;
					session.save(tempStudent3) ;
					
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


