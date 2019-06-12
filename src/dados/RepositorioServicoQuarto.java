package dados;
import entidades.ServicoQuarto;
import java.util.ArrayList;

//Implementa IRepositorioServicoQuarto, viabilizando evolução do sistema. CRUD básico.
public class RepositorioServicoQuarto implements IRepositorioServicoQuarto {

    private ArrayList<ServicoQuarto> lista;
    private Database db;
	
    public RepositorioServicoQuarto(){
	lista = new ArrayList<>();
        this.db = new Database();
    }
    
    public void adicionarServico(ServicoQuarto s){
		this.db.adicionarServico(s);
    }
    
    @Override
    public void removerServico(ServicoQuarto s){
        this.db.removerServico(s);
    }
    
    @Override
    public ArrayList<ServicoQuarto> getArray() {
        return this.db.listarServico();
    }
    
    public void atualizarServico(ServicoQuarto s, double preco){
        this.db.atualizarServico(s, preco);
    }
    
    public boolean existeServico(ServicoQuarto s){
        return this.db.existeServico(s);
    }
    
    public ServicoQuarto buscarServico(int id){
        return this.db.buscarServico(id);
    }
    /*
    @Override
    public void adicionarOpcao(ServicoQuarto h){
        lista.add(h);
    }
	
    @Override
    public void removerOpcao(ServicoQuarto h){
	lista.remove(h);
    }
    
    @Override
    public ServicoQuarto buscarOpcao(int código){
	ServicoQuarto x = null;
	for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCódigo() == código){
		x = lista.get(i);
            }
	}
	return x;
    }
    
    @Override
    public void atualizarOpcao(int cod, ServicoQuarto h){
	ServicoQuarto r = this.buscarOpcao(cod);
	int indice = lista.indexOf(r);
	lista.set(indice, h);
    }
    
    //Chamada de equals.
    @Override
    public boolean existeOpcao(ServicoQuarto h){
        for(int i = 0; i < lista.size(); i++){
            if(h.equals(lista.get(i))){
                return true;
            }
        }
        return false;
    }
    
    //Chamada de toString.
    @Override
    public String listarOpcoes(){
        String x = "Opções: " + "\n\n";
	for(int i = 0; i < lista.size(); i++){
            x += lista.get(i).toString();
	}
	return x;
    }*/
    
}
