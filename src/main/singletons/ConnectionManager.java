package main.singletons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager instance;
	
	private ConnectionManager(){}
	
	public static ConnectionManager getInstance() {
		if(instance == null)
			instance = new ConnectionManager();
		return instance;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM92887", "120802");
			
			return connection;
		} catch (SQLException e) {
			System.err.println("Is not possible connect to database!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Driver JDBC not found!");
			e.printStackTrace();
		}
		return connection;
	}
}
