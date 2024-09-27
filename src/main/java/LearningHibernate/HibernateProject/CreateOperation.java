package LearningHibernate.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateOperation {
	
	/**
	 * First
	 */
    public static void main( String[] args ) {
        SessionFactory factory = new Configuration()
        						.configure("hibernate.cfg.xml")
        						.addAnnotatedClass(UsersEntity.class)
        						.buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
        	
        	// Create object of entity class type
        	UsersEntity user = new UsersEntity("Anish", "Singh", "anish@gmail.com", 39);
        	
        	// Begin transaction
        	session.beginTransaction();
        	
        	// Perform Operation
        	session.save(user);
        	
        	// Commit the Transaction
        	session.getTransaction().commit();
        	
        	System.out.println("*********New Row Added*********");
        } finally {
        	
        	factory.close();
        	session.close();
        	
        	System.out.println( "***********Created New Row and CRUD Opertion Performed***********" );
        }
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * In web development, the CRUD operations map directly to HTTP methods commonly used in RESTful APIs:

Create (POST): To create a new resource.
HTTP Method: POST
Description: Used to send data to the server to create a new resource (e.g., adding a new user or item to a database).

Read (GET): To retrieve existing resources.
HTTP Method: GET
Description: Used to retrieve data from the server (e.g., fetching user details, list of products).

Update (PUT/PATCH): To update an existing resource.
HTTP Method: PUT (for full updates) or PATCH (for partial updates).
Description: Used to modify existing data on the server (e.g., updating user information).

Delete (DELETE): To delete a resource.
HTTP Method: DELETE
Description: Used to delete data from the server (e.g., removing a user or an item).


************************************
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

In Hibernate, the difference between SessionFactory and Session can be understood with a simple analogy:

SessionFactory is like a factory or blueprint for creating database connections.
Session is like an individual connection or conversation with the database.

Key Differences:

SessionFactory (Factory for Sessions):
	Purpose: It is responsible for creating and managing Session objects.
	Lifecycle: It is a heavyweight object created once per application. It is typically created when the application starts and destroyed when the application shuts down.
	Thread-Safe: Multiple threads can share a single SessionFactory instance because it is designed to be 
	thread-safe.
	Example Use: You use SessionFactory to obtain Session instances.
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

Session (Instance of Database Interaction):
	Purpose: It is responsible for performing CRUD (Create, Read, Update, Delete) operations in the database.
	Lifecycle: It is a lightweight object created for each interaction with the database (usually per transaction 
	or per request). Once the work is done, the session is closed.
	Not Thread-Safe: A Session instance is not thread-safe. It is meant to be used by a single thread at a time.
	Example Use: A Session is used to interact with the database.
	Session session = sessionFactory.getCurrentSession();

Quick Recap:
	SessionFactory: One per application, creates Session objects, thread-safe.
	Session: Created for each database interaction, not thread-safe, performs actual database operations.
 */
