package sistemaRestaurante;



public class Mesa {
	int numeroDaMesa;
	boolean mesa_ativa = false;
	Pedido[] pedidos_da_mesa;

	Mesa(int numero) {
		this.numeroDaMesa = numero;
		this.mesa_ativa = true;
		this.pedidos_da_mesa = new Pedido[0];
	}

	boolean adicionarPedido(Pedido novoPedido) {
	    Pedido[] auxiliar = new Pedido[pedidos_da_mesa.length + 1];
	    for (int i = 0; i < pedidos_da_mesa.length; i++) {
	        auxiliar[i] = pedidos_da_mesa[i];
	    }
	    pedidos_da_mesa = auxiliar;
	    pedidos_da_mesa[pedidos_da_mesa.length - 1] = novoPedido;
	    return true;
	}
	
	
	double calcularValorTotalDaMesa() {
		double soma = 0;
		for (int i = 0; i < pedidos_da_mesa.length; i++) {
			soma += pedidos_da_mesa[i].calcularValorTotalDoPedido();
		}
		return soma;
	}

	String listarPedidos() {
		String pedidos = "Pedidos:\n";
		for (int i = 0; i < pedidos_da_mesa.length; i++) {
			pedidos += pedidos_da_mesa[i].toString();
		}
		return pedidos;
	}

	void encerrarMesa() {
		mesa_ativa = false;
		pedidos_da_mesa = null;
	}

	public String toString() {
		String status;
		if (mesa_ativa) {
			status = "aberta";
		} else {
			status = "fechada";
		}

		return "Mesa " + numeroDaMesa + " | " + "Status: " + status + " | " + "Total de pedidos: " + pedidos_da_mesa.length
				+ " | " + "Total a pagar: R$" + calcularValorTotalDaMesa() + "|" + listarPedidos();
	}
}