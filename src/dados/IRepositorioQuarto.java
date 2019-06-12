package dados;

import entidade.quarto.Quarto;
import java.util.ArrayList;


public interface IRepositorioQuarto {
    
    void adicionarQuarto(Quarto q);
    void removerQuarto(Quarto q);
    ArrayList<Quarto> getArray();
    void atualizarQuarto(Quarto q, boolean isPremium);
    boolean existeQuarto(Quarto q);
    Quarto buscarQuarto(String numero);
    

    
    
    /*
    ArrayList<Quarto> getQuartos();
    void adicionarQuarto(Quarto q);
    void removerQuarto(Quarto q);
    void atualizarQuarto(String numero, Quarto quarto);
    Quarto buscarQuarto(String numeroQuarto);
    boolean buscarQuarto(Quarto q);
    String quartosDisponiveis();
    void atualizarCategoria(int porcentagem);
    String quartosOcupados();
    String infoCheckOut(Quarto quarto);
    */ 
}
