package exceção;

public class ReservaExistenteException extends Exception{

    public ReservaExistenteException(){
	super("Código da reserva já cadastrado!");
    }
}
