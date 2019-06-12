
package exceção;

public class DataInvalidaException extends Exception{
    
    public DataInvalidaException(){
        super("Por favor, digite uma data válida!");
    }
}
