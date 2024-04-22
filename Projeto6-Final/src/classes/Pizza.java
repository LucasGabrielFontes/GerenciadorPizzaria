package classes;
      
public class Pizza {

    private String codigo;
    private String nome;
    private String descricao;
    private String valor;

    public Pizza(String codigo, String nome, String descricao, String valor) {
        
        if (codigo == null || codigo.equals("")) {
            throw new IllegalArgumentException("código inválido");
        }
        
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("nome inválido");
        }
           
        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("descrição inválida");
        }
             
        if (Double.parseDouble(valor) < 0) {
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}