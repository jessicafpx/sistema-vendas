package venda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void imprimir(List<ItemVenda> l, Map<String, Double> m) {
		int quant;
		String nome;
		double valor, valorItem, soma = 0;

		System.out.println("\nVenda:");
		System.out.println("+------------------+------+------------+------------+");
		System.out.println("|        Item      | Qtde | Valor Item | Total Item |");
		System.out.println("+------------------+------+------------+------------+");

		for (int i = 0; i < l.size(); i++) {
			quant = l.get(i).getQuant();
			nome = l.get(i).getNome();
			valor = m.get(nome);
			valorItem = quant*valor;
			soma += valorItem;

			System.out.printf("| %-16s | %4s | R$ %7.2f | %10.2f |", nome,  quant, valor, valorItem);
			System.out.println("\n+------------------+------+------------+------------+");
		}

		System.out.printf("| %36s | %10.2f |", "TOTAL", soma);
		System.out.println("\n+--------------------------------------+------------+");
	}

	
	public static void listaProdutos() {
		
		System.out.println("Lista de produtos disponíveis:");
		System.out.println("+------------------+------------+");
		System.out.println("|     Produto      | Valor Item |");
		System.out.println("+------------------+------------+");
		System.out.println("|      ARROZ       |  R$ 12.49  |");
		System.out.println("+------------------+------------+");
		System.out.println("|      FEIJÃO      |  R$ 10.50  |");
		System.out.println("+------------------+------------+");
		System.out.println("|     FARINHA      |  R$ 4.75   |");
		System.out.println("+------------------+------------+");
		System.out.println("|       OVO        |  R$ 0.99   |");
		System.out.println("+------------------+------------+");
		System.out.println("|     MACARRÃO     |  R$ 3.00   |");
		System.out.println("+------------------+------------+");
	}
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, Double> mapa = new HashMap<>();
		List<ItemVenda> lista = new ArrayList<>();

		mapa.put("ARROZ", 12.49);
		mapa.put("FEIJAO", 10.50);
		mapa.put("FARINHA", 4.75);
		mapa.put("OVO", 0.99);
		mapa.put("MACARRAO", 3.00);

		listaProdutos();
		System.out.println();
		
		while (true) {
			System.out.println("Digite o nome do produto ou sair: ");
			String nome = sc.next().toUpperCase();

			if (nome.equalsIgnoreCase("sair")) {
				break; //sair do loop
			}

			if (mapa.containsKey(nome.toUpperCase()) == false) {
				System.out.println("Produto não encontrado.");
				continue; //volta pro começo do loop
			}

			// a partir daqui só acontece se o produto for encontrado
			System.out.println("Digite a quantidade: ");
			int quant = sc.nextInt();

			lista.add(new ItemVenda(nome, quant));
		}

		imprimir(lista, mapa);
	}

}
