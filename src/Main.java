import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //String pausa = scan.next();

        int op;
        do{
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

            op = scan.nextInt();
            scan.nextLine();

            switch(op){
                case 1:

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
                    break;
                default:
                    System.out.println("Opção inválida!");

            }

        }while(op != 6);
        
    }
}