package Database;  //finished I believe

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

	public static ObservableList<Flights> searchFlight(String departDay, String departTime, String departCity, String arriveCity){
		ObservableList<Flights> flights = FXCollections.observableArrayList();
		ResultSet resultSet = null;
		try {
			Class.forName("java.sql.Driver");
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			
			
			PreparedStatement preparedStatement = cnn.prepareStatement("SELECT * FROM flights WHERE departure_city=" + "'" + departCity + "'" + 
					"and destination_city=" + "'" + arriveCity + "'" + "and flight_date=" + "'" + departDay + "'" 
					+ "and return_day=" + "'" + departTime + "'");
			
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Flights flight = new Flights();
				
				flight.setFlightId(resultSet.getInt("flightId"));
				flight.setFromCity(resultSet.getString("fromCity"));
				flight.setToCity(resultSet.getString("toCity"));
				flight.setTakeOffTime(resultSet.getString("takeOffTime"));
				flight.setLandingTime(resultSet.getString("landingTime"));
				flight.setNumSeats(resultSet.getInt("numSeat"));
				flight.setFlightDate(resultSet.getString("flightDate"));
				
				flights.add(flight);
			}
			cnn.close();
			}catch(Exception ex){
				System.out.println("An error occured in Database.");
			}
		return flights;
	}
}
