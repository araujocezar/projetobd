package entidade.pessoa;

import java.util.Date;

/*Superclasse pessoa, definida como abstrata para não ser instanciada. Herdada por Hóspede e Funcionário. 
Possui apenas métodos getters e setters e sobreescreve toString e equals.*/
public abstract class Pessoa {

    private String nome;
    private String cpf;
    private Date dataCadastro;
	
    public Pessoa(String cpf, String nome, Date dataCadastro){
        this.cpf = cpf;
        this.nome = nome;
	this.dataCadastro = dataCadastro;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public Date getDataCadastro() {
	return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
	this.dataCadastro = dataCadastro;
    }
	
    @Override
    public String toString(){
        return "Nome: " + this.nome + " - CPF: " + this.cpf + "\n";
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Pessoa){
            Pessoa pessoa = (Pessoa) obj;
            if(cpf.equals(pessoa.getCpf())){
                return true;
            }
        }
        return false;
    }
}
