package classes;
      
public class Pizza {
    private String codigo;
    private String nome;
    private String descricao;
    private double valor;

    public Pizza(String codigo, String nome, String descricao, double valor) {
        
        if (codigo == null || codigo.equals("")) {
            throw new IllegalArgumentException("código inválido");
        }
        
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("nome inválido");
        }
           
        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("descrição inválida");
        }
             
        if (valor < 0) {
            throw new IllegalArgumentException("valor inválido");
        }
        
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
    
}
