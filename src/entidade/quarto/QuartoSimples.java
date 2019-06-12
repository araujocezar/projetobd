package entidade.quarto;

public class QuartoSimples extends Quarto{
    
       
    public QuartoSimples(String numeroQuarto, int quantidadePessoas){
        super(numeroQuarto, quantidadePessoas);
        setPreçoQuarto(50);
    }


    public double configurarDiaria(int mes) {
        double valor;
        if(mes == 0 || mes == 6 || mes == 11){
            valor = getPreçoQuarto() * getQuantidadePessoas() * 2;
            setDiaria(valor);
        }
        else{
            valor = getPreçoQuarto() * getQuantidadePessoas() * 2;
            setDiaria(valor);
        } 
        return valor;
    }
    
    @Override
    public String toString(){
        return "Quarto Simples --- " +
               "Número: " + getNumeroQuarto() + " - " +
               "Quantidade máxima de pessoas: " + getQuantidadePessoas() + "\n";
    }
}
