package Database; //finished I believe

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import FlightCode.FlightOrder;
import FlightCode.Flights;

public class UpdateDB {
	public static boolean success;
	private static final Logger log = null;
	public static String url = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	
	
	public static void deleteFlightOrder(int flightId)  {

		success = false;
		try {

			Class.forName("java.sql.Driver");

			Connection connection = DriverManager.getConnection(url);

			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM FlightOrder WHERE flightId=" + "'" + flightId + "'");

			preparedStatement.executeUpdate();
			
			
			
			connection.close();
			success = true;
		} catch (Exception e1) {
			e1.printStackTrace();
			success = false;

		}
		
	}
	
	public static void deleteFlight(Integer flightId)  {
		success = false;
		try {
			Class.forName("java.sql.Driver");
			
			Connection cnn = DriverManager.getConnection(url);
			
			PreparedStatement ps = cnn.prepareStatement("DELETE FROM Flights " + "WHERE flightId=" + "'" + flightId + "'");
			
			ps.executeUpdate();
			
			cnn.close();
			success = true;
		}catch(Exception e1) {
			e1.printStackTrace();
			success = false;
		}
	}
}
