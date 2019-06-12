package exceção;

public class PacoteExistenteException extends Exception{
    
    public PacoteExistenteException(){
        super("Pacote já cadastrado!");
    }
}
