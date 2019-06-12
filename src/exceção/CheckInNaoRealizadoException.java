package exceção;

public class CheckInNaoRealizadoException extends Exception{
    
    public CheckInNaoRealizadoException(){
        super("Esse quarto não possui hóspede!");
    }
}
