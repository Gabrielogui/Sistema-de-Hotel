import java.util.Date;

public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private Date dataEntrada;
    private Date dataSaida;

    public Reserva(Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

}
