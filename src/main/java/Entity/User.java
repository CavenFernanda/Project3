package Entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;

	@Column(name = "dob")
	private Calendar dob;

	@Column(name = "address", length = 40)
	private String address;

	@Column(name = "phone_no", length = 20)
	private String phoneNo;

	@Column(name = "email_address", length = 40, nullable = false)
	private String emailAddress;

	@Column(name = "username", length = 30, nullable = false)
	private String username;

	@Column(name = "password", length = 15, nullable = false)
	private String password;

	public User() {
		super();
	}
	
	public User(String firstName, String lastName, Calendar dob, String address, String phoneNo,

			String emailAddress, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.phoneNo = phoneNo;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Resource [id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", dob = "
				+ dob.getTime() + ", address = " + address + ", phoneNo = " + phoneNo + ", emailAddress = "
				+ emailAddress + ", username = " + username + ", password = " + password + " ]";
	}

}