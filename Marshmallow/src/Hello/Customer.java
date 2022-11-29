package Hello;

import java.util.Random;

import FlightCode.User;

public class Customer extends User{
	
	private User userName; 
	private User password;
	private User firstName;
	private User lastName;
	private User email;
	private User securityQuestion;
	private int passengerId;
	private String address;
	private int zip;
	private String state;

	private int ssn;
	
	public Customer(){	
	}
	public Customer(String userName, String password) {
		super.setUserName(userName);
		super.setPassword(password);
	}
	public Customer(int passengerId, String address, int zip, String state, int ssn) {
		this.passengerId = passengerId;
		this.address = address;
		this.zip = zip;
		this.state = state;
		this.ssn = ssn;
	}
	public Customer( String firstName, String lastName, String email, String securityQuestion, String securityAnswer,
							String address, String zip, String state ) {
		int id =  generatePassengerId();
		Customer account = new Customer();
		//insert into the database
	}
	
	
	public static int generatePassengerId() {
		Random rand = new Random();
		int id = rand.nextInt(99999);
		return id;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	
	
	public Customer(User userName, User password, User firstName, User lastName, User email,
			        User securityQuestion, int passengerId, String address, int zip, String state) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.securityQuestion = securityQuestion;
		this.passengerId = passengerId;
		this.address = address;
		this.zip = zip;
		this.state = state;
	}
	

}
