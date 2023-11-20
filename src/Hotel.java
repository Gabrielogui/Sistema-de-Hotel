import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Hotel {
    private ArrayList<Quarto> quartos;
    private ArrayList<Reserva> reservas;
    private ArrayList<Hospede> hospedes;

    // ======= CONSTRUTOR =======
    public Hotel() {
        this.quartos  = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.hospedes = new ArrayList<>();
    }

    // ======= GETS E  SETS =======
    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(ArrayList<Quarto> quartos) {
        this.quartos = quartos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedes(ArrayList<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

    // ======= MÉTODOS =======
    
    // CONFERINDO O CPF:
    public Hospede conferirCpf(String cpf){
        int i, cont=0;
        for(i = 0 ; i < this.hospedes.size() ; i++){
            if(this.hospedes.get(i).getCpf().equals(cpf)){
                cont=1;
                break;
            }
        }
        if(cont == 1){
            return hospedes.get(i);
        }else{
            return null; // TESTAR PARA VÊ SE FUNCIONA
        }
    }

    // REMOVENDO HOSPEDE:
    public void removerHospede(String cpf){
        int i;
        for(i = 0 ; i < this.hospedes.size() ; i++){
            if(this.hospedes.get(i).getCpf().equals(cpf)){
                this.hospedes.remove(this.hospedes.get(i));
            }
        }
    }

    // LISTANDO HOSPEDE:
    public void listarHospedes(){
        for(int i = 0 ; i < this.hospedes.size() ; i++){
            System.out.println("Nome: " + this.hospedes.get(i).getNome());
            System.out.println("CPF : " + this.hospedes.get(i).getCpf());
        }
    }

    // REMOVENDO RESERVA:
    public int removerReserva(String cpf){
        for(int i = 0 ; i < this.reservas.size() ; i++){
            if(this.reservas.get(i).getHospede().getCpf().equals(cpf)){
                this.reservas.remove(this.reservas.get(i));
                return 1;
            }
        }
        return 0;
    }

    // EXIBINDO UMA RESERVA:
    public void printarUmaReserva(String cpf){ // FINALIZAR
        for(int i = 0 ; i < this.reservas.size() ; i++){
            if(this.reservas.get(i).getHospede().getCpf().equals(cpf)){
                System.out.println("========= RESERVA DE " + this.reservas.get(i).getHospede().getNome() + ": =========");
                System.out.println("CPF    : " + cpf);
                System.out.println("QUARTO : " + this.reservas.get(i).getQuarto().getNumero()); // Botar o quarto
                System.out.println("DATA DE CHECK-IN : " + this.reservas.get(i).getDataEntrada()); // Botar data de chegada
                System.out.println("DATA DE CHECK-OUT: " + this.reservas.get(i).getDataSaida()); // Botar data de saida
                System.out.println("PREÇO TOTAL: "); // Botar o preço total
            }
        }
    }

    // LISTANDO AS RESERVAS:
    public void listarReservas(){ // FINALIZAR
        System.out.println("===============| LISTAS DE RESERVAS |===============");
        for(int i = 0 ; i < this.reservas.size() ; i++){
            System.out.println("Nome: " + this.reservas.get(i).getHospede().getNome());
            System.out.println("CPF : " + this.reservas.get(i).getHospede().getCpf());
            System.out.println("QUARTO: " + this.reservas.get(i).getQuarto().getNumero()); // Botar o quarto
            System.out.println("DATA DE CHECK-IN : " + this.reservas.get(i).getDataEntrada()); // Botar data de chegada
            System.out.println("DATA DE CHECK-OUT: " + this.reservas.get(i).getDataSaida()); // Botar data de saida
            System.out.println("PREÇO TOTAL: "); // Botar o preço total
            System.out.println("====================================================");
        }
    }

    // VERFICANDO AS DATAS DISPONIVEIS:
    public Quarto verificarDatasReserva(LocalDate data_entrada, LocalDate data_saida){
        int cont1 = 0;
        int cont2 = 0;

        if(this.reservas.isEmpty() == true){
            return this.quartos.get(0);
        }

        for(int j = 0 ; j < this.quartos.size() - 3 ; j++){
            System.out.println("quarto " + (j + 1));
            cont1 = 0;
            cont2 = 0;
            for(int i = 0 ; i < this.reservas.size() ; i++){
                System.out.println("reserva " + (i + 1));
                if(this.quartos.get(j) == this.reservas.get(i).getQuarto()){
                    System.out.println("cont1++");
                    cont1++;
                    if((data_entrada.isAfter(this.reservas.get(i).getDataSaida()) && data_saida.isAfter(this.reservas.get(i).getDataSaida())) || (data_entrada.isBefore(this.reservas.get(i).getDataEntrada()) && data_saida.isBefore(this.reservas.get(i).getDataEntrada()))){
                        System.out.println("cont2++");
                        cont2++;
                    // return true;
                    }
                    if(cont1 == cont2){
                        //this.quartos.get(j).setDisponivel(false);
                        return this.quartos.get(j);
                    }
                }     
            }
        }
        return null;
    }
 
    public Quarto verificarDatasVipReserva(LocalDate data_entrada, LocalDate data_saida){
        int cont1 = 0;
        int cont2 = 0;
        if(this.quartos.isEmpty() == true){
            return this.quartos.get(0);
        }
        for(int j = 7 ; j < this.quartos.size() ; j++){
            cont1 = 0;
            cont2 = 0;
            for(int i = 0 ; i < this.reservas.size() ; i++){
                if(this.quartos.get(j) == this.reservas.get(i).getQuarto()){
                    cont1++;
                    if((data_entrada.isAfter(this.reservas.get(i).getDataSaida()) && data_saida.isAfter(this.reservas.get(i).getDataSaida())) || (data_entrada.isBefore(this.reservas.get(i).getDataEntrada()) && data_saida.isBefore(this.reservas.get(i).getDataEntrada()))){
                        cont2++;
                    // return true;
                    }
                    if(cont1 == cont2){
                        //this.quartos.get(j).setDisponivel(false);
                        return this.quartos.get(j);
                    }
                }     
            }
        }
        return null;
    }

    // MÉTODOS DE ADD:
    public void addReserva(Reserva reserva){ // MÉTODO PARA ADICIONAR RESERVAS
        this.reservas.add(reserva);
    }

    public void addQuarto(Quarto quarto){ // FUNÇÃO PARA ADICIONAR QUARTOS
        this.quartos.add(quarto);
    }

    public void addHospede(Hospede hospede){ // MÉTODO PARA ADICIONAR UM HÓSPEDE
        this.hospedes.add(hospede);
    }
}
