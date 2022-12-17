package FlightCode;   //FINISHED ALL THE CODE IS WRITTEN

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin extends User{
	
	public final static boolean isAdmin = true;
	public Admin() {
		
	}
	public Admin(String userName, String password) {
		super(userName, password);
	}
	
	public Admin(int userID, String userName, String password, String firstName, String lastName, int ssn,
            String email, String address, int zipCode, String state, String securityQuestion, String securityAnswer) {
		
		super(userID, userName, password, firstName, lastName, ssn, email, address, zipCode, state, securityQuestion, securityAnswer);
	}
	
	
	
	@Override
	public String toString() {
		return "Username : " + this.getUserName() + "\nPassword: " + this.getPassword() 
					+ "ID: " + this.getUserID();
	}
	
	
}
