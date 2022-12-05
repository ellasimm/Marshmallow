package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import FlightCode.FlightOrder;
import FlightCode.Flights;
import FlightCode.User;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class GetDB {
	private static final Logger log = null;
	
	public static User getUser(String userName, Connection connection) {
		User user = new User();
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Get data");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AccountUser WHERE userName=" + "'" + userName + "'");
			
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

			connection.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
	public static Flights getFlight(int flightId, Connection connection) {
		Flights flight = new Flights();
		
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Get data");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Flights");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Flights flights = new Flights();
				
				flight.setFlightId(resultSet.getInt("flightId"));
				
			}
			
		return flight;
	}
	public static ObservableList<Flights> allFlights(){
		ObservableList<Flights> flights = FXCollections.observableArrayList();
		//add more
		return flights;
	}
	public static ObservableList<FlightOrder> flightorders(){
		ObservableList<FlightOrder> orders = FXCollections.observableArrayList();
		//add more
		return orders;
	}
}
