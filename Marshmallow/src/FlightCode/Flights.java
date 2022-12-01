package FlightCode;

import java.time.LocalDate;

public class Flights implements Comparable<Flights>{
	
	private int flightId;
	private String fromCity;
	private String toCity;
	private int numSeats;
	private LocalDate flightDate;
	private int flightTime;
	private float unitCost;
	
		
	public Flights() {
	}
	public Flights(int flightId, String fromCity, String toCity, int seatNumbers,
			LocalDate flightDate, int flightTime, float unitCost) {
		this.flightId = flightId;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.numSeats = seatNumbers;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.unitCost = unitCost;
	}
	public void displayAvailableFlights() {
		
	}
	public int getFlightId() {
		return flightId;
	}
	public String getFromCity() {
		return fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public int getnumSeats() {
		return numSeats;
	}
	public LocalDate getFlightDate() {
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
	public String setFromCity() {
		return fromCity;
	}
	public String setToCity() {
		return toCity;
	}
	public int setNumSeats() {
		return numSeats;
	}
	public LocalDate setFlightDate() {
		return flightDate;
	}
	public int setFlightTime() {
		return flightTime;
	}
	public float setUnitCost() {
		return unitCost;
	}
	@Override
	public int compareTo(Flights o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
