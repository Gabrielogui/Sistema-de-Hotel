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
    // NÚMERO DO QUARTO:
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    // QUANTIDADE DE RESERVAS UTILIZANDO ESSE QUARTO:
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
    // PREÇO DA DIÁRIA:
    public double getPrecoDiaria() {
        return precoDiaria;
    }
    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    // TIPO DO QUARTO:
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    // ======= MÉTODOS =======

    public double calcPrecoTotal(){ // BOTAR NA CLASSE RESERVA
        int qtdeDia=0;
        return this.precoDiaria * qtdeDia;
    }

    // INTERANDO AS VEZES QUE O QUARTO É UTILIZADO
    public void interarUtilizado(){
        this.qtdeUsado++;
    }

    // DESCRIÇÃO DE CADA QUARTO:
    public void descricao(){
        
    }
}
