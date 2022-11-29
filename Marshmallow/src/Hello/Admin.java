package Hello;

public class Admin extends User{
	
	private User userName; 
	private User password;
	private User firstName;
	private User lastName;
	private User email;
	private User securityQuestion;
	private int adminId;
	
	public Admin() {
	}
	public Admin(User userName, User password, User firstName, User lastName, User email, User securityQuestion, int adminId) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.securityQuestion = securityQuestion;
		this.adminId = adminId;
	}
	public void addFlight() {
	}
	public void updateFlight() {
	}
	public void cancelFlight() {
	}
}
