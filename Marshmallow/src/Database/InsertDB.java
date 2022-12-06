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

	
	public static void insertFlight(Flights flight, String sql){
		success = false;
		//String sql = "INSERT INTO Flights (flightID, fromCity, toCity, takeOffTime, landingTime, numSeat, flightDate ) "
		//		+ "VALUES (num, fromCity, toCity, landingTime,  takeOffTime, numSeats, flightDate);";
		try(Connection cnn = DriverManager.getConnection(cnnStr);
				PreparedStatement preparedStatement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
			ResultSet resultSet = null;
			preparedStatement.execute();
			resultSet = preparedStatement.getGeneratedKeys();
			while(resultSet.next()) {
				System.out.println("key(s): "+ resultSet.getString(1));
				preparedStatement.setInt(1,flight.getFlightId());
				preparedStatement.setString(2, flight.getFromCity());
				preparedStatement.setString(3, flight.getToCity());
				preparedStatement.setString(4, flight.getTakeOffTime());
				preparedStatement.setString(5, flight.getLandingTime());
				preparedStatement.setInt(6, flight.getNumSeats());
				preparedStatement.setString(7, flight.getFlightDate());
				preparedStatement.executeUpdate();
				
				success = true;
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
			success = false;
		}
		
	}
	
	public static void insertFlightOrder(FlightOrder order) {
		success = false;
		String sql = "INSERT INTO FlightOrder(flightOrderId, flightId, fromCity, toCity, flightDate, takeOffTime, landingTime, userId) "
				+ "VALUES('" +order.getOrderNumber()+"' , '" + order.getFlightID() +"', '"+ order.getFromCity()+"', '"+order.getToCity()+"', "
				+ "													'"+order.getFlightDate()+"', '"+order.getTakeOffTime()+"', '"+order.getLandingTime()+"', "
				+ "													'"+LoginPageController.currentUser.getUserID()+"');";
	
		try(Connection cnn = DriverManager.getConnection(cnnStr);
				PreparedStatement preparedStatement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
			ResultSet resultSet = null;
			preparedStatement.execute();
			resultSet = preparedStatement.getGeneratedKeys();
			while(resultSet.next()) {
				System.out.println("key(s): "+ resultSet.getString(1)+ ","+ resultSet.getString(2)+ ","+ resultSet.getString(3)+ ","+
											resultSet.getString(4)+ ","+resultSet.getString(5)+ ","+ resultSet.getString(6)+ ","+ resultSet.getString(7));
				preparedStatement.setInt(1, order.getOrderNumber());
				preparedStatement.setInt(2, order.getFlightID());
				preparedStatement.setString(3, order.getFromCity());
				preparedStatement.setString(4, order.getToCity());
				preparedStatement.setString(5, order.getFlightDate());
				preparedStatement.setString(6, order.getTakeOffTime());
				preparedStatement.setString(7, order.getLandingTime());
				preparedStatement.setInt(8, order.getUserID());
				preparedStatement.executeUpdate();
				
				
				success = true;
			}
		}catch(SQLIntegrityConstraintViolationException ex1) {
			
			ErrorMessage.showErrorMessage("Duplicate Booking Alert!");
			
			ex1.printStackTrace();
			success = false;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			success = false;
		}
		
	}
	
	public static void insertAccount(User user){
		
		success = false;
		try {
			Class.forName("java.sql.Driver");
			System.out.println("Database is connecting");
			
			Connection cnn =  DriverManager.getConnection(cnnStr);
			
			String sqlQuery = "INSERT INTO AccountUser(UseriD,userName,password,firstName,lastName,ssn,"
					+ "email, address, zipCode,securityQuestion,securityAnswer,isAdmin)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
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
