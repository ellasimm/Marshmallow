package FlightCode;

import java.util.Date;

public class Flights {
	
	private int flightId;
	private String[] cities;
	private String fromCity;
	private String toCity;
	private int[] seatNumbers;
	private Date flightDate;
	private int flightTime;
	private float unitCost;
	
		
	public Flights() {
	}
	public Flights(int flightId, String[] cities, String fromCity, String toCity, int[] seatNumbers,
			Date flightDate, int flightTime, float unitCost) {
		this.flightId = flightId;
		this.cities = cities;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.seatNumbers = seatNumbers;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.unitCost = unitCost;
	}
	public void displayAvailableFlights() {
	}
	public int getFlightId() {
		return flightId;
	}
	public String[] getCities() {
		return cities;
	}
	public String getFromCity() {
		return fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public int[] getSeatNumbers() {
		return seatNumbers;
	}
	public Date getFlightDate() {
		return flightDate;
	}
	public int getFlightTime() {
		return flightTime;
	}
	public float getUnitCost() {
		return unitCost;
	}
	
	
	public int setFlightId(int flightId) {
		return flightId;
	}
	public String[] setCities() {
		return cities;
	}
	public String setFromCity() {
		return fromCity;
	}
	public String setToCity() {
		return toCity;
	}
	public int[] setSeatNumbers() {
		return seatNumbers;
	}
	public Date setFlightDate() {
		return flightDate;
	}
	public int setFlightTime() {
		return flightTime;
	}
	public float setUnitCost() {
		return unitCost;
	}
	
}
