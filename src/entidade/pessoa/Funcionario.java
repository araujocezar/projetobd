package entidade.pessoa;
import java.util.Date;

//Subclasse, herda de pessoa. Possui apenas getters e setters e há a sobreescrita de toString.
public class Funcionario extends Pessoa {
    
    private double salario;
    private String senha;
    //Flag que diz se o funcionário cadastrado é um gerente ou não.
    private boolean gerente;
        
    public Funcionario(String nome, String cpf, Date dataCadastro, double salario, String senha, boolean gerente){
	super(nome, cpf, dataCadastro);
        this.salario = salario;
        this.senha = senha;
        this.gerente = gerente;
    }
    
     public Funcionario(String cpf, String nome,boolean Gerente, String senha, Date dataCadastro, double salario){
	super(cpf, nome, dataCadastro);
        this.salario = salario;
        this.senha = senha;
        this.gerente = gerente;
    }

    
        
    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }
    
    public boolean getGerente(){
        return gerente;
    }
    
    public void setGerente(boolean gerente){
        this.gerente = gerente;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }
    public double getSalario(){
        return salario;
    }
    
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + ", CPF: " + this.getCpf() + ", Senha: " + this.getSenha();
    }
	
}
