package atividade.java.Nove;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection conexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/x_gamer?useTimezone=true&serverTimezone=UTC", "root", "phnd0905");
		
	}
	public static void main(String[] args) throws SQLException {
		conexao();
		System.out.println("conexao realizada");
	}
}
