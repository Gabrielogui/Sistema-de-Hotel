import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;

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
    // LISTA DE QUARTOS:
    public List<Quarto> getQuartos() {
        return quartos;
    }
    public void setQuartos(ArrayList<Quarto> quartos) {
        this.quartos = quartos;
    }

    // LISTA DE RESERVAS:
    public List<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    // LISTA DE HÓSPEDES:
    public ArrayList<Hospede> getHospedes() {
        return hospedes;
    }
    public void setHospedes(ArrayList<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

    // ======= MÉTODOS =======
    
    // CONFERINDO O CPF:
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

    // CONFERIR ID:
    public boolean conferirId(int id){
        if(this.reservas.isEmpty() == true){
            return false;
        }
        for(int i = 0 ; i < this.hospedes.size() ; i++){
            if(this.reservas.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }

    // REMOVENDO HOSPEDE:
    public void removerHospede(String cpf){
        int i;
        for(i = 0 ; i < this.hospedes.size() ; i++){
            if(this.hospedes.get(i).getCpf().equals(cpf)){
                this.hospedes.remove(this.hospedes.get(i));
            }
        }
    }

    // LISTANDO HOSPEDE:
    public void listarHospedes(){
        System.out.println("|=======| HÓSPEDES |=======|");
        for(int i = 0 ; i < this.hospedes.size() ; i++){
            System.out.println("Nome: " + this.hospedes.get(i).getNome());
            System.out.println("CPF : " + this.hospedes.get(i).getCpf());
            System.out.println("----------------------------");
        }
    }

    // REMOVENDO RESERVA:
    public int removerReserva(String cpf){
        for(int i = 0 ; i < this.reservas.size() ; i++){
            if(this.reservas.get(i).getHospede().getCpf().equals(cpf)){
                this.reservas.remove(this.reservas.get(i));
                return 1;
            }
        }
        return 0;
    }

    // EXIBINDO UMA RESERVA:
    public void printarUmaReservaId(int id){ // FINALIZAR
        for(int i = 0 ; i < this.reservas.size() ; i++){
            if(this.reservas.get(i).getId() == id){
                System.out.println("========= RESERVA DE " + this.reservas.get(i).getHospede().getNome() + ": =========");
                System.out.println("ID     : " + this.reservas.get(i).getId());
                System.out.println("CPF    : " + this.reservas.get(i).getHospede().getCpf());
                System.out.println("QUARTO : " + this.reservas.get(i).getQuarto().getNumero()); // Botar o quarto
                System.out.println("TIPO   : " + this.reservas.get(i).getQuarto().getTipo());
                System.out.println("DATA DE CHECK-IN : " + this.reservas.get(i).getDataEntrada()); // Botar data de chegada
                System.out.println("DATA DE CHECK-OUT: " + this.reservas.get(i).getDataSaida()); // Botar data de saida
                System.out.println("PREÇO TOTAL  : " + this.reservas.get(i).getQuarto().calcPrecoTotal(this.reservas.get(i).calcDias())); // Botar o preço total
                System.out.println("TOTAL DE DIAS: " + this.reservas.get(i).calcDias());
            }
        }
    }

    public void printarUmaReservaCpf(String cpf){ // FINALIZAR
        for(int i = 0 ; i < this.reservas.size() ; i++){
            if(this.reservas.get(i).getHospede().getCpf().equals(cpf)){
                System.out.println("========= RESERVA DE " + this.reservas.get(i).getHospede().getNome() + ": =========");
                System.out.println("ID     : " + this.reservas.get(i).getId());
                System.out.println("CPF    : " + this.reservas.get(i).getHospede().getCpf());
                System.out.println("QUARTO : " + this.reservas.get(i).getQuarto().getNumero()); // Botar o quarto
                System.out.println("TIPO   : " + this.reservas.get(i).getQuarto().getTipo());
                System.out.println("DATA DE CHECK-IN : " + this.reservas.get(i).getDataEntrada()); // Botar data de chegada
                System.out.println("DATA DE CHECK-OUT: " + this.reservas.get(i).getDataSaida()); // Botar data de saida
                System.out.println("PREÇO TOTAL  : " + this.reservas.get(i).getQuarto().calcPrecoTotal(this.reservas.get(i).calcDias())); // Botar o preço total
                System.out.println("TOTAL DE DIAS: " + this.reservas.get(i).calcDias());
            }
        }
    }

    // LISTANDO AS RESERVAS:
    public void listarReservas(){ // FINALIZAR
        System.out.println("===============| LISTAS DE RESERVAS |===============");
        for(int i = 0 ; i < this.reservas.size() ; i++){
            System.out.println("Nome: " + this.reservas.get(i).getHospede().getNome());
            System.out.println("CPF : " + this.reservas.get(i).getHospede().getCpf());
            System.out.println("ID  : " + this.reservas.get(i).getId());
            System.out.println("QUARTO: " + this.reservas.get(i).getQuarto().getNumero()); // Botar o quarto
            System.out.println("TIPO  : " + this.reservas.get(i).getQuarto().getTipo());
            System.out.println("DATA DE CHECK-IN : " + this.reservas.get(i).getDataEntrada()); // Botar data de chegada
            System.out.println("DATA DE CHECK-OUT: " + this.reservas.get(i).getDataSaida()); // Botar data de saida
            System.out.println("PREÇO TOTAL  : " + this.reservas.get(i).getQuarto().calcPrecoTotal(this.reservas.get(i).calcDias())); // Botar o preço total
            System.out.println("TOTAL DE DIAS: " + this.reservas.get(i).calcDias());
            System.out.println("====================================================");
        }
    }

    // INICIALIZANDO AS PRIMEIRAS RESERVAS:
    public Quarto inicializando(){
        int sla;
        sla = this.reservas.size();
        return this.quartos.get(sla);
        //return null;
    }

    // EDITANDO RESERVA:
    public void editarReserva(LocalDate data_entrada, LocalDate data_saida, int id, int opVip){

        for(int i = 0 ; i < this.reservas.size() ; i++){
            if(this.reservas.get(i).getId() == id){
                this.reservas.get(i).setDataEntrada(data_entrada);
                this.reservas.get(i).setDataSaida(data_saida);
                if(opVip == 0){
                    this.reservas.get(i).setQuarto(this.verificarDatasReserva(data_entrada, data_saida));
                }else{
                    this.reservas.get(i).setQuarto(this.verificarDatasVipReserva(data_entrada, data_saida));
                }      
            }
        }
    }

    // GERANDO ID:
    public int gerandoId(){
        if(this.reservas.isEmpty() == true){
            return 1;
        }
        int id = this.reservas.size() + 1;
        return id;
    }

    // VERFICANDO AS DATAS DISPONIVEIS:
    public Quarto verificarDatasReserva(LocalDate data_entrada, LocalDate data_saida){
        int cont1 = 0;
        int cont2 = 0;

        if(this.reservas.isEmpty() == true){
            return this.quartos.get(0);
        }
        /* 
        if(this.reservas.size() <= 6){
            return this.inicializando();
        }*/
        
        for(int j = 0 ; j < this.quartos.size() - 3 ; j++){
            System.out.println("quarto " + (j + 1));
            cont1 = 0;
            cont2 = 0;
            for(int i = 0 ; i < this.reservas.size() ; i++){
                System.out.println("reserva " + (i + 1));
                if(this.quartos.get(j).getQtdeUsado() == 0){
                    this.quartos.get(j).interarUtilizado();
                    return this.quartos.get(j);
                }
                if(this.quartos.get(j) == this.reservas.get(i).getQuarto()){
                    System.out.println("cont1++");
                    cont1++;
                    if((data_entrada.isAfter(this.reservas.get(i).getDataSaida()) && data_saida.isAfter(this.reservas.get(i).getDataSaida())) || (data_entrada.isBefore(this.reservas.get(i).getDataEntrada()) && data_saida.isBefore(this.reservas.get(i).getDataEntrada()))){
                        System.out.println("cont2++");
                        cont2++;
                    // return true;
                    }
                    
                }/*else if(j == this.reservas.size()){
                    return this.quartos.get(j);
                }    */
            }
            if(cont1 == cont2){
                //this.quartos.get(j).setDisponivel(false);
                return this.quartos.get(j);
            }
        }
        return null;
    }
    /* 
    public QuartoVIP inicializandoVIP(){
        int sla;
        sla = this.reservas.size();
        return this.quartos.get(sla);
        //return null;
    }
    */
    
    // VERIFICAR DATAS DOS QUARTOS VIPS:
    public Quarto verificarDatasVipReserva(LocalDate data_entrada, LocalDate data_saida){
        int cont1 = 0;
        int cont2 = 0;

        if(this.reservas.isEmpty() == true){
            return this.quartos.get(7);
        }

       /* if(this.reservas.size() <= 10){
            return this.inicializandoVIP();
        }*/

        for(int j = 7 ; j < this.quartos.size() ; j++){
            cont1 = 0;
            cont2 = 0;
            for(int i = 0 ; i < this.reservas.size() ; i++){
                if(this.quartos.get(j).getQtdeUsado() == 0){
                    this.quartos.get(j).interarUtilizado();
                    return this.quartos.get(j);
                }
                if(this.quartos.get(j) == this.reservas.get(i).getQuarto()){
                    cont1++;
                    if((data_entrada.isAfter(this.reservas.get(i).getDataSaida()) && data_saida.isAfter(this.reservas.get(i).getDataSaida())) || (data_entrada.isBefore(this.reservas.get(i).getDataEntrada()) && data_saida.isBefore(this.reservas.get(i).getDataEntrada()))){
                        cont2++;
                    // return true;
                    }
                }     
            }
            if(cont1 == cont2){
                //this.quartos.get(j).setDisponivel(false);
                return this.quartos.get(j);
            }
        }
        return null;
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

    /*
    public double calcularValor(LocalDate data_inico, LocalDate data_fim){
        double qtdeDias = ChronoUnit.DAYS.between(data_inico, data_fim) + 1;
        return qtdeDias;
    } 
    */
}
