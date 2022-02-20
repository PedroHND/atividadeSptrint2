package atividade.java.Nove;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Produto {

	private int id;
	private String nome;
	private String descricao;
	private double desconto;
	private Date dataInicio;	
	
	Conexao connection = new Conexao();
	Connection con = connection.conexao();
	
	public void addProduto() throws SQLException, ParseException{
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
	}

	private void addProdutosExtra(PreparedStatement stmi) throws SQLException {
		stmi = con.prepareStatement("INSERT INTO PRODUTO (ID, NOME, DESCRICAO, DESCONTO, DATA_INICIO) VALUES (?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
		id = id+1;
		String nomeAux = nome+" Premium";
		stmi.setInt(1, id);
		stmi.setString(2, nomeAux);
		stmi.setString(3, descricao);
		stmi.setDouble(4, desconto);
		stmi.setDate(5, dataInicio);
		
		stmi = con.prepareStatement("INSERT INTO PRODUTO (ID, NOME, DESCRICAO, DESCONTO, DATA_INICIO) VALUES (?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
		id = id+1;
		nomeAux = nome+" Gamer";
		stmi.setInt(1, id);
		stmi.setString(2, nomeAux);
		stmi.setString(3, descricao);
		stmi.setDouble(4, desconto);
		stmi.setDate(5, dataInicio);
		
		stmi = con.prepareStatement("INSERT INTO PRODUTO (ID, NOME, DESCRICAO, DESCONTO, DATA_INICIO) VALUES (?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
		id = id+1;
		nomeAux = nome + " Importado";
		stmi.setInt(1, id);
		stmi.setString(2, nomeAux);
		stmi.setString(3, descricao);
		stmi.setDouble(4, desconto);
		stmi.setDate(5, dataInicio);
		
	}
	
	
	
}
