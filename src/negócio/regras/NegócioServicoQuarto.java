package negócio.regras;
import dados.RepositorioServicoQuarto;
import dados.IRepositorioServicoQuarto;
import entidades.ServicoQuarto;
import entidade.quarto.Quarto;
import exceção.*;
import java.util.ArrayList;

public class NegócioServicoQuarto {

    private IRepositorioServicoQuarto rep;
	
    public NegócioServicoQuarto(IRepositorioServicoQuarto rep){
	this.rep = rep;
    }
	
    public boolean existeServico(ServicoQuarto s){
	return rep.existeServico(s);
    }
	
    public ServicoQuarto buscarServico(int cod){
	return rep.buscarServico(cod);
    }

    //Adiciona uma nova opção.
    public void adicionarOpcao(ServicoQuarto a) throws ItemCadastradoException{
	boolean x = this.existeServico(a);
	if(x){
            throw new ItemCadastradoException();
	}
	else{
            rep.adicionarServico(a);
        }
    }

    //Remove a opção.
    public void removerOpcao(ServicoQuarto a) throws ItemInexistenteException{
        boolean x = this.existeServico(a);
            if(!x){
                throw new ItemInexistenteException();
            }
            else{
		rep.removerServico(a);
            }
    }

    //Atualiza a opção referente ao código passado no parâmetro.
    public void atualizarOpcao(ServicoQuarto a, double preco) throws ItemInexistenteException, ItemCadastradoException{
        rep.atualizarServico(a,preco);
    }
    
    public ArrayList<ServicoQuarto> listarServico(){
        return rep.getArray();
    }

    //Retorna as opções cadastradas
    
    /*
    Recebe o quarto e a opção a ser consumida, a atualização do consumo do quarto é feita automaticamente. Caso o quarto
    passado no parâmetro exista porém não tenha sido realizado check-in nele, uma exceção é lançada.
    */
    public void solicitarServicoQuarto(Quarto q, ServicoQuarto a) throws QuartoInexistenteException, ItemInexistenteException, CheckInNaoRealizadoException{
        if(q == null){
            throw new QuartoInexistenteException();
	}
	else if(a == null){
            throw new ItemInexistenteException();
	}
        else if(!q.getOcupado()){
            throw new CheckInNaoRealizadoException();
        }
	else{
            q.setConsumo(a.getPreço());
	}
    }
}
