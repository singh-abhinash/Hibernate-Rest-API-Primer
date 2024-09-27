package LearningHibernate.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateOperation {

	public static void main( String[] args) {
		
		/**
		 * Sequence Third 
		 */
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(UsersEntity.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create object of entity class type
        	UsersEntity user = new UsersEntity();
        	
        	// Begin transaction
        	session.beginTransaction();
        	
        	// Perform Operation
        	user = session.get(UsersEntity.class, 3);
        	user.setFirstName("Divyansh");
        	user.setAge(15);
        	
        	// Commit the Transaction
        	session.getTransaction().commit();
        	System.out.println(user);
        	
			System.out.println("********Udating Existing Row with Unique user_id and CRUD Operation performed********");
			
		} finally {
			
			factory.close();
			session.close();
			System.out.println("**********Update Operation performed********");
			
		}
	}
}
