
import dados.Database;
import entidade.pessoa.Funcionario;
import entidade.pessoa.Hospede;
import entidade.quarto.Quarto;
import entidades.Reserva;
import entidades.ServicoQuarto;
import exceção.DataInvalidaException;
import exceção.PessoaExistenteException;
import fachada.Fachada;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author araujo
 */
public class main {
    private static Date  data = new Date();
    private static ArrayList<Funcionario> lista;
    
    public static void main(String [] args){
        Fachada fachada = Fachada.getInstancia();
        Database banco = new Database();
        banco.iniciarBanco();
        
        Quarto q;
        Funcionario f;
        Hospede h;
        Reserva r;
        ServicoQuarto sq;
        
        
                

        //f = new Funcionario("444", "Edvaldo", false, "123", data, 4000.00);
        f = new Funcionario("444", "Mateus", false, "123", data, 4000.00);
        r = new Reserva("2",false,"444","300");
        h = new Hospede("123","Hospede","3762-0414", 0.00);
        q = new Quarto("300",2,150.00,false,0.00,true);
        
        banco.adicionarFuncionario(f);
        //banco.removerFuncionario(f);
        lista = banco.listarFuncionario();
        
        banco.adicionarHospede(h);
        //banco.removerQuarto(q);
        banco.adicionarQuarto(q);
        
        //banco.checkIn("300");
        //banco.checkOut("300");
        
        //banco.adicionarReserva(r);
        
        
        
        int i = 0;
        for(i=0;i<lista.size();i++){
            System.out.println(lista.get(i).toString());
        }
        
    
        
    
    
    }
    
   

    
}
