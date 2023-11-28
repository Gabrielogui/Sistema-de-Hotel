//package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainSwing {
    private Hotel hotel = new Hotel();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainSwing().createAndShowGUI());
        
    }

    private void createAndShowGUI() {
        hotel.inicializandoQuartos();
        JFrame frame = new JFrame("Sistema de Reserva no Hotel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JButton fazerReservaBtn = new JButton("Fazer Reserva");
        fazerReservaBtn.setFont(new Font("Serif", Font.BOLD, 20));
        fazerReservaBtn.addActionListener(e -> fazerReserva());

        JButton excluirReservaBtn = new JButton("Excluir Reserva");
        excluirReservaBtn.setFont(new Font("Serif", Font.BOLD, 20));
        excluirReservaBtn.addActionListener(e -> excluirReserva());

        JButton listarReservasBtn = new JButton("Listar Reservas");
        listarReservasBtn.setFont(new Font("Serif", Font.BOLD, 20));
        listarReservasBtn.addActionListener(e -> listarReservas());

        JButton editarReservasBtn = new JButton("Editar Reserva");
        editarReservasBtn.setFont(new Font("Serif", Font.BOLD, 20));
        editarReservasBtn.addActionListener(e -> editarReserva());

        JButton consultarReservaBtn = new JButton("Consultar Reserva");
        consultarReservaBtn.setFont(new Font("Serif", Font.BOLD, 20));
        consultarReservaBtn.addActionListener(e -> consultarReserva());

        JButton listarHospedesBtn = new JButton("Listar Hóspedes");
        listarHospedesBtn.setFont(new Font("Serif", Font.BOLD, 20));
        listarHospedesBtn.addActionListener(e -> listarHospede());

        JButton removerHospedeBtn = new JButton("Remover Hóspede");
        removerHospedeBtn.setFont(new Font("Serif", Font.BOLD, 20));
        removerHospedeBtn.addActionListener(e -> removerHospede());

        frame.add(fazerReservaBtn);
        frame.add(excluirReservaBtn);
        frame.add(listarReservasBtn);
        frame.add(editarReservasBtn);
        frame.add(consultarReservaBtn);
        frame.add(listarHospedesBtn);
        frame.add(removerHospedeBtn);


        frame.setVisible(true);
    }

    private void fazerReserva() {
        JFrame reservaFrame = new JFrame("Fazer Reserva");
        reservaFrame.setSize(400, 200);
        reservaFrame.setLayout(new GridLayout(6, 2));

        JTextField cpfField = new JTextField(1);
        JTextField nomeField = new JTextField(1);
        JTextField tipoQuartoField = new JTextField(1);
        JTextField dataEntradaField = new JTextField(1);
        JTextField dataSaidaField = new JTextField(1);
        JButton reservarBtn = new JButton("Reservar");
        reservarBtn.setFont(new Font("Serif", Font.BOLD, 20));

        reservarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate dataEntrada;
                LocalDate dataSaida;
                QuartoComum quartoComum;
                QuartoVIP quartoVip;

                String cpf = cpfField.getText().trim();
                String nome = nomeField.getText().trim();
                String tipoQuarto = tipoQuartoField.getText().trim();
                String data_Entrada = dataEntradaField.getText().trim();
                String data_Saida = dataSaidaField.getText().trim();
                
                if (cpf.isEmpty()) {
                    showMessage("[Erro]", "CPF não pode estar em branco.");
                    return;
                }if (nome.isEmpty()) {
                    showMessage("[Erro]", "Nome não pode estar em branco.");
                    return;
                }if(tipoQuarto.isEmpty()){
                    showMessage("[Erro]", "Tipo do Quarto não pode estar em branco.");
                    return;
                }if (data_Entrada.isEmpty()) {
                    showMessage("[Erro]", "Data não pode estar em branco.");
                    return;
                }if (data_Saida.isEmpty()) {
                    showMessage("[Erro]", "Data não pode estar em branco.");
                    return;
                }

                
                

                dataEntrada = LocalDate.parse(data_Entrada, formatter);
                dataSaida = LocalDate.parse(data_Saida, formatter);
                if((tipoQuarto.equals("Comum")) || (tipoQuarto.equals("comum")) || (tipoQuarto.equals("COMUM"))){

                    if(hotel.verificarDatasReserva(dataEntrada, dataSaida) == null){
                        showMessage("[Erro]", "Data Indisponível");
                        return;
                    }else{
                        if(hotel.conferirCpf(cpf) == null){
                            Hospede usuario = new Hospede(nome, cpf);
                            hotel.addHospede(usuario);
                            quartoComum = (QuartoComum) hotel.verificarDatasReserva(dataEntrada, dataSaida);
                            Reserva reserva = new Reserva(usuario, quartoComum, dataEntrada, dataSaida, hotel.gerandoId());
                            hotel.addReserva(reserva);
                        }else{
                            Hospede usuario = hotel.conferirCpf(cpf);
                            quartoComum = (QuartoComum) hotel.verificarDatasReserva(dataEntrada, dataSaida);
                            Reserva reserva = new Reserva(usuario, quartoComum, dataEntrada, dataSaida, hotel.gerandoId());
                            hotel.addReserva(reserva);
                        }    
                    }
                }else if((tipoQuarto.equals("Vip")) || (tipoQuarto.equals("vip")) || (tipoQuarto.equals("VIP"))){

                    if(hotel.verificarDatasVipReserva(dataEntrada, dataSaida) == null){
                        showMessage("[Erro]", "Data Indisponível");
                        return;
                    }else{
                        if(hotel.conferirCpf(cpf) == null){
                            Hospede usuario = new Hospede(nome, cpf);
                            hotel.addHospede(usuario);
                            quartoVip = (QuartoVIP) hotel.verificarDatasVipReserva(dataEntrada, dataSaida);
                            Reserva reserva = new Reserva(usuario, quartoVip, dataEntrada, dataSaida, hotel.gerandoId());
                            hotel.addReserva(reserva);
                        }else{
                            Hospede usuario = hotel.conferirCpf(cpf);
                            quartoVip = (QuartoVIP) hotel.verificarDatasVipReserva(dataEntrada, dataSaida);
                            Reserva reserva = new Reserva(usuario, quartoVip, dataEntrada, dataSaida, hotel.gerandoId());
                            hotel.addReserva(reserva);
                        }
                    }
                }else{
                    showMessage("[Erro]", "Digite o tipo de quarto como no exemplo!");
                    return;
                }
                
                showMessage("Sucesso", "Reserva feita com sucesso!");
                reservaFrame.dispose();
            }
        });

        reservaFrame.add(new JLabel("CPF do Hóspede:")).setFont(new Font("Serif", Font.BOLD, 20));
        reservaFrame.add(cpfField);
        reservaFrame.add(new JLabel("Nome do Hóspede:")).setFont(new Font("Serif", Font.BOLD, 20));;
        reservaFrame.add(nomeField);
        reservaFrame.add(new JLabel("Tipo de quarto:")).setFont(new Font("Serif", Font.BOLD, 20));;
        reservaFrame.add(tipoQuartoField);
        reservaFrame.add(new JLabel("Data de Check-IN:")).setFont(new Font("Serif", Font.BOLD, 20));;
        reservaFrame.add(dataEntradaField);
        reservaFrame.add(new JLabel("Data de Check-OUT:")).setFont(new Font("Serif", Font.BOLD, 20));;
        reservaFrame.add(dataSaidaField);

        reservaFrame.add(reservarBtn);
        reservaFrame.setVisible(true);
    }

    private void excluirReserva() {
        
        JFrame excluirFrame = new JFrame("Excluir Reserva");
        excluirFrame.setSize(400, 200);
        excluirFrame.setLayout(new GridLayout(3, 2));

        JTextField idField = new JTextField(10);
        JButton excluirBtn = new JButton("Excluir");
        excluirBtn.setFont(new Font("Serif", Font.BOLD, 20));

        excluirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().trim();
                if(id.isEmpty()){
                    showMessage("[Erro]", "Campo ID não pode estar em branco");
                    return;
                }
                
                int id_int = Integer.parseInt(id);
                int removedReservas = hotel.removerReservaId(id_int);
                if (removedReservas == 1) {
                    showMessage("Sucesso", "Reserva(s) removida(s) com sucesso!");
                    excluirFrame.dispose();
                } else {
                    showMessage("Erro", "Nenhuma reserva encontrada para o ID informado.");
                }
            }
        });

        excluirFrame.add(new JLabel("ID do Hóspede:")).setFont(new Font("Serif", Font.BOLD, 20));;
        excluirFrame.add(idField);
        excluirFrame.add(excluirBtn);
        excluirFrame.setVisible(true);
    }

    private void listarReservas() {
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        for (Reserva reserva : hotel.getReservas()) {
            textArea.append(reserva.toString() + "\n");
        }

        JFrame listarFrame = new JFrame("Listar Reservas");
        listarFrame.setSize(400, 300);
        listarFrame.setLayout(new FlowLayout());
        listarFrame.add(new JScrollPane(textArea));
        listarFrame.setVisible(true);
    }

    private void consultarReserva(){
        JFrame consultar01Frame = new JFrame("Consultar Reserva");
        consultar01Frame.setSize(400, 300);
        consultar01Frame.setLayout(new GridLayout(3, 2));

        JTextField idField = new JTextField(10);
        JButton consultarBtn = new JButton("Consultar");
        consultarBtn.setFont(new Font("Serif", Font.BOLD, 20));

        consultarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String id = idField.getText().trim();
                int id_int = Integer.parseInt(id);

                JTextArea textArea = new JTextArea(10, 30);
                textArea.setEditable(false);

                if(hotel.exibirUmaReservaId(id_int) == null){
                    showMessage("[Erro]", "Reserva com esse ID não encontrado");
                    return;
                }else{
                    textArea.append(hotel.exibirUmaReservaId(id_int) + "\n");
                }

                JFrame consultar02Frame = new JFrame("Consultar Reserva");
                consultar02Frame.setSize(400, 300);
                consultar02Frame.setLayout(new FlowLayout());
                consultar02Frame.add(new JScrollPane(textArea));
                consultar02Frame.setVisible(true);
            }
        });
        consultar01Frame.add(new JLabel("ID do Hóspede:")).setFont(new Font("Serif", Font.BOLD, 20));;
        consultar01Frame.add(idField);
        consultar01Frame.add(consultarBtn);
        consultar01Frame.setVisible(true);
    }

    private void editarReserva(){

        JFrame editarFrame = new JFrame("Editar Reserva");
        editarFrame.setSize(400, 300);
        editarFrame.setLayout(new GridLayout(3, 2));
        
        JTextField idField = new JTextField(10);
        JButton editarBtn = new JButton("Editar");
        editarBtn.setFont(new Font("Serif", Font.BOLD, 20));

        editarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame editar01Frame = new JFrame("Editar Reserva");
                String id = idField.getText().trim();
                if(id.isEmpty()){
                    showMessage("[Erro]", "ID não pode estar em branco.");
                }
                
                editar01Frame.setSize(400, 300);
                editar01Frame.setLayout(new GridLayout(5, 3, 5, 5));
                JTextArea textArea = new JTextArea(10, 10);
                textArea.setEditable(false);

                JTextField tipoQuartoField = new JTextField(1);
                JTextField dataEntradaField = new JTextField(1);
                JTextField dataSaidaField = new JTextField(1);
                JButton editar01Btn = new JButton("Confirmar");
                int id_int = Integer.parseInt(id);
                
                if(hotel.exibirUmaReservaId(id_int) == null){
                    showMessage("[Erro]", "Reserva com esse ID não encontrado");
                    return;
                }else{
                    textArea.append(hotel.exibirUmaReservaId(id_int) + "\n");
                }

                editar01Btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        String tipoQuarto = tipoQuartoField.getText().trim();
                        String data_Entrada = dataEntradaField.getText().trim();
                        String data_Saida = dataSaidaField.getText().trim();
                        if(tipoQuarto.isEmpty()){
                            showMessage("[Erro]", "Tipo do Quarto não pode estar em branco.");
                        }
                        if(data_Entrada.isEmpty()){
                            showMessage("[Erro]", "Data não pode estar em branco.");
                        }
                        if(data_Saida.isEmpty()){
                            showMessage("[Erro]", "Data não pode estar em branco.");
                        }
                        LocalDate novaDataEntrada;
                        LocalDate novaDataSaida;

                        novaDataEntrada = LocalDate.parse(data_Entrada, formatter);
                        novaDataSaida = LocalDate.parse(data_Saida, formatter);
                        if((tipoQuarto.equals("Comum")) || (tipoQuarto.equals("comum")) || (tipoQuarto.equals("COMUM"))){
                            
                            if(hotel.verificarDatasReserva(novaDataEntrada, novaDataSaida) == null){
                                showMessage("[Erro]", "Data Indisponível");
                                return;
                            }else{
                                hotel.editarReserva(novaDataEntrada, novaDataSaida, id_int, 0);
                            }
                        }else if((tipoQuarto.equals("Vip")) || (tipoQuarto.equals("vip")) || (tipoQuarto.equals("VIP"))){

                            if(hotel.verificarDatasVipReserva(novaDataEntrada, novaDataSaida) == null){
                                showMessage("[Erro]", "Data Indisponível");
                                return;
                            }else{
                                hotel.editarReserva(novaDataEntrada, novaDataSaida, id_int, 1);  
                            }
                        }else{
                            showMessage("[Erro]", "Digite o tipo de quarto como no exemplo!");
                            return;
                        }
                        showMessage("Sucesso", "Reserva editada com sucesso!");
                        editar01Frame.dispose();
                    }
                });



                editar01Frame.add(new Label("EDITAR:")).setFont(new Font("Serif", Font.BOLD, 20));;
                editar01Frame.add(new JScrollPane(textArea));
                editar01Frame.add(new JLabel("Tipo de quarto(Vip / Comum):")).setFont(new Font("Serif", Font.BOLD, 20));;
                editar01Frame.add(tipoQuartoField);
                editar01Frame.add(new JLabel("Data de Check-IN:")).setFont(new Font("Serif", Font.BOLD, 20));;
                editar01Frame.add(dataEntradaField);
                editar01Frame.add(new JLabel("Data de Check-OUT:")).setFont(new Font("Serif", Font.BOLD, 20));;
                editar01Frame.add(dataSaidaField);
                editar01Frame.add(editar01Btn);
                
                editar01Frame.setVisible(true);
            }
        });

        editarFrame.add(new JLabel("ID do Hóspede:"));
        editarFrame.add(idField);
        editarFrame.add(editarBtn);
        editarFrame.setVisible(true);
    }

    private void listarHospede(){
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        for(Hospede hospede : hotel.getHospedes()){
            textArea.append(hospede.listarHospede() + "\n");
        }

        JFrame listarHospedesFrame = new JFrame("Listar Hóspedes");
        listarHospedesFrame.setSize(400, 300);
        listarHospedesFrame.setLayout(new FlowLayout());
        listarHospedesFrame.add(new JScrollPane(textArea));
        listarHospedesFrame.setVisible(true);
    }

    private void removerHospede(){
        JFrame removerHospedeFrame = new JFrame("Remover Hóspede");
        removerHospedeFrame.setSize(400, 300);
        removerHospedeFrame.setLayout(new GridLayout(3, 1));
        

        JTextField cpfField = new JTextField(10);
        JButton removerBtn = new JButton("Remover");
        removerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String cpf = cpfField.getText().trim();
                if(cpf.isEmpty()){
                    showMessage("[Erro]", "CPF não pode estar em branco.");
                    return;
                }

                if(hotel.conferirCpf(cpf) == null){
                    showMessage("[Erro]", "CPF não encontrado!");
                    return;
                }
                do{
                    hotel.removerReserva(cpf);
                }while(hotel.removerReserva(cpf) == 1);
                hotel.removerHospede(cpf);
                showMessage("Sucesso!", "Hóspede removido com sucesso!");
            }
        });

        removerHospedeFrame.add(new JLabel("CPF do Hóspede:")).setFont(new Font("Serif", Font.BOLD, 20));;
        removerHospedeFrame.add(cpfField);
        removerHospedeFrame.add(removerBtn);

        removerHospedeFrame.setVisible(true);
    }

    private void showMessage(String title, String content) {
        JOptionPane.showMessageDialog(null, content, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
