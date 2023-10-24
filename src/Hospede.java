public class Hospede {
    private String nome;
    private String cpf;

    // ======= CONSTRUTOR =======
    public Hospede(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    // ======= GETS E SETS =======
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
