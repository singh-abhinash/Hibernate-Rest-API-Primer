package LearningHibernate.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLOperationUpdate {

	public static void main(String[] args) {
		
		/**
		 * Sequence Seventh
		 */
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(UsersEntity.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// Begin transaction
			session.beginTransaction();
			
			/**
			 * I want to update age using particular user_id in the users table.
			 */
			session.createQuery("UPDATE users SET age = 40 WHERE user_id = 3").executeUpdate();
			System.out.println("********Updated age using HQL query******");
			
			// Commit the transaction
            session.getTransaction().commit();
			
		} finally {
			
			factory.close();
			session.close();
			System.out.println("*********Closed both SessionFactory and Session*********");
			
		}

	}

}
