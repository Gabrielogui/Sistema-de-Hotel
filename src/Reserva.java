import java.time.LocalDate;

public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private int id;

    // ======= CONSTRUTOR =======
    public Reserva(Hospede hospede, Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida, int id) {
        this.hospede = hospede;
        this.quarto  = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida   = dataSaida;
        this.id = id;
    }

    public Reserva(Hospede hospede, QuartoVIP quartovip, LocalDate dataEntrada, LocalDate dataSaida, int id) {
        this.hospede = hospede;
        this.quarto  = quartovip;
        this.dataEntrada = dataEntrada;
        this.dataSaida   = dataSaida;
        this.id = id;
    }

    // ======= GETS E SETS =======
    // HOSPEDE:
    public Hospede getHospede() {
        return hospede;
    }
    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    // QUARTO:
    public Quarto getQuarto() {
        return quarto;
    }
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    // DATA DE CHECK-IN:
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    // DATA DE CHECK-OUT:
    public LocalDate getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    // ID:
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    // ======= MÉTODOS ======
    public int calcDias(){ // Método para calcular o número de dias
        int n = 0;
        return n;
    }
}
