public class Quarto {
    private int numero;
    private boolean disponivel;
    private double precoDiaria;

    // ======= CONSTRUTOR =======
    public Quarto(int numero, double precoDiaria) {
        this.numero = numero;
        this.precoDiaria = precoDiaria;
        this.disponivel = true;
    }

    // ======= GETS E SETS =======
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    // ======= MÉTODOS =======

    public void calcPrecoTotal(){
        
    }
}
