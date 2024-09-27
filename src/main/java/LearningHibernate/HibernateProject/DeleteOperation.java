package LearningHibernate.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteOperation {
	
	public static void main( String[] args ) {
		
		/**
		 * Sequence Fourth
		 */
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(UsersEntity.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create object for Entity class
			UsersEntity user = new UsersEntity();
			
			// Begin transaction
			session.beginTransaction();
			
			// Perform Operation
			user = session.get(UsersEntity.class, 4);
			session.delete(user);
			
			// Commit Transaction
			session.getTransaction().commit();
			System.out.println("********Deleting Existing Row with Unique user_id and CRUD Operation performed********");
			
		} finally {
			
			factory.close();
			session.close();
			System.out.println("**********Delete CRUD Operation Performed********");
			
		}
		
	}
}
