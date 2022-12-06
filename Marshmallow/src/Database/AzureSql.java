package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AzureSql {

	public static void main(String[] args) {
		System.out.println("performing setup..");
		String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		AzureSql azure = new AzureSql();
		System.out.println("Connecting..");
		String sql = "SELECT accountUserId, userName, password FROM AccountUser; ";
		azure.SelectAzureSQL(sql, cnnString);
	}
	
	private void SelectAzureSQL(String sql, String cnnStr) {
		System.out.println("selecting data..");
		ResultSet resultSet = null;
		try(Connection cnn = DriverManager.getConnection(cnnStr);
				Statement statement = cnn.createStatement();){
			resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1) + ","+ resultSet.getString(2) + ","+ resultSet.getString(3) );
		}
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	}
}
