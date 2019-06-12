package exceção;

public class ReservaInexistenteException extends Exception{

    public ReservaInexistenteException(){
	super("Reserva não cadastrada!");
    }
}
