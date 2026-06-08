package sistemaRestaurante;

public class Restaurante {
	Mesa mesas[];
	String cardapio[];
	int totalMesas;

	Restaurante(int capacidadeMesas) {
		this.mesas = new Mesa[capacidadeMesas];
		this.totalMesas = 0;
	}

	public Mesa buscarMesaPorNumero(int numero) {
		for (int i = 0; i < this.mesas.length; i++) {
			if (this.mesas[i] != null && this.mesas[i].numeroDaMesa == numero) {
				return this.mesas[i];
			}
		}
		return null;
	}

	public String abrirMesa(int numero, int capacidadePedidos) {
		if (buscarMesaPorNumero(numero) != null) {
			return "Erro: a mesa " + numero + " já existe no sistema";
		}

		for (int i = 0; i < this.mesas.length; i++) {
			if (this.mesas[i] == null) {
				this.mesas[i] = new Mesa(numero, capacidadePedidos);
				this.totalMesas++;
				return "Mesa " + numero + " está aberta";
			}
		}
		return "O restaurante não tem capacidade para novas mesas";
	}

	public String adicionarPedidoEmMesa(int numeroMesa, String item, double preco, int quantidade) {
		Mesa mesaEncontrada = buscarMesaPorNumero(numeroMesa);

		if (mesaEncontrada != null && mesaEncontrada.mesa_ativa) {
			Pedido NovoPedido = new Pedido(item, preco, quantidade);
			boolean sucesso = mesaEncontrada.adicionarPedido(NovoPedido);

			if (sucesso) {
				return "Pedido de " + item + " adicionado a mesa " + numeroMesa;
			} else {
				return "A mesa atingiu a capacidade máxima de pedidos";
			}
		}
		return "Mesa não encontrada ou fechada";
	}

	public String fecharMesa(int numeroMesa) {
		for (int i = 0; i < this.mesas.length; i++) {
			if (this.mesas[i] != null && this.mesas[i].numeroDaMesa == numeroMesa) {
				double totalConta = this.mesas[i].calcularValorTotalDaMesa();
				this.mesas[i].encerrarMesa();
				this.mesas[i] = null;
				this.totalMesas--;
				return "Mesa " + numeroMesa + " encerrada. Total a pagar: R$ " + totalConta;
			}
		}
		return "Mesa não encontrada ou já está fechada";
	}

	public String listarMesasAtivas() {
		String lista = "\n==== MESAS ATIVAS ====\n";
		boolean temMesa = false;

		for (int i = 0; i < this.mesas.length; i++) {
			if (this.mesas[i] != null && this.mesas[i].mesa_ativa) {
				lista += this.mesas[i].toString() + "\n";
				temMesa = true;
			}
		}
		if (!temMesa) {
			return "Nenhuma mesa ativa no momento.";
		}
		return lista;
	}

	public String toString() {
		return "Restaurante com " + this.totalMesas + " mesas abertas";
	}
}