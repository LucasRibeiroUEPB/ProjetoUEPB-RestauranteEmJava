package sistemaRestaurante;

import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	static String lerTexto(String mensagem) {
		System.out.print(mensagem);
		return scan.nextLine();
	}

	static int lerInteiro(String mensagem) {
		System.out.print(mensagem);
		int valor = scan.nextInt();
		scan.nextLine();
		return valor;
	}

	static double lerDouble(String mensagem) {
		System.out.print(mensagem);
		double valor = scan.nextDouble();
		scan.nextLine();
		return valor;
	}

	static void abrirMesa(Restaurante restaurante) {
		int numero = lerInteiro("Qual o número da mesa?:");
		int capacidadePedidos = lerInteiro("Qual a capacidade de pedidos da mesa?:");
		String operação = restaurante.abrirMesa(numero, capacidadePedidos);
		System.out.println(operação);

	}

	static void adicionarPedido(Restaurante restaurante) {
		int numeroMesa = lerInteiro("Em qual mesa quer adicionar o pedido?:");
		String item = lerTexto("Qual produto deseja adicionar?:");
		double preco = lerDouble("Qual o preço do produto?:");
		int quantidade = lerInteiro("Quantidade de produtos que deseja adicionar:");
		String operacao = restaurante.adicionarPedidoEmMesa(numeroMesa, item, preco, quantidade);
		System.out.println(operacao);
	}

	static void fecharMesa(Restaurante restaurante) {
		int numeroMesa = lerInteiro("Qual o número da mesa que deseja fechar?:");
		String operacao = restaurante.fecharMesa(numeroMesa);
		System.out.println(operacao);
	}

	static void listarMesasAtivas(Restaurante restaurante) {
		String listar = restaurante.listarMesasAtivas();
		System.out.println(listar);
	}

	static void mostrarMenu() {
		System.out.println("=== Sistema Restaurante ===\n");
		System.out.println("1 - Abrir Mesa");
		System.out.println("2 - Adicionar Pedido");
		System.out.println("3 - Fechar Mesa");
		System.out.println("4 - Listar Mesas Ativas");
		System.out.println("0 - Encerrar programa");
	}

	public static void main(String[] args) {
		int quantidade = lerInteiro("Insira a quantidade máxima de mesas do restaurante:");
		Restaurante restaurante = new Restaurante(quantidade);
		mostrarMenu();
		int opcao = lerInteiro("Selecione a opção:");
		while (opcao != 0) {
			switch (opcao) {
			case 1: {
				abrirMesa(restaurante);
				break;
			}
			case 2:
				adicionarPedido(restaurante);
				break;
			case 3:
				fecharMesa(restaurante);
				break;
			case 4:
				listarMesasAtivas(restaurante);
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida");
			}
			mostrarMenu();
			opcao = lerInteiro("Selecione a opção:");
		}
		System.out.println("Programa Encerrado!");
	}

}
