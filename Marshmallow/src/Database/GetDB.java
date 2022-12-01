package Database;

import FlightCode.FlightOrder;
import FlightCode.Flights;
import FlightCode.User;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class GetDB {
	
	public static User getUser(String userName) {
		User user = new User();
		//add more
		return user;
	}
	public static Flights getFlight(int flightId) {
		Flights flight = new Flights();
		//add more
		return flight;
	}
	public static ObservableList<Flights> allFlights(){
		ObservableList<Flights> flights = FXCollections.observableArrayList();
		//add more
		return flights;
	}
	public static ObservableList<FlightOrder> flightorders(){
		ObservableList<FlightOrder> orders = FXCollections.observableArrayList();
		//add more
		return orders;
	}
}
