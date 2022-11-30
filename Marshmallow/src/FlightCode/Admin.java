package FlightCode;

public class Admin extends User{
	
	private int adminId;
	public final static boolean isAdmin = true;
	
	public Admin(String userName, String password) {
		super(userName, password);
	}
	
	public Admin(int userID, String userName, String password, String firstName, String lastName, int ssn,
            String email, String address, int zipCode, String state, String securityQuestion, String securityAnswer) {
		super(userID, userName, password, firstName, lastName, ssn, email, address, zipCode, state, securityQuestion, securityAnswer);
	}
	
	//connect to DB
	public void addFlight() {
	}
	public void updateFlight() {
	}
	public void cancelFlight() {
	}
}
