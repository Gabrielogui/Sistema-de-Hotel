import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    // ======= CONSTRUTOR =======
    public Hotel(List<Quarto> quartos) {
        this.quartos = quartos;
        this.reservas = new ArrayList<>();
    }

    // ======= GETS E  SETS =======
    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // ======= MÉTODOS =======
    public void fazerReserva(Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida) {
        Reserva reserva = new Reserva(hospede, quarto, dataEntrada, dataSaida);
        addReserva(reserva);
    }

    public void addReserva(Reserva reserva){ // MÉTODO PARA ADICIONAR RESERVAS
        this.reservas.add(reserva);
    }

    public void addQuarto(Quarto quarto){ // FUNÇÃO PARA ADICIONAR QUARTOS
        this.quartos.add(quarto);
    }
}
