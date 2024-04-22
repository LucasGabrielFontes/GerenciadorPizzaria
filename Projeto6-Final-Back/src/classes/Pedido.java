package classes;

public class Pedido {
    private int numPedido;
    private String telefone;
    private String codigoPizza;
    private EstadoPedido estado;
    private enum EstadoPedido {
        ACEITO,
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

    public void avancarEstado() {
        switch (estado) {
            case ACEITO:
                estado = EstadoPedido.ENTREGUE;
                break;
            case ENTREGUE:
                throw new IllegalStateException("Pedido já foi entregue");
        }
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
