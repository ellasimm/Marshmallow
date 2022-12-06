package Database;

import java.sql.Connection;
import java.sql.*;

public class LoginDB {
	
	static final String url = "jdbc:sqlserver://cisproject2022.database.windows.net:1433;database=FlightReservationProject;user=RezaKian@cisproject2022;password=Saglover2?;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	static Connection cnn;
	
	public String loginConnection(String username) {
		String result = "";
		
		try {
			Class.forName("java.sql.Driver");
			
			System.out.println("database connected");
			
			cnn = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = cnn.prepareStatement("SELECT * FROM AccountUser WHERE userName=" + "'" + username + "'");
			ResultSet res = preparedStatement.executeQuery();
			
			if (res.next()) {
				result = res.getString("password");
			}
			
			cnn.close();
			
		}catch(SQLException | ClassNotFoundException  ex) {
			System.out.println("Something went wrong");
			ex.printStackTrace();
		}
		return result;
	}
	
	
	public String forgotPassword(String username, String answer) {
		String result =  "";
		String rightAnswer  = "";
		String password = "";
		String userAnswer = answer;
		
		try {
			cnn = DriverManager.getConnection(url);
			
			PreparedStatement preparedStatement = cnn.prepareStatement("SELECT * FROM AccountUser WHERE userName=" + "'" + username + "'");
			ResultSet res = preparedStatement.executeQuery();
			
			if (res.next()) {
				password = res.getString("password");
				rightAnswer = res.getString("securityAnswer");
				
				System.out.println(password + rightAnswer);
			}
			
			if(!userAnswer.equals(rightAnswer))  {
				result = "your answer is incorrect";
			}
			
			else if (userAnswer.equals(rightAnswer)) {
				result = "your password is " + password;
			}
			
			else {
				result = "there are no accounts with that username";
			}
			
			cnn.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
}


