package sistemaRestaurante;

public class Mesa {
	int numeroDaMesa;
	boolean mesa_ativa = false;
	Pedido[] pedidos_da_mesa;
	int quantidadeDePedidos = 0;

	public Mesa(int numero, int capacidade_de_pedidos) {
		this.numeroDaMesa = numero;
		this.mesa_ativa = true;
		this.pedidos_da_mesa = new Pedido[capacidade_de_pedidos];
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
		if (pedidos_da_mesa != null) {
			for (Pedido meusPedidos : pedidos_da_mesa) {
				if (meusPedidos != null) {
					soma += meusPedidos.calcularValorTotalDoPedido();
				}
			}
		}
		return soma;
	}

	void listarPedidos() {
		if (pedidos_da_mesa != null) {
			for (Pedido meusPedidos : pedidos_da_mesa) {
				if (meusPedidos != null) {
					System.out.println(meusPedidos.toString());
				}
			}
		}
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
				+ " | " + "Total a pagar: R$" + calcularValorTotalDaMesa();
	}
}