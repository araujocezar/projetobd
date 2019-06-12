package dados;
import entidade.pessoa.Hospede;
import entidade.pessoa.Funcionario;
import entidade.pessoa.Pessoa;
import java.util.ArrayList;
import java.util.Date;

/*Implementa a interface IRepositorioPessoa, viabilizando evolução do sistema. ArrayList único que armazena as pessoas
cadastradas, seja instância de Hóspede, seja instância de Funcionário.*/
public class RepositorioPessoa implements IRepositorioPessoa{

    private ArrayList<Pessoa> pessoas;
    private Database db;
	
    public RepositorioPessoa(){
	//pessoas = new ArrayList<>();
        Date data = new Date();

        this.db = new Database();
        this.db.adicionarFuncionario(new Funcionario("12345","admin",true,"123",data, 2000.00));
        this.db.adicionarHospede(new Hospede("000", "cliente", "3321", 0.00));
    
    }
    
    @Override
    public Funcionario buscarPessoa(String cpf){
        return this.db.buscarPessoa(cpf);
    }
    
    public Hospede buscarHospede(String cpf){
        return this.db.buscarHospede(cpf);
    }
    @Override
    public boolean existePessoa(Funcionario f){
        return this.db.existePessoa(f);
    }
    
    @Override
    public void adicionarFuncionario(Funcionario funcionario){
		this.db.adicionarFuncionario(funcionario);
    }
     public void adicionarHospede(Hospede hospede){
		this.db.adicionarHospede(hospede);
    }
    
    @Override
    public void removerFuncionario(Funcionario funcionario){
        this.db.removerFuncionario(funcionario);
    }
    
    @Override
    public ArrayList<Funcionario> getArray() {
        return this.db.listarFuncionario();
    }
    
    @Override
    public void atualizarFuncionario(Funcionario funcionario, boolean gerente){
        this.db.atualizarFuncionario(funcionario, gerente);
    }
    
    
     
     public void adicionarHospede(String cpf, String nome, String telefone,double debito){
         this.db.adicionarHospede(cpf, nome, telefone,debito);
     }
    
    @Override
    public void removerHospede(Hospede hospede){
        this.db.removerHospede(hospede);
    }
    
    @Override
    public ArrayList<Hospede> getArrayHospede() {
        return this.db.listarHospede();
    }
    
    @Override
    public void atualizarHospede(Hospede hospede, String telefone){
        this.db.atualizarHospede(hospede, telefone);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    /*
    @Override
    public ArrayList<Pessoa> getPessoas(){
        return pessoas;
    }
    
    //@Override
    //public void adicionarPessoa(Pessoa p){
    //	pessoas.add(p);
    //}
    
    
    
	
    @Override
    public void removerPessoa(Pessoa p){
	pessoas.remove(p);
    }
	
    @Override
    public void atualizarPessoa(String cpf, Pessoa p){
	Pessoa pessoa = this.buscarPessoa(cpf);
	pessoas.remove(pessoa);
	pessoas.add(p);
    }
    
    @Override
    public Pessoa buscarPessoa(String cpf){
	Pessoa p = null;
	for(int i = 0; i < pessoas.size(); i++){
            if(cpf.equals(pessoas.get(i).getCpf())){
		p = pessoas.get(i);
            }
	}
	return p;
    }
    
    @Override
    public boolean buscarPessoa(Pessoa p){
        for(int i = 0; i < pessoas.size(); i++){
            if(p.equals(pessoas.get(i))){
                return true;
            }
        }
        return false;
    }
           
    @Override    
    public String listarHospedes(){
        ArrayList<Hospede> hospedes = this.listaHospedes();
        String mensagem = "";
        for(int i = 0; i < hospedes.size(); i++){
            mensagem += hospedes.get(i).toString();
        }
        return mensagem;
    }
    /*
    @Override
    public String listarFuncionarios(){
        ArrayList<Funcionario> f = this.listaFuncionarios();
        String mensagem = "";
        for(int i = 0; i < f.size(); i++){
            mensagem += f.get(i).toString();
        }
        return mensagem;
    }
    
    
    É usado instanceof abaixo pra separar os hóspedes dos funcionários apenas pra print na GUI.
    
    private ArrayList<Hospede> listaHospedes(){
	ArrayList<Hospede> hospedes = new ArrayList<>();
	for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i) instanceof Hospede){
		hospedes.add((Hospede) pessoas.get(i));
            }
	}
	return hospedes;
    }
    
    private ArrayList<Funcionario> listaFuncionarios(){
	ArrayList<Funcionario> funcionarios = new ArrayList<>();
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i) instanceof Funcionario){
		funcionarios.add((Funcionario) pessoas.get(i));
            }
	}
	return funcionarios;
    }
    */

}
