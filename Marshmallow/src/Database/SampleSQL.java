package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class SampleSQL {

	public static void main(String[] args) {
		System.out.println("performing setup..");
		String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		
		SampleSQL azure = new SampleSQL();
		System.out.println("connecting..");
		String sql = "Select flightId, fromCity, toCity, takeOffTime, landingTime, unitCost from Flight";
		azure.SelectAzureSQL(cnnString, sql);
	}
	
	private void SelectAzureSQL(String cnnString, String sql) {
		System.out.println("selecting data..");
		ResultSet resultSet = null;
		try(Connection cnn = DriverManager.getConnection(cnnString);
				Statement statement = cnn.createStatement();){
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1) + ", "+ resultSet.getString(2)+", "+ resultSet.getString(3)
									+ ", " + resultSet.getString(4) + ", "+ resultSet.getString(5)+", "+ resultSet.getString(6));	
			}
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}	
			}
}	