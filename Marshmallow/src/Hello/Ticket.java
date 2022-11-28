package Hello;

import java.util.Date;

public class Ticket {
	
	private FlightOrder orderNumber;
	private Flights flightId;
	private FlightOrder[] passengersFullNames;
	private FlightOrder[] bookedSeatNumbers;
	private Flights fromCity;
	private Flights toCity;
	private Flights flightDate;
	private Flights flightTime;
	private Aircraft aircraftId;
	private Aircraft aircraftMake;
	private Aircraft aircraftModel;
	private Aircraft airlineName;	
	
	public Ticket() {
	}
	public Ticket(FlightOrder orderNumber, Flights flightId, FlightOrder[] passengersFullNames, FlightOrder[] bookedSeatNumbers,
	              Flights fromCity, Flights toCity, Flights flightDate, Flights flightTime, Aircraft aircraftId, 
	              Aircraft aircraftMake, Aircraft aircraftModel, Aircraft airlineName) {
		this.orderNumber = orderNumber;
		this.flightId = flightId;
		this.passengersFullNames = passengersFullNames;
		this.bookedSeatNumbers = bookedSeatNumbers;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.aircraftId = aircraftId;
		this.aircraftMake = aircraftId;
		this.aircraftModel = aircraftModel;
		this.airlineName = airlineName;	
	}	
}
