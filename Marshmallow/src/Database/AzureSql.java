package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AzureSql {

	public static void main(String[] args) {
		System.out.println("performing setup..");
		String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		AzureSql azure = new AzureSql();
		System.out.println("Connecting..");
		String sql = "SELECT userId, userName, password FROM AccountUser; ";
		azure.SelectAzureSQL(sql, cnnString);
		sql = "INSERT INTO AccountUser(userId, userName, password, firstName, lastName, ssn, email, address, zipCode, state, securityQuestion, securityAnswer) "
				+ "VALUES (3, 'oshaikh1', 'mypassword', 'Omama', 'Shaikh', 222222222, 'oshaikh1@gmail.com', '5266 West Commons', 30312, 'GA', 'Where were you born', 'Miami' );";
		azure.InsertAzureSQL(sql, cnnString);
	}
	//search
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
	//insert
	private void InsertAzureSQL(String sql, String cnnStr) {
		System.out.println("executing SQL statement...");
		try(Connection cnn = DriverManager.getConnection(cnnStr);
				PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
			ResultSet resultSet = null;
			statement.execute();
			resultSet = statement.getGeneratedKeys();
			while(resultSet.next()) {
				System.out.println("key(s): "+ resultSet.getString(1));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
