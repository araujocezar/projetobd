package exceção;

public class LoginException extends Exception{
    
    public LoginException(){
        super("Senha incorreta!");
    }
}
