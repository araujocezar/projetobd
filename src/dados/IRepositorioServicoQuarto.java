package dados;

import entidade.pessoa.Funcionario;
import entidades.ServicoQuarto;
import java.util.ArrayList;

public interface IRepositorioServicoQuarto {
    
    void adicionarServico(ServicoQuarto s);
    void removerServico(ServicoQuarto s);
    ArrayList<ServicoQuarto> getArray();
    void atualizarServico(ServicoQuarto s, double preco);
    boolean existeServico(ServicoQuarto s);
    ServicoQuarto buscarServico(int codigo);

    
    
    
    /*
    void adicionarOpcao(ServicoQuarto h);
    void removerOpcao(ServicoQuarto h);
    ServicoQuarto buscarOpcao(int código);
    void atualizarOpcao(int cod, ServicoQuarto h);
    boolean existeOpcao(ServicoQuarto h);
    String listarOpcoes();
    */ 
}
