public class Quarto {
    private int numero;
    //private boolean disponivel; // COLOCAR LISTA DE DATAS
    protected double precoDiaria; 

    // ======= CONSTRUTOR =======
    public Quarto(int numero) {
        this.numero = numero;
        this.precoDiaria = 500.00;
        //this.disponivel = true;
    }

    // ======= GETS E SETS =======
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /*public boolean getDisponivel() {
        return disponivel;
    }*/

    /*public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }*/

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    // ======= MÉTODOS =======

    public double calcPrecoTotal(){
        int qtdeDia=0;
        return this.precoDiaria * qtdeDia;
    }

    public void descricao(){
        
    }
}
