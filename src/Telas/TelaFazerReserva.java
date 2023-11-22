import javax.swing.*;

public class TelaFazerReserva extends JFrame {
    private JPanel TelaFazerReserva;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton reservarButton;
    private JTextField textField5;

    public TelaFazerReserva() {
        setContentPane(TelaFazerReserva);
        setTitle("Fazer Reserva");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
