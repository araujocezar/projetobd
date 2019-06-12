package entidades;
import entidade.quarto.Quarto;
import entidade.pessoa.Hospede;
import java.util.Date;
import java.text.SimpleDateFormat;

//Representa a reserva de um quarto para determinado período de tempo
public class Reserva{
    
    private String numeroQuarto;
    private Date dataChegada;
    private Date dataSaida;
    private Quarto quarto;
    private Hospede hospede;
    private boolean checkInRealizado;
    private static int codigoReserva = 1;
    private final int codigo;
    private String cpfFuncionario;
    private String codigo_reserva;

    public String getCodigo_reserva() {
        return codigo_reserva;
    }

    public void setCodigo_reserva(String codigo_reserva) {
        this.codigo_reserva = codigo_reserva;
    }


    
    public Reserva( String codigo_reserva,boolean checkInRealizado, String cpfFuncionario, String numeroQuarto) {
        this.codigo_reserva = codigo_reserva;
        this.cpfFuncionario = cpfFuncionario;
        this.numeroQuarto = numeroQuarto;
        this.checkInRealizado = checkInRealizado;
        codigo = codigoReserva;

    }   
    
    
	
    public Reserva(Date dataChegada, Date dataSaida, Quarto quarto, Hospede hospede){
        this.dataChegada = dataChegada;
        this.dataSaida = dataSaida;
        this.hospede =  hospede;
	this.quarto = quarto;
        checkInRealizado = false;
        codigo = codigoReserva;
	codigoReserva++;
    }
    
        public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(String numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public boolean isCheckInRealizado() {
        return checkInRealizado;
    }

    public void setCheckInRealizado(boolean checkInRealizado) {
        this.checkInRealizado = checkInRealizado;
    }

    public Quarto getQuarto() {
	return quarto;
    }

    public void setQuarto(Quarto quarto) {
	this.quarto = quarto;
    }

    public int getCodigoReserva() {
	return codigo;
    }
            
    public Hospede getHospede(){
        return hospede;
    }
    
    public void setHospede(Hospede hospede){
        this.hospede = hospede;
    }
    
     public Date getDataChegada(){
        return dataChegada;
    }
    
    public void setDataChegada(Date dataChegada){
        this.dataChegada = dataChegada;
    }
    
    public Date getDataSaida(){
        return dataSaida;
    }
    
    public void setDataSaida(Date dataSaida){
        this.dataSaida = dataSaida;
    }
    
    public boolean getCheckInRealizado(){
        return checkInRealizado;
    }
    
    public void setCheckInRealizado(){
        checkInRealizado = true;
    }
    
    @Override
    public String toString() {
        String retorno = "";
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");	
        retorno += "Número do quarto: " + quarto.getNumeroQuarto() + "\n" +
                 "Código da Reserva: " + codigo + "\n" +
                 //"Responsável: " + hospede.getNome() + "\n" +
                 "Data de Entrada: " + formato.format(dataChegada) + "\n" + 
                 "Data de Saída: " + formato.format(dataSaida) + "\n\n";
		return retorno;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Reserva){
            Reserva reserva = (Reserva) obj;
            if(codigo == reserva.getCodigoReserva()){
                return true;
            }
        }
        return false;
    }
}
