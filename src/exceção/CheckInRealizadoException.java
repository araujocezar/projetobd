package exceção;

public class CheckInRealizadoException extends Exception {
    
    public CheckInRealizadoException(){
        super("O check-in desse quarto já foi realizado!");
    }
}
