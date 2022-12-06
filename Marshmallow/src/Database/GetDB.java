package Database;   //finished I believe

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import FlightCode.FlightOrder;
import FlightCode.Flights;
import FlightCode.User;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class GetDB {
	private static final Logger log = null;
	
	public static User getUser(String userName) {
		User user = new User();
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Get data");
			PreparedStatement preparedStatement = cnn.prepareStatement("SELECT * FROM AccountUser WHERE userName=" + "'" + userName + "'");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				user.setUserID(resultSet.getInt("UserId"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				user.setSsn(resultSet.getInt("ssn"));
				user.setEmail(resultSet.getString("email"));
				user.setAddress(resultSet.getString("address"));
				user.setZipCode(resultSet.getInt("zipCode"));
				user.setState(resultSet.getString("state"));
				user.setSecurityQuestion(resultSet.getString("securityQuestion"));
				user.setSecurityAnswer(resultSet.getString("securityAnswer"));
			
			}

			cnn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
		/** New Method for getFlight */
	public static Flights getFlight(int flightId, String sql) {
		ResultSet resultSet = null;
		Flights flight = new Flights();
		try(Connection cnn = DriverManager.getConnection("jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				Statement statement = cnn.createStatement();){
			
			resultSet = statement.executeQuery(sql);
		
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + ","+ resultSet.getString(2) + ","+ resultSet.getString(3) );
				flight.setFlightId(resultSet.getInt("flightId"));
				flight.setFromCity(resultSet.getString("fromCity"));
				flight.setToCity(resultSet.getString("toCity"));
				flight.setTakeOffTime(resultSet.getString("takeOffTime"));
				flight.setLandingTime(resultSet.getString("landingTime"));
				flight.setNumSeats(resultSet.getInt("numSeat"));
				flight.setFlightDate(resultSet.getString("flightDate"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flight; 
	}
		
	/**    //Old Method for getFlight
	public static Flights getFlight(int flightId) {
		Flights flight = new Flights();
		
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Get data");
			PreparedStatement preparedStatement = cnn.prepareStatement("SELECT * FROM Flights WHERE flightId=" + "'" + flightId + "'");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				flight.setFlightId(resultSet.getInt("flightId"));
				flight.setFromCity(resultSet.getString("fromCity"));
				flight.setToCity(resultSet.getString("toCity"));
				flight.setTakeOffTime(resultSet.getString("takeOffTime"));
				flight.setLandingTime(resultSet.getString("landingTime"));
				flight.setNumSeats(resultSet.getInt("numSeat"));
				flight.setFlightDate(resultSet.getString("flightDate"));
	
			}
			cnn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flight;
		
	}
	*/
	
	public static ObservableList<Flights> allFlights(){
		ObservableList<Flights> flight = FXCollections.observableArrayList();
		
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Get data");
			PreparedStatement preparedStatement = cnn.prepareStatement("SELECT * FROM Flights");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Flights flights = new Flights();
				
				flights.setFlightId(resultSet.getInt("flightId"));
				flights.setFromCity(resultSet.getString("fromCity"));
				flights.setToCity(resultSet.getString("toCity"));
				flights.setTakeOffTime(resultSet.getString("takeOffTime"));
				flights.setLandingTime(resultSet.getString("landingTime"));
				flights.setNumSeats(resultSet.getInt("numSeat"));
				flights.setFlightDate(resultSet.getString("flightDate"));
				
				flight.add(flights);
			}
			cnn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			
		return flight;
	}
	public static ObservableList<FlightOrder> flightorders(int userID){
		ObservableList<FlightOrder> orders = FXCollections.observableArrayList();
		
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Get data");
			PreparedStatement preparedStatement = cnn.prepareStatement("SELECT * FROM FlightOrder WHERE userId=" + "'" + userID + "'");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				FlightOrder booking = new FlightOrder(resultSet.getInt("flightOrderId"),
											(resultSet.getInt("flightId")),
											(resultSet.getString("fromCity")),
											(resultSet.getString("toCity")),
											(resultSet.getString("flightDate")),
											(resultSet.getString("takeOffTime")),
											(resultSet.getString("landingTime")),
											(resultSet.getInt("userId")));
				orders.add(booking);							
			}
			cnn.close();
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return orders;
	}
}
