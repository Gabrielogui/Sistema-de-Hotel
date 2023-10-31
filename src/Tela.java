import javax.swing.JFrame;

public class Tela extends JFrame{
    private int altura  = 500;
    private int largura = 500;

    public Tela(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(this.largura, this.altura);
        this.setTitle("SIstema de Reserva");
        this.setVisible(true);

       // this.setLayout();
    }
}
