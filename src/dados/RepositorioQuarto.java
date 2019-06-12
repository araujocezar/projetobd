package dados;
import entidade.quarto.Quarto;
import java.util.ArrayList;

//Implementa a interface IRepositorioQuarto, viabilizando evolução do sistema. CRUD básico.
public class RepositorioQuarto implements IRepositorioQuarto{

    private ArrayList<Quarto> quartos;
    private Database db;
	
    public RepositorioQuarto(){
        quartos = new ArrayList<>();
        this.db = new Database();
        this.db.adicionarQuarto(new Quarto("100",4,200.00,false,0.00,false));
    }
    
    @Override
    public void adicionarQuarto(Quarto q){
        this.db.adicionarQuarto(q);
    }
    
    public Quarto buscarQuarto(String numero){
        return this.db.buscarQuarto(numero);
    }
    
    public boolean existeQuarto(Quarto q){
        return this.existeQuarto(q);
    }
    @Override
    public void removerQuarto(Quarto q){
        this.db.removerQuarto(q);
    }
    
    @Override
    public ArrayList<Quarto> getArray(){
       return this.db.listarQuarto();
    } 
    
    
    @Override
    public void atualizarQuarto(Quarto q, boolean isPremium){
        this.db.atualizarQuarto(q, isPremium);
        
    }
    
    /*
    @Override
    public ArrayList<Quarto> getQuartos(){
	return quartos;
    }
	
    @Override
    public void adicionarQuarto(Quarto q){
	quartos.add(q);
    }
	
    @Override
    public void removerQuarto(Quarto q){
	quartos.remove(q);
    }
	
    @Override
    public void atualizarQuarto(String numero, Quarto quarto){
	Quarto q = this.buscarQuarto(numero);
	quartos.remove(q);
        quartos.add(quarto);
    }
	
    @Override
    public Quarto buscarQuarto(String numeroQuarto){
	Quarto q = null;
	for(int i = 0; i < quartos.size(); i++){
            if(quartos.get(i).getNumeroQuarto().equals(numeroQuarto)){
                q = quartos.get(i);
            }
	}
	return q;
    }
    
    //Faz a chamada de equals, que foi sobreescrito em Quarto. Polimorfismo.
    @Override
    public boolean buscarQuarto(Quarto q){
        for(int i = 0; i < quartos.size(); i++){
            if(q.equals(quartos.get(i))){
                return true;
            }
        }
        return false;
    }
	
    //Faz a chamada de toString. Trabalha em cima do boolean ocupado, que é atualizado no check-in e no check-out.
    @Override
    public String quartosDisponiveis(){
        String x = "Quartos Disponíveis:" + "\n\n";
        for(int i = 0; i < quartos.size(); i++){
            if(quartos.get(i).getOcupado() == false){
                x += quartos.get(i).toString();
            }
        }
        return x;
    }

    @Override
    public void atualizarCategoria(int porcentagem){
        for(int i = 0; i < quartos.size(); i++){
            quartos.get(i).atualizarCategoria(porcentagem);
        }
    }
    
    //Faz a chamada de toString. Trabalha em cima do boolean ocupado, que é atualizado no check-in e no check-out.
    @Override
    public String quartosOcupados(){
        String x = "Quartos Ocupados: " + "\n\n";
        for(int i = 0; i < quartos.size(); i++){
            if(quartos.get(i).getOcupado()){
                x += quartos.get(i).toString();
            }
        }
        return x;
    }
    
    @Override
    public String infoCheckOut(Quarto quarto){
        double debito = quarto.getConsumação() + quarto.getHospede().getDebito();       
        String x = "Quarto número: " + quarto.getNumeroQuarto() + "\n" +
                   "Hóspede: " + quarto.getHospede().getNome() + "\n" +
                   "Débito: R$: " + debito;
        return x;
    }
    */
}
