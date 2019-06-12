package exceção;

public class PacoteInexistenteException extends Exception{
    
    public PacoteInexistenteException(){
        super("Pacote não cadastrado!");
    }
}
