package FlightCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Database.GetDB;
import Database.InsertDB;
import GUI.LoginPageController;

public class FlightOrder {
	
	private int orderNumber;
	private int flightID;
	private String fromCity;
	private String toCity;
	private String flightDate;
	private String takeOffTime;
	private String landingTime;
	private int userID;
	
	
	public FlightOrder(){
		
	}
	
	
	public FlightOrder(int orderNumber, int flightID, String fromCity, String toCity,
							String flightDate, String takeOffTime, String landingTime, int userID) {
		
		this.orderNumber = orderNumber;
		this.flightID = flightID;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.flightDate = flightDate;
		this.takeOffTime = takeOffTime;
		this.landingTime = landingTime;
		this.userID = userID;
	}
	
	
	public FlightOrder(int orderNumber, int flightID, String fromCity, String toCity, 
						String flightDate, String takeOffTime, String landingTime) {
		
		this.orderNumber = orderNumber;
		this.flightID = flightID;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.flightDate = flightDate;
		this.takeOffTime = takeOffTime;
		this.landingTime = landingTime;
	}
	
	
	public static void orderFlight(int flightID) throws SQLException {
		
		int orderNum = generateOrderNumber();
		String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		Connection connection = DriverManager.getConnection(cnnString);
		Flights booked = GetDB.getFlight(flightID);
		
		FlightOrder flightOrder = new FlightOrder(orderNum, flightID, booked.getFromCity(), booked.getToCity(),
													booked.getFlightDate(), booked.getTakeOffTime(), booked.getLandingTime(),
													LoginPageController.currentUser.getUserID());
		
		InsertDB.insertFlightOrder(booked);
	}

	
	public static int generateOrderNumber() {
		
		int num = (int)(Math.random() * 1000);
		return num;
	}


	public int getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}


	public int getFlightID() {
		return flightID;
	}


	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}


	public String getFromCity() {
		return fromCity;
	}


	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}


	public String getToCity() {
		return toCity;
	}


	public void setToCity(String toCity) {
		this.toCity = toCity;
	}


	public String getFlightDate() {
		return flightDate;
	}


	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}


	public String getTakeOffTime() {
		return takeOffTime;
	}


	public void setTakeOffTime(String takeOffTime) {
		this.takeOffTime = takeOffTime;
	}


	public String getLandingTime() {
		return landingTime;
	}


	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}

}