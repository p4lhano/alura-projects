package dev.palhano;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialTestes {

	public static void main(String[] args) throws SQLException {
		
//		sudo -u postgres psql
//		create database alura_projects;
//		create user alura_user with encrypted password 'alura';
//		grant all privileges on database alura to alura_user;
		try(Connection conn = new ConnectionFactory().getConecction()){
		
		PreparedStatement statement = conn.prepareStatement("select * from produto;");
//		boolean isList = statement.execute("select * from produto;");
		boolean isList = statement.execute();

		System.out.println("resultado de select é uma lista: " + isList );
		
//		ResultSet resultSet1 = statement.executeQuery("select * from produto;");
		ResultSet resultSet = statement.getResultSet();
		
		while (resultSet.next()) {
			Integer id = resultSet.getInt("id");
//			Integer id = resultSet.getInt(1);
			String nome = resultSet.getString("name");
//			String nome = resultSet.getString(2);
			String descricao = resultSet.getString("descricao");
			System.out.println("Produto(id="+id+","+System.lineSeparator()+
								"\tNome="+nome+","+System.lineSeparator()+
								"\tdescricao="+descricao+");");
		}
	}			
			
		
		
	}

}
