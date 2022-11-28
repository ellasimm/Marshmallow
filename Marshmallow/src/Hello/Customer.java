package Hello;

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
	
	public Customer() {
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
