package classes;

public class Pedido {
    public int numPedido;
    public String telefone;
    public String codigoPizza;
    public EstadoPedido estado;
    public enum EstadoPedido {
        ACEITO,
        EM_PREPARO,
        A_CAMINHO,
        ENTREGUE
    }
    

    public Pedido(String numPedido, String telefone, String codigoPizza) {
        if (numPedido == null || numPedido.trim().isEmpty() || Integer.parseInt(numPedido) < 1) {
            throw new IllegalArgumentException("Número do pedido inválido");
        }

        if (telefone == null || telefone.trim().isEmpty() || telefone.length() != 11) {
            throw new IllegalArgumentException("Telefone inválido");
        }

        if (codigoPizza == null || codigoPizza.trim().isEmpty() || Integer.parseInt(codigoPizza) < 0) {
            throw new IllegalArgumentException("Código inválido");
        }
        
        this.numPedido = Integer.parseInt(numPedido);
        this.telefone = telefone;
        this.codigoPizza = codigoPizza;
        this.estado = EstadoPedido.ACEITO;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCodigoPizza() {
        return codigoPizza;
    }

    public void setCodigoPizza(String codigoPizza) {
        this.codigoPizza = codigoPizza;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return String.format("*Pedido %d*: Telefone Cliente: %s  ||  Código Pizza: %s  ||  Estado Pedido: %s", numPedido, telefone, codigoPizza, estado);
    } 
    
}
