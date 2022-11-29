package Hello;

import java.util.Date;

public class Flights {
	
	private int flightId;
	private Aircraft aircraftId;
	private String[] cities;
	private String fromCity;
	private String toCity;
	private int[] availableSeatNumbers;
	private Date flightDate;
	private int flightTime;
	private float unitCost;
	
	public Flights() {
	}
	public Flights(int flightId, Aircraft aircraftId, String fromCity, String toCity, int[] availableSeatNumbers,
			Date flightDate, int flightTime, float unitCost) {
		this.flightId = flightId;
		this.aircraftId = aircraftId;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.availableSeatNumbers = availableSeatNumbers;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.unitCost = unitCost;
	}
	public void displayAvailableFlights() {
	}
	public void displayAvailableSeatNumbers() {
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
	public int[] getAvailableSeatNumbers() {
		return availableSeatNumbers;
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
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public void setCities(String[] cities) {
		this.cities = cities;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public void setAvailableSeatNumbers(int[] availableSeatNumbers) {
		this.availableSeatNumbers = availableSeatNumbers;
	}
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}
	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}
}