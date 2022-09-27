package dev.palhano;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost/alura_projects");
		comboPooledDataSource.setUser("alura_user");
		comboPooledDataSource.setPassword("alura");
		
		comboPooledDataSource.setMaxConnectionAge(15);
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection getConecction() throws SQLException {
		 return this.dataSource.getConnection();
	}
}
