package Database;  //	FINISHED!!!!!!

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Logger;

import FlightCode.FlightOrder;
import FlightCode.Flights;
import FlightCode.User;
import GUI.ErrorMessage;
import GUI.LoginPageController;


public class InsertDB {
	public static boolean success;
	private static final Logger log = null;
	static final String cnnStr = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

	
	public static void insertFlight(Flights flight){
		
		success = false;
		
		try {
			
		Class.forName("java.sql.Driver");
		
		System.out.println("Connected");
		
		Connection cnn = DriverManager.getConnection(cnnStr);
		
		String sql = "INSERT INTO Flights (flightId, fromCity, toCity, takeOffTime, landingTime, numSeat, flightDate) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement preparedStatement = cnn.prepareStatement(sql);
		
		preparedStatement.setInt(1,flight.getFlightId());
		preparedStatement.setString(2, flight.getFromCity());
		preparedStatement.setString(3, flight.getToCity());
		preparedStatement.setString(4, flight.getTakeOffTime());
		preparedStatement.setString(5, flight.getLandingTime());
		preparedStatement.setInt(6, flight.getNumSeat());
		preparedStatement.setString(7, flight.getFlightDate());
		preparedStatement.executeUpdate();
		
		cnn.close();
		success = true;
		
		}catch(Exception ex) {
			System.out.println("database error");
			ex.printStackTrace();
			success = false;
		}
		
	}
	
	public static void insertFlightOrder(FlightOrder order) throws ClassNotFoundException {
		
		try {
			Class.forName("java.sql.Driver");
			System.out.println("Database is connecting");
		
			Connection cnn =  DriverManager.getConnection(cnnStr);
			Statement stat = cnn.createStatement();
			String sql2 ="SELECT DISTINCT flightId FROM FlightOrder WHERE userId ="+"'"+order.getUserID()+"'" + "and flightId="+ "'"+order.getFlightID() + "'";
			
			ResultSet resultSet = stat.executeQuery(sql2);
			
			if(resultSet.next() == true) {
				ErrorMessage.showErrorMessage("Duplicate Booking Alert!");
			}
			else if (resultSet.next() == false){
				String sqlQuery = "INSERT INTO FlightOrder(flightOrderId, flightId, fromCity, toCity, flightDate, takeOffTime, landingTime, userId) "
						+ "VALUES(?,?,?,?,?,?,?,?)";
				
				String sql ="UPDATE Flights SET numSeat = numSeat -1 WHERE flightId=" + "'" + order.getFlightID() + "'";
				
				stat.executeUpdate(sql);
				
				PreparedStatement preparedStatement = cnn.prepareStatement(sqlQuery);
				
				preparedStatement.setInt(1, order.getOrderNumber());
				preparedStatement.setInt(2, order.getFlightID());
				preparedStatement.setString(3, order.getFromCity());
				preparedStatement.setString(4, order.getToCity());
				preparedStatement.setString(5, order.getFlightDate());
				preparedStatement.setString(6, order.getTakeOffTime());
				preparedStatement.setString(7, order.getLandingTime());
				preparedStatement.setInt(8, order.getUserID());
				preparedStatement.executeUpdate();
				
				ErrorMessage.showErrorMessage("You're booked for flight number " + order.getFlightID());
			}
			cnn.close();
			
		}catch(SQLException ex) {
			ex.printStackTrace();

		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void insertAccount(User user){
		
		success = false;
		try {
			Class.forName("java.sql.Driver");
			System.out.println("Database is connecting");
			
			Connection cnn =  DriverManager.getConnection(cnnStr);
			
			String sqlQuery = "INSERT INTO AccountUser(UseriD,userName,password,firstName,lastName,ssn,"
					+ "email, address, zipCode, state, securityQuestion,securityAnswer,isAdmin)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = cnn.prepareStatement(sqlQuery);

				preparedStatement.setInt(1, user.getUserID());
				preparedStatement.setString(2, user.getUserName());
				preparedStatement.setString(3, user.getPassword());
				preparedStatement.setString(4, user.getFirstName());
				preparedStatement.setString(5, user.getLastName());
				preparedStatement.setInt(6, user.getSsn());
				preparedStatement.setString(7, user.getEmail());
				preparedStatement.setString(8, user.getAddress());
				preparedStatement.setInt(9, user.getZipCode());
				preparedStatement.setString(10, user.getState());
				preparedStatement.setString(11, user.getSecurityQuestion());
				preparedStatement.setString(12, user.getSecurityAnswer());
				preparedStatement.setInt(13, -1);
				preparedStatement.executeUpdate();
				
				cnn.close();
				success = true;
				
		}catch(SQLIntegrityConstraintViolationException ex1) {
				
				ErrorMessage.showErrorMessage("Duplicate Account!" + "\nTry again or click forgot password");
				success = false;
				
		}catch(SQLException ex2) {
				ex2.printStackTrace();
				success = false;
				
		}catch(ClassNotFoundException ex3) {
			ex3.printStackTrace();
			System.out.println("Something went wrong in the database");
			success = false;
		}
	
	}
}
