package negócio.regras;

import entidade.pessoa.Pessoa;
import entidades.Reserva;
import exceção.PessoaInexistenteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Gabrielle Amorim
 */
public class NegócioRelatorio {
    /*
    private NegócioReserva reservas;
    private NegócioPessoa pessoas;
    
    public NegócioRelatorio(NegócioReserva reservas, NegócioPessoa pessoas){
        this.reservas = reservas;
        this.pessoas = pessoas;
    }
    
    public String reservasPorMes(int mes){
        ArrayList<Reserva> r = reservas.getReservas();
        String retorno = "Reservas referentes ao mês " + mes + "\n\n";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        int contador = 0;
        int lucro = 0;
        for(int i = 0; i < r.size(); i++){
            if(r.get(i).getDataChegada().getMonth() == mes - 1){
                contador++;
                lucro += r.get(i).getQuarto().getDiaria();
                retorno += "Data de Chegada: " + formato.format(r.get(i).getDataChegada()) +
                           " - Data de Saída: " + formato.format(r.get(i).getDataSaida()) +
                           " - Hóspede: " + r.get(i).getHospede().getNome() + "\n";
            }
        }
        retorno += "\nTotal: " + contador + " reserva(s)" + "\n" + "Lucro mensal: " + lucro;
        return retorno;
    }
    
    public String fichaHospedes(String cpf) throws PessoaInexistenteException{
        ArrayList<Reserva> listaReservas = reservas.getReservas();
        ArrayList<Pessoa> hospedes = pessoas.getPessoas();
        String retorno = "";
        Pessoa h = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        for(int i = 0; i < hospedes.size(); i++){
            if(hospedes.get(i).getCpf().equals(cpf)){
                h =  hospedes.get(i);
            }
        }
        if(h == null){
            throw new PessoaInexistenteException();
        }
        else{
            retorno += "Hóspede: " + h.getNome() + " - CPF: " + h.getCpf() + "\n\n";
            for(int i = 0; i < listaReservas.size(); i++){
                if(listaReservas.get(i).getHospede().getCpf().equals(cpf) && listaReservas.get(i).getCheckInRealizado()){
                    retorno += "Data de entrada: " + formato.format(listaReservas.get(i).getDataChegada()) +
                               " - Data de saída: " + formato.format(listaReservas.get(i).getDataSaida());
                }
            }
        }
        return retorno;
    }*/
}
