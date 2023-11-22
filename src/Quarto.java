public abstract class Quarto{
    private int numero;
    //private boolean disponivel; // COLOCAR LISTA DE DATAS
    private int qtdeUsado;
    protected double precoDiaria; 
    private String tipo;

    // ======= CONSTRUTOR =======
    public Quarto(int numero) {
        this.numero = numero;
        this.qtdeUsado = 0;
        this.precoDiaria = 500.00;
        this.tipo = "";
        //this.disponivel = true;
    }

    // ======= GETS E SETS =======
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQtdeUsado(){
        return qtdeUsado;
    }
    public void setQtdeUsado(int qtdeUsado){
        this.qtdeUsado = qtdeUsado;
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

    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    // ======= MÉTODOS =======

    public double calcPrecoTotal(){
        int qtdeDia=0;
        return this.precoDiaria * qtdeDia;
    }

    public void interarUtilizado(){
        this.qtdeUsado++;
    }

    public void descricao(){
        
    }
}
