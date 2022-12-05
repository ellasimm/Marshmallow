package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;
import FlightCode.Flights;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearchDB {
	private static final Logger log = null;

	public static ObservableList<Flights> searchFlight(Flights flight, Connection connection){
		ObservableList<Flights> flights = FXCollections.observableArrayList();
		ResultSet resultSet = null;
		try {
			String cnnString = "jdbc:sqlserver://cisproject2022.database.windows.net:1433;database=FlightReservationProject;user=RezaKian@cisproject2022;password=Saglover2?;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Search data");
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Flight, FlightDate WHERE Flight.fromCity=" + "'" + flight.getFromCity() + "'" + 
			"and Flight.toCity=" + "'" + flight.getToCity() + "'" + "and FlightDate.flight_date=" + "'" + flight.getFlightDate() + "'");
			
			// I don't understand how flightDate works. 
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Flights flight1 = new Flights();
				
				flight1.setFlightId(resultSet.getInt("flightId"));
				flight1.setFromCity(resultSet.getString("fromCity"));
				flight1.setToCity(resultSet.getString("toCity"));
				
				flight1.setFlightDate(resultSet.getString(""/* what column should I place inside the quotes.*/));
				
				flights.add(flight);
			}
			connection.close();
			}catch(Exception ex){
				System.out.println("An error occured in Database.");
			}
		return flights;
	}
}
