package dev.palhano;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dev.palhano.modelo.Produto;

public class TestesDAO {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Tablet", "Tablet de chocolate");

		try (Connection conn = new ConnectionFactory().getConecction()) {
			String insertPrepare = "INSERT INTO produto (nome,descricao) values (?,?);";

			try (PreparedStatement prepareStatement = conn.prepareStatement(insertPrepare,
					PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				
				prepareStatement.execute();
			}
		}

	}

}
