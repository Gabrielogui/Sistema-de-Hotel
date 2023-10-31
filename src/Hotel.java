import java.util.ArrayList;
import java.util.List;
import java.util.Date;

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
            if(this.hospedes.get(i).getCpf() == cpf){
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
