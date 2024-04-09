package classes;

public class Pedido {
    public int numPedido;
    public String telefone;
    public String codigoPizza;
    public enum EstadoPedido {
        EM_PREPARO,
        A_CAMINHO,
        ENTREGUE
    }
}
