import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Hotel hotel = new Hotel();
        Tela tela = new Tela();
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
            System.out.println("6 - Sair                       ");
            System.out.println("===============================");
            System.out.println("Escolha a opção:               ");

            op = scan.nextInt();
            scan.nextLine();

            switch(op){
                case 1:
                    System.out.println("Já é um hóspede? (1 = SIM ; 0 = NAO)");
                    int opc = scan.nextInt();
                    if(opc == 1){
                        System.out.println("Diga seu CPF");
                        String cpf = scan.nextLine();
                        for(int i = 0 ; i < hotel.getHospedes().size() ; i++){
                            if(hotel.getHospedes().get(i).getCpf() == cpf){
                                break;
                            }
                        }
                    } else{
                        System.out.println("Nome do hóspede: ");
                        String nome = scan.nextLine();
                        System.out.println("CPF do hóspede: ");
                        String cpf = scan.nextLine();
                        Hospede hospede = new Hospede(nome, cpf);
                        hotel.addHospede(hospede);
                    }
                    /* 
                    Reserva reserva = new Reserva(hospede, quarto, dataEntrada, dataSaida);
                    hotel.addReserva(reserva);*/
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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
        
    }

    private static void exit(int i) {
    }
}