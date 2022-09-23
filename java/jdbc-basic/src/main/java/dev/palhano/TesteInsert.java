package dev.palhano;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsert {
	public static void main(String[] args) {
		try {
			Connection conn = new ConnectionFactory().createConecction();
			Statement statement = conn.createStatement();
			
			boolean isList = statement.execute("delete from produto where name='Mouse';");
			System.out.println("resultado de insert é uma lista: " + isList);
			
			int lineAftect = statement.getUpdateCount();
			System.out.println("linhas afetadas Produto(total=" + lineAftect + ");");
			

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
