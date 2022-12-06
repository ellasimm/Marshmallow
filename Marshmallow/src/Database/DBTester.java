package Database;

import java.util.Scanner;

import FlightCode.Flights;

public class DBTester {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int flightID = input.nextInt();
		String fromCity = input.nextLine();
		String toCity = input.nextLine();
		String tOffTime = input.nextLine();
		String lTime = input.nextLine();
		int numSeats = input.nextInt();
		String flightDate = input.nextLine();
		
		Flights flight = new Flights(flightID, fromCity, toCity, tOffTime,
				lTime, numSeats, flightDate);
		
		InsertDB.insertFlight(flight);
	}
}
