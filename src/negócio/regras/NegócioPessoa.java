package negócio.regras;
import dados.RepositorioPessoa;
import dados.IRepositorioPessoa;
import entidade.pessoa.Funcionario;
import entidade.pessoa.Hospede;
import entidade.pessoa.Pessoa;
import exceção.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NegócioPessoa {
    
    private IRepositorioPessoa repPessoa;
    
    
    public NegócioPessoa(IRepositorioPessoa repPessoa){
	this.repPessoa = repPessoa;
    }
	
    public boolean existePessoa(Funcionario func){
	return repPessoa.existePessoa(func);
    }
	
    public Funcionario buscarPessoa(String cpf){
	return repPessoa.buscarPessoa(cpf);
    }
    
    public Hospede buscarHospede(String cpf){
        return repPessoa.buscarHospede(cpf);
    }
    
    //Não permite que sejam cadastrados datas que já passaram, utiliza como base a data do sistema.
     public void adicionarHospede(Hospede h) throws PessoaExistenteException, DataInvalidaException{
        repPessoa.adicionarHospede(h);
    }
     
    public void adicionarHospede(String cpf, String nome, String telefone,double debito)throws PessoaExistenteException, DataInvalidaException{
        repPessoa.adicionarHospede(cpf, nome, telefone,debito);
    }
   
    
    public void adicionarFuncionario(Funcionario f) throws PessoaExistenteException, DataInvalidaException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //formatador
        Calendar c = Calendar.getInstance(); //pega a data do sistema
	String dataFormatada = df.format(c.getTime()); //transforma a data do sistema em string
        String comparar = df.format(f.getDataCadastro()); //transforma em string a data do objeto recebido, pra comparar
        Date dataAtual = new Date(); //pega a data do sistema
	boolean x = repPessoa.existePessoa(f);
	if(x){
            throw new PessoaExistenteException();
        }
        else if((f.getDataCadastro().before(dataAtual) && !comparar.equals(dataFormatada)) || f.getDataCadastro().after(dataAtual)){
            throw new DataInvalidaException();
        }
	else{
            repPessoa.adicionarFuncionario(f);
	}
    }
    
    public void removerHospede(Hospede h) throws PessoaInexistenteException{
	repPessoa.removerHospede(h);
    }
    
    public void atualizarHospede(Hospede h, String telefone){
        repPessoa.atualizarHospede(h, telefone);
    }
   
	
    public void removerFuncionario(Funcionario f) throws PessoaInexistenteException{
	boolean x = this.existePessoa(f);
	if(x == false){
            throw new PessoaInexistenteException();
        }
	else{
            repPessoa.removerFuncionario(f);
	}
    }
    	
    public void atualizarFuncionario (Funcionario f, boolean gerente) throws PessoaInexistenteException, PessoaExistenteException{
	Funcionario func = this.buscarPessoa(f.getCpf());
        boolean x = this.existePessoa(f);
	if(func == null){
            throw new PessoaInexistenteException();
	}
        else if(x){
            throw new PessoaExistenteException();
        }
	else{
            repPessoa.atualizarFuncionario(f,gerente);
	}
    }
        
    public ArrayList<Hospede> getArrayHospede(){
        return repPessoa.getArrayHospede();
    }
    
    public ArrayList<Funcionario> getArray(){
        return repPessoa.getArray();
    }
    
  
    
    /*Faz a busca no ArrayList e verifica se há um funcionário com a senha recebida no parâmetro. Na GUI é feita a verificação
    se esse funcionário é um gerente e daí é chamada a tela correspondente.
    */
    public Funcionario login(String cpf, String senha) throws PessoaInexistenteException, LoginException{
        Funcionario funcionario = this.buscarPessoa(cpf);
        
        if(funcionario == null){
            throw new PessoaInexistenteException();
        }
        else{
            if(funcionario.getSenha().equals(senha)){
                return funcionario;
            }
            else{
                throw new LoginException();
            }
        }
    }
}
