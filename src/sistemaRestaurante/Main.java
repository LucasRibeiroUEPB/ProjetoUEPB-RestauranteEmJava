package sistemaRestaurante;

import java.util.Scanner;

public class Main {

	static String lerTexto(String mensagem) {
		Scanner scan = new Scanner(System.in);
		System.out.println(mensagem);
		return scan.nextLine();
	}

	static int lerInteiro(String mensagem) {
		Scanner scan = new Scanner(System.in);
		System.out.println(mensagem);
		return scan.nextInt();
	}

	static double lerDouble(String mensagem) {
		Scanner scan = new Scanner(System.in);
		System.out.println(mensagem);
		return scan.nextDouble();
	}

	static void mostrarMenu() {
		System.out.println("=== Sistema Restaurante ===\n");
		System.out.println("1 - Abrir Mesa");
		System.out.println("2 - Adicionar Pedido");
		System.out.println("3 - Fechar Mesa");
		System.out.println("4 - Listar Mesas Ativas");
	}

	public static void main(String[] args) {
		int quantidade = lerInteiro("Insira a quantidade máxima de mesas do restaurante:");
		Restaurante restaurante = new Restaurante(quantidade);

	}

}
