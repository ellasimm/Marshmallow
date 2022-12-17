package Database;   // FINISHED with GetDB

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
	
	// get the user's information from the DB
	public static User getUser(String userName) {
		User user = new User();
		ResultSet resultSet = null;
		String sql = "SELECT * FROM AccountUser WHERE userName=" + "'" + userName + "'" ;
		try(Connection cnn = DriverManager.getConnection("jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				Statement statement = cnn.createStatement();){
			
			resultSet = statement.executeQuery(sql);
		
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+ ","+ resultSet.getString(2)+ ","+ resultSet.getString(3)+ ","+
						resultSet.getString(4)+ ","+resultSet.getString(5)+ ","+ resultSet.getString(6)+ ","+ resultSet.getString(7)+","+
						resultSet.getString(8)+ ","+resultSet.getString(9)+ ","+resultSet.getString(10)+ ","+ resultSet.getString(11)+ ","+ resultSet.getString(12));
				
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
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return user; 
	
	}
	
	// get the flight information with the flightId.
	public static Flights getFlight(int flightId) {
		ResultSet resultSet = null;
		Flights flight = new Flights();
		String sql = "SELECT * FROM Flights WHERE flightId=" + "'" + flightId + "'" ;
		try(Connection cnn = DriverManager.getConnection("jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				Statement statement = cnn.createStatement();){
			
			resultSet = statement.executeQuery(sql);
		
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + ","+ resultSet.getString(2) + ","+ resultSet.getString(3) + ","+
						resultSet.getString(4)+ ","+resultSet.getString(5)+ ","+ resultSet.getString(6)+ ","+ resultSet.getString(7));
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
		
	
	// get the list of flights
	public static ObservableList<Flights> allFlights(){
		ObservableList<Flights> flight = FXCollections.observableArrayList();
		ResultSet resultSet = null;
		String sql = "SELECT * FROM Flights;";
		try(Connection cnn = DriverManager.getConnection("jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				Statement statement = cnn.createStatement();){
			
			resultSet = statement.executeQuery(sql);
		
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + ","+ resultSet.getString(2) + ","+ resultSet.getString(3) + ","+
						resultSet.getString(4)+ ","+resultSet.getString(5)+ ","+ resultSet.getString(6)+ ","+ resultSet.getString(7));
				
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
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flight; 
	}
	
	// get the list of booked flights for user
	public static ObservableList<FlightOrder> flightorders(int userID){
		String url = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		ObservableList<FlightOrder> orders = FXCollections.observableArrayList();
		
		try {
			Class.forName("java.sql.Driver");
			Connection cnn = DriverManager.getConnection(url);
			
			PreparedStatement ps = cnn.prepareStatement("SELECT * FROM FlightOrder WHERE userId=" + "'" + userID + "'");
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				FlightOrder booking = new FlightOrder(res.getInt("flightOrderId"),
						(res.getInt("flightId")),
						(res.getString("fromCity")),
						(res.getString("toCity")),
						(res.getString("flightDate")),
						(res.getString("takeOffTime")),
						(res.getString("landingTime")),
						(res.getInt("userId")));
				
				orders.add(booking);
			}
			
			cnn.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return orders;
	}
	//need to check all three methods
	// get the user's id with the userName
	public static int getUserId(String userName) {
		int id = 0;
		ResultSet resultSet = null;
		String sql = "SELECT userId FROM AccountUser WHERE userName=" + "'" + userName + "'" ;
		try(Connection cnn = DriverManager.getConnection("jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				Statement statement = cnn.createStatement();){
			
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("userId"));
				
				id = resultSet.getInt("userId");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return id;
	}
	// get the number for userName which indicates if the user is Admin or not
	public static int getIsAdmin(String userName) {
		int num = 0;
		ResultSet resultSet = null;
		String sql = "SELECT isAdmin FROM AccountUser WHERE userName=" + "'" + userName + "'" ;
		try(Connection cnn = DriverManager.getConnection("jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				Statement statement = cnn.createStatement();){
			
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("isAdmin"));
				
				num = resultSet.getInt("isAdmin");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return num;
	}
	
	// get the security question for the user
	public static String getSQ(String userName) {
		String sq = "";
		ResultSet resultSet = null;
		String sql = "SELECT securityQuestion FROM AccountUser WHERE userName=" + "'" + userName + "'" ;
		try(Connection cnn = DriverManager.getConnection("jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				Statement statement = cnn.createStatement();){
			
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println(resultSet.getString("securityQuestion"));
				
				sq = resultSet.getString("securityQuestion");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return sq;
	}
}
