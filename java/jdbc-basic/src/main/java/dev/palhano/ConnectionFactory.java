package dev.palhano;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection createConecction() throws SQLException {
		 return DriverManager.getConnection("jdbc:postgresql://localhost/alura_projects",
				"alura_user", "alura");		
	}
}
