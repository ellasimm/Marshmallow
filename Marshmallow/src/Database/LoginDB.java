package Database;

import java.sql.Connection;
import java.sql.*;

public class LoginDB {
	
	static final String url =  "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	static Connection cnn;
	
	public String loginConnection(String username) {
		try {
			Class.forName("java.sql.Driver");	
			System.out.println("database connected");
			cnn = DriverManager.getConnection(url);
		
			PreparedStatement preparedStatement = cnn.prepareStatement("SELECT * FROM AccountUser WHERE userName=")
		}
	}

}
