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

	public static ObservableList<Flights> searchFlight(Flights flight){
		ObservableList<Flights> flights = FXCollections.observableArrayList();
		ResultSet resultSet = null;
		try {
			Class.forName("java.sql.Driver");
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			
			
			PreparedStatement preparedStatement = cnn.prepareStatement("SELECT * FROM Flights WHERE fromCity=" + "'" + flight.getFromCity() + "'" + 
			"and toCity=" + "'" + flight.getToCity() + "'" + "and flightDate=" + "'" + flight.getFlightDate() + "'");
			
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Flights flight1 = new Flights();
				
				flight1.setFlightId(resultSet.getInt("flightId"));
				flight1.setFromCity(resultSet.getString("fromCity"));
				flight1.setToCity(resultSet.getString("toCity"));
				flight1.setTakeOffTime(resultSet.getString("takeOffTime"));
				flight1.setLandingTime(resultSet.getString("landingTime"));
				flight1.setNumSeats(resultSet.getInt("numSeat"));
				flight1.setFlightDate(resultSet.getString("flightDate"));
				
				flights.add(flight);
			}
			cnn.close();
			}catch(Exception ex){
				System.out.println("An error occured in Database.");
			}
		return flights;
	}
}
