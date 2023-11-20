import java.time.LocalDate;

public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    // ======= CONSTRUTOR =======
    public Reserva(Hospede hospede, Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida) {
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

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    // ======= MÉTODOS ======
    public int calcDias(){ // Método para calcular o número de dias
        int n = 0;
        return n;
    }
}
