package atividade.java.Nove;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Produto throws SQLException{
	
	private int id;
	private String nome;
	private String descricao;
	private double desconto;
	private Date dataInicio;
	
	public void addProduto() throws SQLException, ParseException{
		
		Conexao connection = new Conexao();
		Connection con = Conexao.conexao();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o código identificador do produto: ");
		scan.nextInt(id);
		System.out.println("Digite o nome do produto:" );
		scan.next(nome);
		System.out.println("Digite a descricao do produto:");
		scan.next(descricao);
		System.out.println("Digite o desconto do produto");
		scan.nextDouble();
		System.out.println("Digite a data do produto (dia/mês/ano):");
		String dataDigitada = scan.next();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicio = (Date) formatter.parse(dataDigitada);
		
		PreparedStatement stmi = con.prepareStatement("INSERT INTO PRODUTO (ID, NOME, DESCRICAO, DESCONTO, DATA_INICIO) VALUES (?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
		stmi.setInt(1, id);
		stmi.setString(2, nome);
		stmi.setString(3, descricao);
		stmi.setDouble(4, desconto);
		stmi.setDate(5, dataInicio);
		
		scan.close();
		
		addProdutosExtra(stmi);
		
		ResultSet rost = stmi.getGeneratedKeys();
		while (rost.next()) {
			Integer id = rost.getInt(1);
			String nom = rost.getString(2);
			String des = rost.getString(3);
			Double descon = rost.getDouble(4);
			Date data = rost.getDate(4);

			System.out.println("id: " + id + "\nNome:" + nom + "\nDescrição:" + des + "\nDesconto R$: " + descon+ "\nData: " + data);
			System.out.println("-----------------------------------------");
		}	
	
		con.close();
		}

	public void addProdutosExtra(PreparedStatement stmi) throws SQLException {
		Conexao connection = new Conexao();
		Connection con = Conexao.conexao();
		
		stmi = con.prepareStatement(
				"INSERT INTO PRODUTO (ID, NOME, DESCRICAO, DESCONTO, DATA_INICIO) VALUES (?,?,?,?,?)",
				java.sql.Statement.RETURN_GENERATED_KEYS);
		id = id + 1;
		String nomeAux = nome + " Premium";
		stmi.setInt(1, id);
		stmi.setString(2, nomeAux);
		stmi.setString(3, descricao);
		stmi.setDouble(4, desconto);
		stmi.setDate(5, dataInicio);

		stmi = con.prepareStatement(
				"INSERT INTO PRODUTO (ID, NOME, DESCRICAO, DESCONTO, DATA_INICIO) VALUES (?,?,?,?,?)",
				java.sql.Statement.RETURN_GENERATED_KEYS);
		id = id + 1;
		nomeAux = nome + " Gamer";
		stmi.setInt(1, id);
		stmi.setString(2, nomeAux);
		stmi.setString(3, descricao);
		stmi.setDouble(4, desconto);
		stmi.setDate(5, dataInicio);

		stmi = con.prepareStatement(
				"INSERT INTO PRODUTO (ID, NOME, DESCRICAO, DESCONTO, DATA_INICIO) VALUES (?,?,?,?,?)",
				java.sql.Statement.RETURN_GENERATED_KEYS);
		id = id + 1;
		nomeAux = nome + " Importado";
		stmi.setInt(1, id);
		stmi.setString(2, nomeAux);
		stmi.setString(3, descricao);
		stmi.setDouble(4, desconto);
		stmi.setDate(5, dataInicio);
		
		con.close();

	}

	private void atualizaProduto() throws SQLException {
		Conexao connection = new Conexao();
		Connection con = Conexao.conexao();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o ID do produto que você deseja atualizar");
		scan.nextInt(id);
		
		boolean verificaId; 
		
		PreparedStatement stmi = con.prepareStatement("Select * from produto where id = ?");
		stmi.setInt(1, id);
		ResultSet rs = stmi.executeQuery();
		
		System.out.println("Nome");
		scan.next(nome);
		System.out.println("Descrição");
		scan.next(descricao);
		System.out.println("Desconto");
		scan.nextDouble(desconto);
		System.out.println("Data formato (dia/mês/ano)");
			String dataDigitada = scan.next();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date dataInicio = (Date) formatter.parse(dataDigitada);
		if(rs.next()) {
			stmi = con.prepareStatement("UPDATE PRODUTOS SET ID=?, NOME=?, DESCRICAO=?, DESCONTO=?, DATA_INICIO=? WHERE ID = ?");
			stmi.setInt(1, id);
			stmi.setString(2, nome);
			stmi.setString(3, descricao);
			stmi.setDouble(4, desconto);
			stmi.setDate(5, dataInicio);
			stmi.setInt(6, id);
		}
		else {
			stmi = con.prepareStatement("INSERT INTO PRODUTO (ID, NOME, DESCRICAO, DESCONTO, DATA_INICIO) VALUES (?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
			stmi.setInt(1, id);
			stmi.setString(2, nome);
			stmi.setString(3, descricao);
			stmi.setDouble(4, desconto);
			stmi.setDate(5, dataInicio);
		}
			
		scan.close();
		con.close();
	}	
}