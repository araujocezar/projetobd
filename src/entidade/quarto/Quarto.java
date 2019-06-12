package entidade.quarto;

import entidade.pessoa.Hospede;

public class Quarto{
	
    private String numeroQuarto;
    private int quantidadePessoas;
    private double diaria;
    private boolean ocupado;
    private double consumação;
    private Hospede hospedeResponsavel;
    private double preçoQuarto;
    private boolean isPremium;
    
    public Quarto(String numeroQuarto, int quantidadePessoas, double diaria, boolean ocupado, double consumacao, boolean isPremium){
        this.numeroQuarto = numeroQuarto;
        this.quantidadePessoas = quantidadePessoas; 
        this.diaria = diaria;
        this.ocupado =ocupado;
        this.consumação = consumacao;
        this.isPremium = isPremium;
        
    }
    
	
    public Quarto(String numeroQuarto, int quantidadePessoas){
        this.numeroQuarto = numeroQuarto ;
	this.quantidadePessoas = quantidadePessoas;
        ocupado = false;
	consumação = 0;
    }
    
    

    public boolean isIsPremium() {
        return isPremium;
    }
    
    public boolean getIsPremium(){
        return isPremium;
    }
    
    public void setIsPremium(boolean premium){
        this.isPremium = premium;
    }
    
    public String getNumeroQuarto() {
	return numeroQuarto;
    }

    public void setNumeroQuarto(String numeroQuarto) {
	this.numeroQuarto = numeroQuarto;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
	this.quantidadePessoas = quantidadePessoas;
    }

    public double getDiaria() {
	return diaria;
    }

    public void setDiaria(double diaria) {
	this.diaria = diaria;
    }
	
    public boolean getOcupado(){
	return ocupado;
    }
	
    public void ocupar(){
	ocupado = true;
    }
	
    public void desocupar(){
        ocupado = false;
    }

    public Hospede getHospede() {
	return hospedeResponsavel;
    }
	
    public void setHospede(Hospede hospede){
	hospedeResponsavel = hospede;
    }

    public double getConsumação(){
	return consumação;
    }
	
    public void setConsumo(double valor){
	consumação += valor;
    }
	
    public void zerarConsumo(){
	consumação = 0;
    }
    
    public double getPreçoQuarto(){
        return preçoQuarto;
    }
    
    public void setPreçoQuarto(double preçoQuarto){
        this.preçoQuarto = preçoQuarto;
    }
    
    //Recebe um valor em percentual e aumenta proporcionalmente o preço dos quartos já cadastrados.
    public void atualizarCategoria(int porcentagem){
        double acrescimo = porcentagem * getPreçoQuarto();
        double novoValor = getPreçoQuarto() + acrescimo;
        setPreçoQuarto(novoValor);
    }
             
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Quarto){
            Quarto quarto = (Quarto) obj;
            if(numeroQuarto.equals(quarto.getNumeroQuarto())){
                return true;
            }
        }
        return false;
    }
}
