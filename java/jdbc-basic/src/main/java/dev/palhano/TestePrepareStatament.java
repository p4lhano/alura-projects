package dev.palhano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestePrepareStatament {
	public static void main(String[] args) {
		try {	
			Connection conn = new ConnectionFactory().getConecction();
			PreparedStatement prepareStatement = conn.prepareStatement(
					"insert into produto(name,descricao) values ( ?, ?);",
					Statement.RETURN_GENERATED_KEYS);
			
			String nome="Mouse";
			String descricao="Mouse wireless";
			prepareStatement.setString(1, nome);
			prepareStatement.setString(2, descricao);
			
			prepareStatement.execute();
			
			ResultSet resultSet = prepareStatement.getGeneratedKeys();
			System.out.println();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				System.out.println("Insert Produto(id=" + id + ");");
			}
//			boolean isList = statement.execute("insert into produto(name,descricao) values ('Mouse','Mouse wireless');",
//					Statement.RETURN_GENERATED_KEYS);
			

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}
}
