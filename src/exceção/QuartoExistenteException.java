package exceção;

public class QuartoExistenteException extends Exception{

    public QuartoExistenteException(){
	super("Quarto já cadastrado!");
    }
}
