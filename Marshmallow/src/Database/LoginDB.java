package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class LoginDB {
	private static final Logger log = null;
	
	public String confirmLogin(String userName, Connection connection) {
		String result = "";
		
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Get data");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AccountUser WHERE userName=" + "'" + userName + "'");
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getString("password");
			}

			connection.close();
		}catch( SQLException ex) {  //add classNotFundException
			System.out.println("An error occured in database");
			ex.printStackTrace();
		}
		return result;
	}
	
	public String returnPassword(String email, String securityAnswer, Connection connection) {
		String correctSecurityAnswer = "";
		String userAnswer = securityAnswer;
		String password ="";
		String result = "";
		
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Get data");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AccountUser WHERE email=" + "'" + email + "'");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				
				password = resultSet.getString("password");
				correctSecurityAnswer = resultSet.getString("securityAnswer");	
				System.out.println(password + correctSecurityAnswer);	
				
			}
			if (!userAnswer.equals(correctSecurityAnswer)) {
				result = "Incorrect answer to security question";
			
			}
			else if (userAnswer.equals(correctSecurityAnswer)) {
				result = "Your password is: " + password; 
				
			}
			else {
				result = "An account with that email address was not found.";
				
				}
			
			connection.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return result;
	}
	
	public Boolean findEmail(String email, Connection connection) {
		int check = 0;
		boolean result = false;
		
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Get data");																				//why is it userName with email????
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AccountUser WHERE userName=" + "'" + email + "'");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				check = resultSet.getInt("ssn");
			}
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		if(check < 0) {
			result = false;
		}
		if(check > 0) {
			result = true;
		}
				
		return result;
		
	}

}
