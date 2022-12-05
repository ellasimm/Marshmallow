package FlightCode;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import Database.GetDB;
import Database.InsertDB;
import GUI.LoginPageController;
public class FlightOrder {
	
	private int orderNumber;
	private int flightID;
	private int userID;
	
	
	public FlightOrder(){
		
	}
	
	
	public FlightOrder(int orderNumber, int flightID, int userID) {
		
		this.orderNumber = orderNumber;
		this.flightID = flightID;
		this.userID = userID;
	}
	
	
	public static void orderFlight(int flightID) throws SQLException {
		
		int orderNum = generateOrderNumber();
		
		Flights booked = GetDB.getFlight(flightID);
		
		FlightOrder flightOrder = new FlightOrder(orderNum, flightID, LoginPageController.currentUser.getUserID());
		
		InsertDB.insertFlightOrder(flightOrder);
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
	

	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}

}