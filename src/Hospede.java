public class Hospede {
    private String nome;
    private String cpf;
    //private double ValorTotal;

    // ======= CONSTRUTOR =======
    public Hospede(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    // ======= GETS E SETS =======
    // NOME:
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // CPF:
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String listarHospede(){
        return "Hospede{" +
                "Nome = " + this.getNome() +
                ", CPF = " + this.getCpf() +
                "}";
    }

}
