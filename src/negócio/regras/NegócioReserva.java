package negócio.regras;
import dados.RepositorioReserva;
import dados.IRepositorioReserva;
import entidades.Reserva;
import java.util.ArrayList;
import exceção.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NegócioReserva {
	
    private IRepositorioReserva repReserva;
	
    public NegócioReserva(IRepositorioReserva repReserva){
        this.repReserva = repReserva;
    }
    
    public ArrayList<Reserva> getReservas(){
        return repReserva.listaReservas();
    }
    
    public Reserva buscarReserva(String codigo){
        return repReserva.buscarReserva(codigo);
    }
    
    
    public Reserva buscarReserva(int codigo){
        return repReserva.buscarReserva(codigo);
    }
    
    
    public boolean existeReserva(Reserva reserva){
        return repReserva.existeReserva(reserva);
    }
    
    public void removerReserva(Reserva reserva) throws ReservaInexistenteException{
        boolean x = this.existeReserva(reserva);
        if(x == true){
            repReserva.removerReserva(reserva);
        }
        else{
            throw new ReservaInexistenteException();
        }
    }
   
   
    
    
    /*
    Comparação de datas. Casos onde há a tentativa de cadastro de uma reserva onde há choque de datas pra o mesmo quarto,
    é lançada uma exceção; Data de saída antes da data de entrada, é lançada exceção.
    Ao receber a reserva no parâmetro, é verificado se esse quarto, que está encapsulado na reserva, já possui alguma reserva
    dentro do ArrayList, caso possua, uma variável temporária salva as informações e faz a comparação das datas. É percorrido
    todo o ArryList e há a mudança do valor da flag "realizarReserva", com base nela, ou a reserva é cadastrada ou é lançada
    uma exceção de data indisponível.
    */
    /*
    public double reservarQuarto(Reserva reserva) throws PessoaInexistenteException, QuartoInexistenteException, ReservaExistenteException, DataIndisponivelException, DataInvalidaException{
        ArrayList<Reserva> aux = repReserva.listaReservas(); //ArrayList de reservas
        Reserva auxiliar; //Objeto auxiliar, usado pra comparações
        boolean realizarReserva = true; //Flag alterada quando dá choque de reservas para um mesmo quarto
        Date dataAtual = new Date(); //pega a data do sistema        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); //formatador
        Calendar c = Calendar.getInstance(); //pega a data do sistema
	String dataSistema = df.format(c.getTime()); //transforma a data do sistema em string
        String comparar1 = df.format(reserva.getDataChegada()); //transforma em string a data de chegada, pra comparar
        String comparar2 = df.format(reserva.getDataSaida()); //transforma em string a data de saída, pra comparar        
        if(reserva.getHospede() == null){
            throw new PessoaInexistenteException();
        }
        else if(reserva.getQuarto() == null){
            throw new QuartoInexistenteException();
        }
        else if(this.existeReserva(reserva) == true){
            throw new ReservaExistenteException();
        }
        else if((reserva.getDataChegada().before(dataAtual) && !comparar1.equals(dataSistema))){
            throw new DataInvalidaException(); 
        }
        else if(reserva.getDataSaida().before(dataAtual) && !comparar2.equals(dataSistema)){
            throw new DataInvalidaException();
        }
        else if(reserva.getDataSaida().before(reserva.getDataChegada())){
            throw new DataInvalidaException();
        }
        else{
            for(int i = 0; i < aux.size(); i++){
                if(reserva.getQuarto().getNumeroQuarto().equals(aux.get(i).getQuarto().getNumeroQuarto())){
                    auxiliar = aux.get(i);
                    if(reserva.getDataChegada().after(auxiliar.getDataChegada()) && reserva.getDataChegada().before(auxiliar.getDataSaida())){
                        realizarReserva = false;
                    }
                    else if(reserva.getDataChegada().before(auxiliar.getDataChegada()) && reserva.getDataSaida().before(auxiliar.getDataChegada())){
                        realizarReserva = true;
                    }
                    else if((auxiliar.getDataSaida().after(reserva.getDataChegada()))){
                        realizarReserva = false;
                    }
                }
            }
            if(realizarReserva == true){
                repReserva.adicionarReserva(reserva);
                double qntdDias = (reserva.getDataSaida().getTime() - reserva.getDataChegada().getTime())/(1000*60*60*24);
                double diarias = reserva.getQuarto().configurarDiaria(reserva.getDataChegada().getMonth()) * qntdDias;
                if(reserva.getHospede().getDebito() == 0){
                    reserva.getHospede().setDebito(diarias);
                }
                return reserva.getHospede().getDebito();
            }
            else{
                throw new DataIndisponivelException();
            }
        }
    }
    
    /*
    Trabalha recebendo uma reserva no parâmetro. É feita a atualização do hóspede que agora se encontra como responsável
    por aquele quarto, anteriormente era "null"; É calculado a quantidade de dias da reserva com base na data de entrada
    e de saída, multiplicado pelo valor da diária e feita a atualização do atributo de débito do hóspede; Há a mudança 
    da flag ocupado e a mudança da flag de check-in relizado da reserva. Caso o usuário tente realizar o check-in do quarto 
    mais de uma vez, uma exceção é lançada.
    */
    public void checkIn(String numero){
        repReserva.checkIn(numero);
    }
    
    public void checkOut(String numero){
        repReserva.checkOut(numero);
    }
    
    
    public void checkInA(Reserva reserva) throws ReservaInexistenteException, CheckInRealizadoException{
	if(reserva == null){
            throw new ReservaInexistenteException();
	}
        else if(reserva.getQuarto().getOcupado()){
            throw new CheckInRealizadoException();
        }
	else{
            reserva.getQuarto().setHospede(reserva.getHospede());
            reserva.getQuarto().ocupar();
            reserva.setCheckInRealizado();
        }
    }
}