package FlightCode;

import java.util.ArrayList;
import Database.InsertDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Flights implements Comparable<Flights>{

	private Integer flightId;
	private String fromCity;
	private String toCity;
	private Integer numSeat;
	private String flightDate;
	private String landingTime;
	private String takeOffTime;
	private ArrayList<User> passengers = new ArrayList<>();


	public Flights() {
	}

	public Flights(Integer flightId, String fromCity, String toCity, String takeOffTime, String landingTime,  Integer numSeat,
			String flightDate) {

		this.flightId = flightId;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.numSeat = numSeat;
		this.flightDate = flightDate;
		this.landingTime = landingTime;
		this.takeOffTime = takeOffTime;
	}
	

	public static void createFlight(String fromCity, String toCity, Integer numSeat, String flightDate, 
										String landingTime,  String takeOffTime){

		int num = createFlightNum();  

		try {

			Flights flight = new Flights(num, fromCity, toCity, landingTime,  takeOffTime, numSeat, flightDate);
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			Connection connection = DriverManager.getConnection(cnnString);
		
			InsertDB.insertFlight(flight);
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public  String getPass(ArrayList<User> passengers) {
		String pass = "";
		for (int i = 0; i < passengers.size(); i++) {

			User user = passengers.get(i);
			pass  += user;
		}		
		return pass;	
	}


	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
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

	public Integer getNumSeats() {
		return numSeat;
	}

	public void setNumSeats(Integer numSeats) {
		this.numSeat = numSeats;
	}

	public String getFlightDate() {
		return flightDate;
	}
	
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getLandingTime() {
		return landingTime;
	}	

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}
	
	public String getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(String takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public static int createFlightNum() {

		int num = (int)(Math.random() * 99999);
		return num;
	}


	@Override
	public String toString() {
		return "Flight ID: " + this.getFlightId() + "/nDeparture Time: " + this.getTakeOffTime() 
					+ "/nDeparture City: " + this.getFromCity() + "/nArrival Time: " + this.getLandingTime()
					+ "/nArrival City: " + this.getToCity();
	}


	@Override
	public int compareTo(Flights o) {
		if (flightId ==  o.flightId) 
			return 0;
		else 
			return -1;
			
	}

}
