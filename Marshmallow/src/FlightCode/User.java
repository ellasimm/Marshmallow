package FlightCode;  


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;


import Database.InsertDB;


public class User implements Comparable<User>{
	
	private String userName; 
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String securityQuestion;
	private String securityAnswer;
	private int userID;
	private String address;
	private int zipCode;
	private String state;
	private int ssn;
	public int isAdmin = -1;
	
	public User() {
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public User(int userID, String userName, String password, String firstName, String lastName, int ssn,
            String email, String address, int zipCode, String state, String securityQuestion, String securityAnswer) {
		this.userID = userID;
		this.userName = userName; 
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.email = email;
		this.address = address;
		this.zipCode = zipCode;
		this.state = state;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	
	
	public static void generateUser(String userName, String password, String firstName, String lastName, int ssn,
            String email, String address, int zipCode, String state, String securityQuestion, String securityAnswer) throws SQLException {
		
		int userID = generateUserId();
		User user = new User(userID, userName, password, firstName, lastName, ssn, email, address, zipCode, state, securityQuestion, securityAnswer);
//		String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//		Connection connection = DriverManager.getConnection(cnnString); //create connection to the database
		InsertDB.insertAccount(user);  //need to insert this user into the database
	}
	
	
	public static int generateUserId() {
		Random rand = new Random();
		int id = rand.nextInt(99999);
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
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


	@Override
	public String toString() {
		return "First Name: " + this.getFirstName() + "\nLast Name: " + this.getLastName()
				+ "\nUser ID: "+ this.getUserID() + "\nUsername: " + this.getUserName();
	}

	@Override
	public int compareTo(User o) {
		if (ssn == o.getSsn()) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}