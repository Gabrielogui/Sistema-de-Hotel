package src.Telas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JPanel TelaPrincipal;
    private JLabel Text1;
    private JButton fazerReservaButton;
    private JButton consultarReservaButton;
    private JButton excluirReservaButton;
    private JButton editarReservaButton1;
    private JButton listarReservasButton;
    private JButton listarHospedesButton;
    private JButton removerHospedeButton;

    public TelaPrincipal() {
        setContentPane(TelaPrincipal);
        setTitle("Sistema de Reserva");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setVisible(true);

        fazerReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaFazerReserva tela1 = new TelaFazerReserva();
                tela1.setVisible(true);
            }
        });
        consultarReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaConsultarReserva tela2 = new TelaConsultarReserva();
                tela2.setVisible(true);
            }
        });
        excluirReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaExcluirReserva tela3 = new TelaExcluirReserva();
                tela3.setVisible(true);
            }
        });
        removerHospedeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRemoverHospede tela4 = new TelaRemoverHospede();
                tela4.setVisible(true);
            }
        });
        listarReservasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaListarReservas tela5 = new TelaListarReservas();
                tela5.setVisible(true);
            }
        });
        listarHospedesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaListarHospedes tela6 = new TelaListarHospedes();
                tela6.setVisible(true);
            }
        });
        editarReservaButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaEditarReserva tela7 = new TelaEditarReserva();
                tela7.setVisible(true);
            }
        });
    }
}
