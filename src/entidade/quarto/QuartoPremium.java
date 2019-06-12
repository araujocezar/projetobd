package entidade.quarto;

public class QuartoPremium extends Quarto{
    
    private int tipo;
    
    public QuartoPremium(String numeroQuarto, int quantidadePessoas, int tipo){
        super(numeroQuarto, quantidadePessoas);
        this.tipo = tipo;
    }
    
    public int getTipo(){
        return tipo;
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    /*
    Existem dois tipos de quarto, quarto simples e quarto premium. Os quartos da categoria premium são subdividos em tipo,
    variando assim o valor de cada um deles de acordo com seu tipo.
    */
   // @Override
    public double configurarDiaria(int mes) {
        double valor = 0;
        switch (tipo) {
            case 1:
                setPreçoQuarto(100);
                break;
            case 2:
                setPreçoQuarto(150);
                break;
            case 3:
                setPreçoQuarto(200);
                break;
            default:
                break;
        }
        if(mes == 0 || mes == 6 || mes == 11){
            valor = getPreçoQuarto() * getQuantidadePessoas() * 2;   
            setDiaria(valor);
        }
        else{
            valor = getPreçoQuarto() * getQuantidadePessoas();   
            setDiaria(valor);
        }
        return valor;
    }

    @Override
    public String toString(){
        return "Quarto Premium --- " +
               "Número: " + getNumeroQuarto() + " - " +
               "Quantidade máxima de pessoas: " + getQuantidadePessoas() + "\n";
    }
}
