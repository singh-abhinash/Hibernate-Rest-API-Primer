package LearningHibernate.HibernateProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLOperationWhereClause {

	public static void main(String[] args) {
		
		/**
		 * Sequence Sixth
		 */
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(UsersEntity.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// Begin Transaction
			session.beginTransaction();
						
			/**
			 * I want to fetch whole users table and will do filter and print all the row list.
			 * NOTE: from users -> after users we can write general query for filtering and all.....
			 */
			List<UsersEntity> users = session.createQuery("FROM users WHERE user_id = '2' OR "
					+ "user_id = '5'").getResultList();
			
			for (UsersEntity userDetails : users) {
				System.out.println(userDetails);
			}
			
		} finally {
			
			factory.close();
			session.close();
			System.out.println("*********Closed both SessionFactory and Session*********");
			
		}
				
	}

}
