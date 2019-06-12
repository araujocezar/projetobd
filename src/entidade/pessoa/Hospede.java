package entidade.pessoa;
import entidade.quarto.Quarto;
import java.util.Date;

//Subclasse, herda de Pessoa. Sobreescreve o método toString.
public class Hospede {
	
    private Quarto quarto;
    //Atributo atualizado com o valor referente a reserva, valor das diárias
    private double debito;
    private String telefone;
    private String cpf;
    private String nome;
    
    
    public Hospede(String cpf, String nome, String telefone,double debito){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
	this.debito = 0;
    }
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
	
    public Quarto getQuarto() {
	return quarto;
    }

    public void setQuarto() {
	quarto = null;
    }

    public double getDebito() {
	return debito;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public void setDebito(double debito){
        this.debito += debito;
    }
	
    public void zerarDebito(){
	debito = 0;
    }
    
    @Override
    public String toString(){
        return "Nome: " + nome + " - CPF: " + cpf+ " - Telefone: " + telefone + "\n";
    }
	
}
