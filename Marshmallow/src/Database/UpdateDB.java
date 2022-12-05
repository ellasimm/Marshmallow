package Database; //finished I believe

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import FlightCode.FlightOrder;
import FlightCode.Flights;

public class UpdateDB {
	public static boolean success;
	private static final Logger log = null;
	
	public static void deleteFlightOrder(FlightOrder order, Connection connection) throws SQLException {
		success = false;
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Delete data");
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FlightOrder WHERE flightOrderId = ? ; ");
			preparedStatement.setLong(1, order.getOrderNumber());
			preparedStatement.executeUpdate();
			
			connection.close();
			success = true;
		}catch(Exception e1) {
			e1.printStackTrace();
			success = false;
		}
	}
	public static void deleteFlight(Flights flight, Connection connection) throws SQLException {
		success = false;
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Delete data");
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Flights WHERE flightId = ? ; ");
			preparedStatement.setLong(1,flight.getFlightId());
			preparedStatement.executeUpdate();
			
			connection.close();
			success = true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			success = false;
		
		}
	}
	
}
