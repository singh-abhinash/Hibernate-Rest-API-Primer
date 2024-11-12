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
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * In Hibernate, a transaction represents a single unit of work that is either fully completed or fully rolled back 
 * if something goes wrong.
 * 
 * Here’s what a transaction does in simple terms:
 * -> Begin Transaction: You start a transaction before making changes (like saving, updating, or deleting) in the 
 * database.
 * -> Make Changes: Perform the operations (insert, update, delete) you need within the transaction.
 * -> Commit: When all operations are successful, you commit the transaction to save the changes permanently in the 
 * database.
 * -> Rollback: If there’s an error, you can rollback the transaction to undo any changes, keeping the database in a 
 * consistent state.
 */
