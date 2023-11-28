import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    public double calcDias(){ // Método para calcular o número de dias
        double qtdeDias = ChronoUnit.DAYS.between(this.dataEntrada, this.dataSaida) + 1;
        return qtdeDias;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "ID = " + this.id +
                ", Hóspede = " + this.hospede.getNome() + // Adiciona o nome do hóspede
                ", Quarto = " + this.quarto.getNumero() +
                ", Tipo = " + this.getQuarto().getTipo() +
                ", Check-IN = " + this.dataEntrada +
                ", Check-OUT = " + this.dataSaida +
                ", Preço = " + this.quarto.calcPrecoTotal(this.calcDias()) +
                ", Total de dias = " + this.calcDias() +
                '}';
    }
}
