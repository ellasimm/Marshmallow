package FlightCode;

import java.util.ArrayList;
import Database.InsertDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Flights implements Comparable<Flights>{

	private int flightId;
	private String fromCity;
	private String toCity;
	private int numSeats;
	private String flightDate;
	private String landingTime;
	private String takeOffTime;
	private ArrayList<User> passengers = new ArrayList<>();
	private String returnFlight;


	public Flights() {
	}

	public Flights(int flightId, String fromCity, String toCity, String takeOffTime, String landingTime,  int numSeats,
			String flightDate) {

		this.flightId = flightId;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.numSeats = numSeats;
		this.flightDate = flightDate;
		this.landingTime = landingTime;
		this.takeOffTime = takeOffTime;
	}
	

	public static void createFlight(String fromCity, String toCity, int numSeats, String flightDate, 
										String landingTime,  String takeOffTime){

		int num = createFlightNum();  //should this be inside try?

		try {

			Flights flight = new Flights(num, fromCity, toCity, landingTime,  takeOffTime, numSeats, flightDate);
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			Connection connection = DriverManager.getConnection(cnnString);
			InsertDB.insertFlight(flight);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
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


	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
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

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
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
		if (flightId ==  o.flightId) {
			return 0;
		}
		else {
			return -1;
		}
	}

}
