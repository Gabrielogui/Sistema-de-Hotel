import java.util.Date;

public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private Date dataEntrada;
    private Date dataSaida;

    // ======= CONSTRUTOR =======
    public Reserva(Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    // ======= GETS E SETS =======
    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    // ======= MÉTODOS ======
    public int calcDias(){ // Método para calcular o número de dias
        int n = 0;
        return n;
    }
}
