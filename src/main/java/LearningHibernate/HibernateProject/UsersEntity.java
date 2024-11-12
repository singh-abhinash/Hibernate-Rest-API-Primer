package LearningHibernate.HibernateProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// You apply @Entity to a class to indicate that the class represents a database table.
@Entity(name = "users")
// You use @Table to specify the name of the database table (if it’s different from the class name) or other 
//table-related settings (like schema or catalog).
@Table(name = "users")
public class UsersEntity {
	
	//Primary key
	@Id
	@Column(name = "user_id")
	int userId;
	
	@Column(name = "first_name")
	String firstName;
	
	@Column(name = "last_name")
	String lastName;
	
	@Column(name = "email_id")
	String emailId;
	
	@Column(name = "age")
	int age;
	
	public UsersEntity() {
		super();
	}

	public UsersEntity(String firstName, String lastName, String emailId, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.age = age;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UsersEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", age=" + age + "]";
	}
	
	
	
	
}
