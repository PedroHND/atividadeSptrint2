package atividade.java.Nove;

import java.io.InputStream;
import java.util.Scanner;

public class Menu {
	

	public void menuIniciar() {
		int num;
		Produto pro = new Produto();
		Scanner scan = Scanner(System.in);
		
		do{
		System.out.println("====================== Xpto System ======================");
		System.out.println("Digite a opção desejada");
		System.out.println("1 - para INSERIR uma nova oferta");
		System.out.println("2 - para ATUALIZAR uma oferta");
		System.out.println("3 - para DELETAR uma oferta");
		System.out.println("4 - para listar as palavras que contem ? ");
		System.out.println("0 - para SAIR ");
		System.out.println("=========================================================");
		scan.nextInt(num);
		if(num<0 || num>4) {
			try {
				throw new InvalidOptionException("Opção inválida, tente uma opção válida");
			} catch (InvalidOptionException e) {
				System.err.println("Digite novamente a opção desejada");
			}
		}
		
		if (num ==1) {
			pro.addProduto();
		}
		else if(num == 2) {
			pro.atualizaProduto();
		}
		else if(num == 3) {
			pro.delProduto();;
		}
		else if(num == 4) {
			pro.pesquisaProduto();
		}
		}while(num!=0); 
	}


}
