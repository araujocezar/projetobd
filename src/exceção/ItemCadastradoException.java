package exceção;

public class ItemCadastradoException extends Exception{

    public ItemCadastradoException(){
	super("Opção já cadastrada!");
    }
}
