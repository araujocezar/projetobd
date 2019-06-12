package fachada;
import dados.*;
import entidade.pessoa.*;
import entidades.ServicoQuarto;
import entidade.quarto.*;
import entidades.Reserva;
import negócio.regras.*;
import exceção.*;
import java.util.ArrayList;
import java.util.Date;

public class Fachada {
    
    private NegócioReserva reservas;
    private NegócioQuarto quartos;
    private NegócioPessoa pessoas;
    private NegócioServicoQuarto servicoQuarto;
    
    private NegócioRelatorio relatorios;
    private static Fachada instancia;
    
    private Fachada(){
        reservas = new NegócioReserva(new RepositorioReserva());
        quartos = new NegócioQuarto(new RepositorioQuarto());
        pessoas = new NegócioPessoa(new RepositorioPessoa());
        servicoQuarto = new NegócioServicoQuarto(new RepositorioServicoQuarto());
        //relatorios = new NegócioRelatorio(reservas, pessoas);
    }
    
    public static synchronized Fachada getInstancia(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
    //Métodos que manipulam o objeto quarto
    public void adicionarQuarto(String numeroQuarto, int quantidadePessoas, double diaria, boolean ocupado, double consumacao, boolean isPremiums) throws QuartoExistenteException{
        Quarto quarto = new Quarto(numeroQuarto, quantidadePessoas);
        quartos.adicionarQuarto(quarto);
    }
    
    public Quarto buscarQuarto(String numero){
        return quartos.buscarQuarto(numero);
    }
    public Funcionario buscarFuncionario(String cpf){
        return pessoas.buscarPessoa(cpf);
    }
    
    public ServicoQuarto buscarServico(int id){
        return servicoQuarto.buscarServico(id);
    }
    
  
    
    public Hospede buscarHospede(String cpf){
        return pessoas.buscarHospede(cpf);
    }
    
    public void removeHospede(Hospede h) throws PessoaInexistenteException{
        pessoas.removerHospede(h);
    }
    
    public void removerQuarto(Quarto q) throws QuartoInexistenteException{
        quartos.removerQuarto(q);
    }
    
    public void atualizarQuarto(Quarto q, boolean isPremium) throws QuartoInexistenteException, QuartoExistenteException{
        quartos.atualizarQuarto(q, isPremium);
    }
    
    
    
    
    
    
    public String infoCheckOut(String numeroQuarto) throws QuartoInexistenteException{
        Quarto q = quartos.buscarQuarto(numeroQuarto);
        return "nao utilizado";
    }
    
    
    //Métodos que manipulam a superclasse pessoa   
    
    /*
    Hóspede e funcionário são tratados da mesma maneira, pórem possuem construtores diferentes. Dessa forma, possuo dois
    métodos na fachada que adicionam ao ArrayList de pessoa. Mesmo serve pra atualização dos mesmos.
    */
    public void adicionarFuncionario(String cpf, String nome,boolean gerente, String senha , Date dataCadastro, double salario) throws PessoaExistenteException, DataInvalidaException{
        Funcionario funcionario = new Funcionario (nome, cpf, dataCadastro, salario, senha, gerente);
        pessoas.adicionarFuncionario(funcionario);
    }
    
    public void adicionarHospede(String cpf, String nome, String telefone, double debito) throws PessoaExistenteException, DataInvalidaException{
        Hospede h = new Hospede(cpf, nome, telefone,debito);
        pessoas.adicionarHospede(h);
    }
    
    
    public void removerFuncionario(Funcionario f) throws PessoaInexistenteException{
        
        pessoas.removerFuncionario(f);
    }
    
    public void atualizarFuncionario(Funcionario f, boolean gerente) throws PessoaInexistenteException, PessoaExistenteException{
        pessoas.atualizarFuncionario(f,gerente);
    }
    
    public void atualizarHospede(Hospede h, String telefone) throws PessoaInexistenteException, PessoaExistenteException{
        pessoas.atualizarHospede(h, telefone);
    }
    
    public ArrayList<Hospede> listarHospedes(){
        return pessoas.getArrayHospede();
    }
    
    public ArrayList<Funcionario> listarFuncionario(){
        return pessoas.getArray();
    }
    
    public Funcionario login(String cpf, String senha) throws PessoaInexistenteException, LoginException{
        return pessoas.login(cpf, senha);
    }
    
    //Métodos que manipulam serviço de quarto
    public void adicionarServico(ServicoQuarto servico) throws ItemCadastradoException{
        servicoQuarto.adicionarOpcao(servico);
    }
    
    public void removerOpcao(ServicoQuarto s) throws ItemInexistenteException{
        servicoQuarto.removerOpcao(s);
    }
    
    public void atualizarOpcao(ServicoQuarto s, double preco) throws ItemInexistenteException, ItemCadastradoException{
        servicoQuarto.atualizarOpcao(s,preco);
    }
    
    public ArrayList<ServicoQuarto> listarServico(){
        return servicoQuarto.listarServico();
    }
    /*
    public void solicitarServicoQuarto(String numeroQuarto, int codigo) throws QuartoInexistenteException, ItemInexistenteException, CheckInNaoRealizadoException{
        Quarto q = quartos.buscarQuarto(numeroQuarto);
    //    ServicoQuarto h = servicoQuarto.buscarOpcao(codigo);
      //  servicoQuarto.solicitarServicoQuarto(q, h);
    }
    
    //Métodos que manipulam as reservas
    public double reservarQuarto(Date dataChegada, Date dataSaida, String cpf, String numeroQuarto) throws PessoaInexistenteException, ReservaExistenteException, QuartoInexistenteException, DataIndisponivelException, DataInvalidaException{
        Pessoa h = pessoas.buscarPessoa(cpf);
        Quarto quarto = quartos.buscarQuarto(numeroQuarto);
        Reserva reserva = new Reserva(dataChegada, dataSaida, quarto, (Hospede) h);
        return reservas.reservarQuarto(reserva);
    }
    
   */
    
      public Reserva buscarReserva(int cod){
        return reservas.buscarReserva(cod);
    }
    
    public void removerReserva(Reserva reserva) throws ReservaInexistenteException{
        reservas.removerReserva(reserva);
    }
    
    public ArrayList<Reserva> listarReservas(){
        return reservas.getReservas();
    }
    
    /*
    Em um hotel, posso realizar uma reserva com antecedência ou posso chegar diretamente no dia e entrar no quarto que estiver
    disponível, sendo assim, dois métodos na fachada para realizarem check-in. Um que recebe o código da reserva previamente
    cadastrada e outro que recebe as informações necessárias para se instanciar uma reserva. A partir da classe de negócio, tudo
    é tratado apenas como reserva.
    */
    public void checkIn(String numero) throws ReservaInexistenteException, CheckInRealizadoException{
        reservas.checkIn(numero);
    }
    
     public void checkOut(String numeroQuarto) throws QuartoInexistenteException, CheckInRealizadoException{
         reservas.checkOut(numeroQuarto);
     }
   
    
    
    
    
    //Métodos que manipulam a classe pacotes
    
    /*
     public void checkOut(String numeroQuarto) throws QuartoInexistenteException, CheckInRealizadoException{
        Quarto q = quartos.buscarQuarto(numeroQuarto);
        quartos.checkOut(q);
    }
   
    
    public double checkIn(Date dataChegada, Date dataSaida, String numeroQuarto, String cpf) throws PessoaInexistenteException, ReservaExistenteException, QuartoInexistenteException, DataIndisponivelException, DataInvalidaException, ReservaInexistenteException, CheckInRealizadoException{
        
        Quarto q = quartos.buscarQuarto(numeroQuarto);
        Pessoa h = pessoas.buscarPessoa(cpf);
        Reserva reserva = new Reserva(dataChegada, dataSaida, q, (Hospede) h);
        reservas.reservarQuarto(reserva);
        reservas.checkIn(reserva);
        return reserva.getHospede().getDebito();
    }
    
    
    
    Ao realizar a compra de um pacote, uma reserva é criada e todas as comparações de data do método "reservarQuarto"
    são feitas. O débito do hóspede é atualizado de imediato, pois trata-se da compra de um pacote que possui valor 
    previamente definido.
    */
    
    //Métodos de Relatórios
    /*
    public String reservasPorMes(int mes){
        return relatorios.reservasPorMes(mes);
    }
    
    public String fichaHospede(String cpf) throws PessoaInexistenteException{
        return relatorios.fichaHospedes(cpf);
    }  */
}
