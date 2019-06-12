package entidades;

public class ServicoQuarto {
    
    private int idServico;
    private String nome;
    private double preço;

    public ServicoQuarto(int idServico, String nome, double preço){
	this.idServico =idServico;
        this.nome = nome;
	this.preço = preço;
    }
    
    
    
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public double getPreço() {
	return preço;
    }

    public void setPreço(double preço) {
	this.preço = preço;
    }
   
   
    @Override
    public boolean equals(Object obj){
        if(obj instanceof ServicoQuarto){
            ServicoQuarto s = (ServicoQuarto) obj;
            if(nome.equals(s.getNome()) && preço == s.getPreço()) {
                 return true;
            }
        }
        return false;
    }
}
