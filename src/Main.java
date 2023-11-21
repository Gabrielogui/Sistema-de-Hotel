import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Hotel hotel = new Hotel();
        Tela tela = new Tela();

        // ADICIONANDO OS QUARTOS:
        for(int i = 0 ; i < 3 ; i++){
            Quarto q = new Quarto(i + 1);
            hotel.addQuarto(q);
        }

        // MENU
        int op;
        while(true){
            System.out.println("===============================");
            System.out.println("  SISTEMA DE RESERVA NO HOTEL  ");
            System.out.println("===============================");
            System.out.println("1 - Fazer Reserva              ");
            System.out.println("2 - Excluir Reserva            ");
            System.out.println("3 - Editar Reserva             ");
            System.out.println("4 - Consultar Reserva          ");
            System.out.println("5 - Listar Todas as Reservas   ");
            System.out.println("6 - Listar todos os Hospede    ");
            System.out.println("7 - Remover Hóspede            ");
            System.out.println("8 - Sair                       ");
            System.out.println("===============================");
            System.out.println("Escolha a opção:               ");

            op = scan.nextInt();
            scan.nextLine();

            switch(op){
                case 1:
                    String cpf;
                    System.out.println("Já é um hóspede? (1 = SIM ; 0 = NAO)");
                    int opc = scan.nextInt();
                    scan.nextLine();
                    int i;
                    String nome;
                    Hospede usuario = null;
                    LocalDate data_entrada, data_saida;
                    String data;
                    Quarto quarto;
                    //QuartoVIP quartovip;

                    if(opc == 1){
                        System.out.println("Digite seu CPF: ");
                        cpf = scan.nextLine();
                        if(hotel.conferirCpf(cpf) == null){ 
                            System.out.println("CPF não encontrado! ");
                            continue;
                        }
                        usuario = hotel.conferirCpf(cpf);
                    }
                    if(opc == 0){
                        System.out.println("Nome do hóspede: ");
                        nome = scan.nextLine();
                        System.out.println("CPF do hóspede: ");
                        cpf = scan.nextLine();
                        Hospede hospede = new Hospede(nome, cpf);
                        hotel.addHospede(hospede);
                        usuario = hotel.conferirCpf(cpf);
                        //continue;
                    }

                    System.out.println("Você deseja quarto VIP(1 = SIM ; 0 = NAO)");
                    int opVip = scan.nextInt();
                    scan.nextLine();

                     // Definindo o formato da data
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    System.out.println("Informe a data que deseja realizar o check-in: ");
                    data = scan.nextLine();
                    data_entrada = LocalDate.parse(data, formatter);
    
                    System.out.println("Informe a data que deseja realizar o check-out: ");
                    data = scan.nextLine();
                    data_saida = LocalDate.parse(data, formatter);
                    
                    System.out.println("0");
                    if(opVip == 0){
                        if(hotel.verificarDatasReserva(data_entrada, data_saida) == null){
                        System.out.println("Essa data não está disponível!");
                        continue;
                        }
                        System.out.println("1");
                        quarto = hotel.verificarDatasReserva(data_entrada, data_saida);
                        System.out.println("2");
                        Reserva reserva = new Reserva(usuario, quarto, data_entrada, data_saida);
                        System.out.println("3");
                        hotel.addReserva(reserva);
                        System.out.println("4");
                    } /*else{
                        quartovip = hotel.verificarDatasVipReserva(data_entrada, data_saida);
                        Reserva reserva = new Reserva(usuario, quarto);
                        hotel.addReserva(reserva);
                    }*/
                    

                    
                    /*System.out.println("Deseja quarto vip? (1 = SIM ; 0 = NAO)");
                    int opVip = scan.nextInt();
                    scan.nextLine();

                    if(opVip == 1){
                        QuartoVIP quartoVIP = new QuartoVIP(1);
                    }else{
                        Quarto quarto = new Quarto(2);
                            }*/
                    //Quarto quarto = new Quarto(1); // FUTURAMENTE JA TERÃO QUARTOS PRE FEITOS
                    
                    
                    
                    System.out.println("Reserva feita com sucesso!");
                    break;
                case 2:
                    System.out.println("Informe o cpf da reserva que deseje remover: ");
                    cpf = scan.nextLine();
                    if(hotel.removerReserva(cpf) == 0){ 
                        System.out.println("Cpf não encontrado!");
                        continue;
                    }
                    hotel.removerReserva(cpf);
                    System.out.println("Reserva removida com sucesso!");
                    break;
                case 3: // EDITAR RESERVA
                    System.out.println("Insira o cpf da reserva que deseja alterar: ");
                    cpf = scan.nextLine();
                    if(hotel.conferirCpf(cpf) == null){
                        System.out.println("CPF não encontrado! ");
                        continue;
                    }
                    int o = 0;
                    while(o != 1){
                        hotel.printarUmaReserva(cpf);
                        System.out.println("Nova data:");
                        /*
                         
                        NOVA DATA;
                         
                         */
                        System.out.println("Deseja continuar? (sim = 0 ; nao = 1)");
                        o = scan.nextInt();
                    }
                    break;
                case 4: // CONSULTAR RESRVAS
                    System.out.println("Digite o cpf da Reserva: ");
                    cpf = scan.nextLine();
                    if(hotel.conferirCpf(cpf) == null){
                        System.out.println("CPF não encontrado! ");
                        continue;
                    }
                    hotel.printarUmaReserva(cpf);
                    scan.nextLine();
                    break;
                case 5: // LISTAR AS RESERVAS
                    hotel.listarReservas();
                    scan.nextLine();
                    break;
                case 6:
                    hotel.listarHospedes();
                    break;
                   /* System.out.println("Nome: ");
                    String nome = scan.nextLine();
                    System.out.println("cpf: ");
                    String cpf1 = scan.nextLine();
                    Hospede hospede = new Hospede(nome, cpf1);
                    hotel.addHospede(hospede);
                    */
                case 7:
                    System.out.println("Qual o cpf do hóspede que deseja excluir? ");
                    cpf = scan.nextLine();
                    if(hotel.conferirCpf(cpf) == null){
                        System.out.println("Cpf não encontrado!");
                        continue;
                    }
                    do{
                        hotel.removerReserva(cpf);
                    }while(hotel.removerReserva(cpf) == 1);
                    hotel.removerHospede(cpf);
                    System.out.println("Hospede removido com sucesso!");
                    break;
                case 8:
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                    break; 
                default:
                    System.out.println("Opção inválida!");

            }
            /*if(op == 6){
                break;
            }*/
        }
        //scan.close();
    }
    
    private static void exit(int i) {
    }
}