import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class teste {

    public static void main(String[] args) {
        // Definindo duas datas
        LocalDate data1 = LocalDate.of(2023, 11, 1);
        LocalDate data2 = LocalDate.of(2023, 11, 7);

        // Calculando a diferença de dias entre as duas datas
        long diferencaDias = ChronoUnit.DAYS.between(data1, data2) + 1;
        
        // Exibindo a diferença de dias
        System.out.println("Diferença de dias: " + diferencaDias);
    }
}

