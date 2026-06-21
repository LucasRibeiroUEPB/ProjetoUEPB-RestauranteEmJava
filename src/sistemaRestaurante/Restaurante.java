package sistemaRestaurante;

public class Restaurante {
	Mesa mesas[];
	int totalMesas;

	Restaurante(int capacidadeMesas) {
		this.mesas = new Mesa[capacidadeMesas];
		this.totalMesas = 0;
	}

	Mesa buscarMesaPorNumero(int numero) {
		for (int i = 0; i < totalMesas; i++) {
			if (this.mesas[i].numeroDaMesa == numero) {
				return this.mesas[i];
			}
		}
		return null;
	}

	String abrirMesa(int numero) {
		if (buscarMesaPorNumero(numero) != null) {
			return "Erro: a mesa " + numero + " já existe no sistema";
		}
		if (totalMesas < mesas.length) {
			this.mesas[totalMesas] = new Mesa(numero);
			this.totalMesas++;
			return "Mesa " + numero + " aberta com sucesso!";
		}
		return "O restaurante não tem capacidade para novas mesas";
	}

	String adicionarPedidoEmMesa(int numeroMesa, String item, double preco, int quantidade) {
		Mesa mesaEncontrada = buscarMesaPorNumero(numeroMesa);

		if (mesaEncontrada != null) {
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

	String fecharMesa(int numeroMesa) {
		for (int i = 0; i < totalMesas; i++) {
			if (this.mesas[i].numeroDaMesa == numeroMesa) {
				double totalConta = this.mesas[i].calcularValorTotalDaMesa();
				this.mesas[i].encerrarMesa();
				for (int j = i; j < totalMesas - 1; j++) {
					this.mesas[j] = this.mesas[j + 1];
				}
				this.mesas[totalMesas - 1] = null;
				this.totalMesas--;
				return "Mesa " + numeroMesa + " encerrada. Total a pagar: R$ " + totalConta;
			}
		}
		return "Mesa não encontrada ou já está fechada";
	}

	String listarMesasAtivas() {
		String lista = "\n==== MESAS ATIVAS ====\n";
		boolean temMesa = false;

		for (int i = 0; i < totalMesas; i++) {
			lista += this.mesas[i].toString() + "\n";
			temMesa = true;
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