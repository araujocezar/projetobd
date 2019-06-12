package dados;

import entidades.Reserva;
import java.util.ArrayList;

//Implementa IRepositorioReserva, viabilizando evolução do sistema. CRUD básico.
public class RepositorioReserva implements IRepositorioReserva{
	
    private ArrayList<Reserva> reservas;
    private Database db;
	
    public RepositorioReserva(){
        reservas = new ArrayList<Reserva>();
        this.db = new Database();
        this.db.adicionarReserva(new Reserva("101",false,"12345","100"));
    }
    
    public void adicionarReserva(Reserva r){
        this.db.adicionarReserva(r);
    }
    
    public void removerReserva(Reserva r){
        this.db.removerReserva(r);
    }
    
   public ArrayList<Reserva> listaReservas(){
       return this.db.listarReserva();
    }

   public Reserva buscarReserva(String codigo){
       return this.db.buscarReserva(codigo);
   }
   
   public Reserva buscarReserva(int codigo){
       return this.db.buscarReserva(codigo);
   }
   
   public boolean existeReserva(Reserva r){
       return this.db.existeReserva(r);
   }
   
   @Override
    public void checkIn(String numero) {
        this.db.checkIn(numero);
    }
    
     public void checkOut(String numero) {
        this.db.checkOut(numero);
    }

    
    
   
	
    /*
    
    @Override
    public ArrayList<Reserva> listaReservas(){
        return reservas;
    }
    
    @Override
    public void adicionarReserva(Reserva r){
        reservas.add(r);
    }
	
    @Override
    public void removerReserva(Reserva r){
	reservas.remove(r);
    }
    
    //Chamada de equals.
    @Override
    public boolean existeReserva(Reserva reserva){
        for(int i = 0; i < reservas.size(); i++){
            if(reserva.equals(reservas.get(i))){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void atualizarReserva(int cod, Reserva reserva){
	Reserva r = this.buscarReserva(cod);
	int indice = reservas.indexOf(r);
	reservas.set(indice, reserva);
    }

    
    //Chamada de toString.
    @Override
    public String listarReservas(){
        String x = "Quartos reservados:" + "\n\n"; 
        for(int i = 0; i < reservas.size(); i++){
            if(!reservas.get(i).getCheckInRealizado()){
                x += reservas.get(i).toString();
            }
        }
        return x;
    }
    
    @Override
    public Reserva buscarReserva(int codigo){
	Reserva r = null;
	for(int i = 0; i < reservas.size(); i++){
            if(reservas.get(i).getCodigoReserva() == codigo){
		r = reservas.get(i);
            }
	}
	return r;
    }*/     

    

}
