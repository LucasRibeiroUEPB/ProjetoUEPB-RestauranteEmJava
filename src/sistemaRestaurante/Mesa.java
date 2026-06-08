package sistemaRestaurante;

public class Mesa {
	int numeroDaMesa;
	boolean mesa_ativa = false;
	Pedido[] pedidos_da_mesa;
	int quantidadeDePedidos;

	Mesa(int numero, int capacidade_de_pedidos) {
		this.numeroDaMesa = numero;
		this.mesa_ativa = true;
		this.pedidos_da_mesa = new Pedido[capacidade_de_pedidos];
		this.quantidadeDePedidos = 0;
	}

	boolean adicionarPedido(Pedido novoPedido) {
		if (quantidadeDePedidos < pedidos_da_mesa.length) {
			pedidos_da_mesa[quantidadeDePedidos] = novoPedido;
			quantidadeDePedidos++;
			return true;
		}
		return false;
	}

	double calcularValorTotalDaMesa() {
		double soma = 0;
		for (int i = 0; i < quantidadeDePedidos; i++) {
			soma += pedidos_da_mesa[i].calcularValorTotalDoPedido();
		}
		return soma;
	}

	String listarPedidos() {
		String pedidos = "Pedidos:\n";
		for (int i = 0; i < quantidadeDePedidos; i++) {
			pedidos += pedidos_da_mesa[i].toString();
		}
		return pedidos;
	}

	void encerrarMesa() {
		mesa_ativa = false;
		pedidos_da_mesa = null;
		quantidadeDePedidos = 0;
	}

	public String toString() {
		String status;
		if (mesa_ativa) {
			status = "aberta";
		} else {
			status = "fechada";
		}

		return "Mesa " + numeroDaMesa + " | " + "Status: " + status + " | " + "Total de pedidos: " + quantidadeDePedidos
				+ " | " + "Total a pagar: R$" + calcularValorTotalDaMesa() + "|" + listarPedidos();
	}
}