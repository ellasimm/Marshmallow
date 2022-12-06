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
	
	public static void deleteFlightOrder(FlightOrder orderId, String sql)  {
		success = false;
		
		/**
		String sql = "DELETE * FROM FlightOrder WHERE flightOrderId=" + "'" + orderId + "'" ;
		try(Connection cnn = DriverManager.getConnection("jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				PreparedStatement preparedStatement = cnn.prepareStatement(sql);){
			preparedStatement.setLong(1, orderId.getOrderNumber());
			preparedStatement.executeUpdate();
			success = true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			success = false;
		}
		/**********************************/
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Delete data");
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setLong(1, orderId.getOrderNumber());
			preparedStatement.executeUpdate();
			
			cnn.close();
			success = true;
		}catch(Exception e1) {
			e1.printStackTrace();
			success = false;
		}
	}
	public static void deleteFlight(Flights flightid, String sql)  {
		success = false;
		//String sql = "DELETE FROM Flights WHERE flightId =" + "'"+flightid+"'"; 
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Delete data");
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setLong(1,flightid.getFlightId());
			preparedStatement.executeUpdate();
			
			cnn.close();
			success = true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			success = false;
		
		}
	}
	
}
