package dados;

import entidade.pessoa.Funcionario;
import entidade.pessoa.Hospede;
import entidade.pessoa.Pessoa;
import java.util.ArrayList;
import java.util.Date;

public interface IRepositorioPessoa {
    //BANCO DE DADOS
    void adicionarFuncionario(Funcionario f);
    //void adicionarFuncionario(String nome, String cpf, Date dataCadastro, double salario, String senha, boolean gerente);

    void removerFuncionario(Funcionario f);
    ArrayList<Funcionario> getArray(); 
    void atualizarFuncionario(Funcionario f, boolean gerente);
    Funcionario buscarPessoa(String cpf);
    boolean existePessoa(Funcionario f);
    
    void adicionarHospede(Hospede h);
    void adicionarHospede(String cpf, String nome, String telefone, double debito);

    Hospede buscarHospede(String cpf);
    void removerHospede(Hospede h);
    ArrayList<Hospede> getArrayHospede(); 
    void atualizarHospede(Hospede h, String telefone);
    
    
    
    
    //
    
    
    
    
    
    
    
    
    
    //ArrayList<Pessoa> getPessoas();
    //void adicionarPessoa(Pessoa p);
    //void removerPessoa(Pessoa p);
    //void atualizarPessoa(String cpf, Pessoa p);
    //Pessoa buscarPessoa(String cpf);
    //boolean buscarPessoa(Pessoa p);
    //String listarHospedes();
    //String listarFuncionarios();    
    
}
