import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel(List<Quarto> quartos) {
        this.quartos = quartos;
        this.reservas = new ArrayList<>();
    }

    public void fazerReserva(Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida) {

    }
}
