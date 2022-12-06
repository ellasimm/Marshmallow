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
	
	public void getAdmin(String sql) {
		System.out.println("selecting data..");
		ResultSet resultSet = null;
		try(Connection cnn = DriverManager.getConnection("jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				Statement statement = cnn.createStatement();){
			resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(13) );
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
}
	
	
	@Override
	public String toString() {
		return "Username : " + this.getUserName() + "\nPassword: " + this.getPassword() 
					+ "ID: " + this.getUserID();
	}
	
	
}
