package classes;

public class Cliente {
    private String nome;
    private String telefone;
    private String cep;
    private String rua;
    private String numero;

    public Cliente(String nome, String telefone, String cep, String rua, String numero) {
        
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("nome inválido");
        }
           
        if (telefone.length() != 11) {
            throw new IllegalArgumentException("telefone inválido");
        }
        
        if (cep.length() != 8) {
            throw new IllegalArgumentException("cep inválido");
        }
        
        if (rua == null || rua.equals("")) {
            throw new IllegalArgumentException("nome da rua inválida");
        }
        
        if (Integer.parseInt(numero) < 0) {
            throw new IllegalArgumentException("número de casa inválido");
        }
        
        this.nome = nome;
        this.telefone = telefone;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
              
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
