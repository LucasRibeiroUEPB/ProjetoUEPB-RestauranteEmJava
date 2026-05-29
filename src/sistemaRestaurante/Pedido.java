package sistemaRestaurante;

public class Pedido {
	String nomeDoItem;
	double valorDoItem;
	int	quantidade;
	Pedido(String nomeDoItem, double valorDoItem, int quantidade){
		this.nomeDoItem = nomeDoItem;
		this.valorDoItem = valorDoItem;
		this.quantidade = quantidade;
	}
	double calcularValorTotalDoPedido() {
		return valorDoItem * quantidade;
	}
	public String toString() {
		return "Pedido: " + nomeDoItem + " Valor Unitário R$: " + valorDoItem + " Quantidade: " + quantidade + " Total: R$" + calcularValorTotalDoPedido(); 
	}
}
