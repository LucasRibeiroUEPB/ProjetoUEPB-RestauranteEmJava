package sistemaRestaurante;

public class Mesa {
	int numero_de_mesa;
	boolean mesa_ativa;
	Pedido[] pedidos_da_mesa;
	int Total_mesa;
	public Mesa(int numero, int capacidade_de_pedidos) {
		this.numero_de_mesa = numero;
		this.mesa_ativa = true;
		this.pedidos_da_mesa = new Pedido[capacidade_de_pedidos];
		this.Total_mesa = 0;
	}
	//public boolean Adicionar_Pedido();

}
