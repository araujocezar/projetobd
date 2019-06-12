package dados;
import java.util.ArrayList;
import entidades.Reserva;

public interface IRepositorioReserva {
    
    void adicionarReserva(Reserva r);
    void removerReserva(Reserva r);
    ArrayList<Reserva> listaReservas();
    Reserva buscarReserva(String codigo);
    Reserva buscarReserva(int codigo);

    boolean existeReserva(Reserva r);
    
    void checkIn(String numero);
    void checkOut(String numero);
    

    
    
        
    
    
    
    /*
    ArrayList<Reserva> listaReservas();
    void adicionarReserva(Reserva r);
    void removerReserva(Reserva r);
    boolean existeReserva(Reserva x);
    void atualizarReserva(int cod, Reserva reserva);
    String listarReservas();
    Reserva buscarReserva(int codigo);
    */

}
