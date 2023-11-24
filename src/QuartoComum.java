public class QuartoComum extends Quarto{

    // ======= CONSTRUTOR =======
    public QuartoComum(int numero) {
        super(numero);
        super.setTipo("Comum");
    }

    // ======= MÉTODOS =======
    @Override
    public double calcPrecoTotal(double qtdeDia){
        super.precoDiaria = 500.00;
        return qtdeDia * super.precoDiaria;
    }
}
