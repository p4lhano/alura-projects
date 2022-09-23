package dev.palhano;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDelete {
	public static void main(String[] args) {
		try {
			Connection conn = new ConnectionFactory().createConecction();
			Statement statement = conn.createStatement();

			boolean isList = statement.execute("insert into produto(name,descricao) values ('Mouse','Mouse wireless');",
					Statement.RETURN_GENERATED_KEYS);
			System.out.println("resultado de insert é uma lista: " + isList);// executa e diz se é lista
			ResultSet ids = statement.getGeneratedKeys();
			System.out.println("resultado de insert keys: " + statement.getGeneratedKeys());// executa e diz se é lista

			while (ids.next()) {
				Integer id = ids.getInt(1);
				System.out.println("Insert Produto(id=" + id + ");");
			}

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
