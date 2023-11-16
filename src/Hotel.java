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

    public void removerHospede(String cpf){
        int i;
        for(i = 0 ; i < this.hospedes.size() ; i++){
            if(this.hospedes.get(i).getCpf().equals(cpf)){
                this.hospedes.remove(this.hospedes.get(i));
            }
        }
    }

    public void listarHospedes(){
        for(int i = 0 ; i < this.hospedes.size() ; i++){
            System.out.println("Nome: " + this.hospedes.get(i).getNome());
            System.out.println("CPF : " + this.hospedes.get(i).getCpf());
        }
    }

    public int removerReserva(String cpf){
        for(int i = 0 ; i < this.reservas.size() ; i++){
            if(this.reservas.get(i).getHospede().getCpf().equals(cpf)){
                this.reservas.remove(this.reservas.get(i));
                return 1;
            }
        }
        return 0;
    }

    public void printarUmaReserva(String cpf){ // FINALIZAR
        for(int i = 0 ; i < this.reservas.size() ; i++){
            if(this.reservas.get(i).getHospede().getCpf().equals(cpf)){
                System.out.println("========= RESERVA DE " + this.reservas.get(i).getHospede().getNome() + ": =========");
                System.out.println("CPF    : " + cpf);
                System.out.println("QUARTO : "); // Botar o quarto
                System.out.println("DATA DE CHECK-IN : "); // Botar data de chegada
                System.out.println("DATA DE CHECK-OUT: "); // Botar data de saida
                System.out.println("PREÇO TOTAL: "); // Botar o preço total
            }
        }
    }

    public void listarReservas(){ // FINALIZAR
        System.out.println("===============| LISTAS DE RESERVAS |===============");
        for(int i = 0 ; i < this.reservas.size() ; i++){
            System.out.println("Nome: " + this.reservas.get(i).getHospede().getNome());
            System.out.println("CPF : " + this.reservas.get(i).getHospede().getCpf());
            System.out.println("QUARTO: "); // Botar o quarto
            System.out.println("DATA DE CHECK-IN : "); // Botar data de chegada
            System.out.println("DATA DE CHECK-OUT: "); // Botar data de saida
            System.out.println("PREÇO TOTAL: "); // Botar o preço total
            System.out.println("====================================================");
        }
    }

    public boolean verificarDatasReserva(LocalDate data_entrada, LocalDate data_saida){
        
        for(int i = 0 ; i < this.reservas.size() ; i++){
            if((data_entrada.isAfter(this.reservas.get(i).getDataSaida()) && data_saida.isAfter(this.reservas.get(i).getDataSaida())) || (data_entrada.isBefore(this.reservas.get(i).getDataEntrada()) && data_saida.isBefore(this.reservas.get(i).getDataEntrada()))){
                return true;
            }
        }
        return false;    
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
