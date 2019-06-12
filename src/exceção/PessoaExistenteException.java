package exceção;

public class PessoaExistenteException extends Exception{

    public PessoaExistenteException(){
	super("CPF já cadastrado!");
    }
}
