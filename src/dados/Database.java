package dados;

import entidade.pessoa.Funcionario;
import entidade.pessoa.Hospede;
import entidade.quarto.Quarto;
import entidades.Reserva;
import entidades.ServicoQuarto;
import java.sql.*;
import java.util.ArrayList;
import negócio.regras.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author araujo
 */
public class Database {
    
    private final String url = "jdbc:postgresql://localhost:5432/GoldenHotel";
    private final String usuario = "postgres";
    private final String senha = "pgsql";
    private Connection con;
    private Statement statement;
    Date d = new Date();
    
 
        
    
    private void abrirConexao() throws Exception{
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, usuario, senha);
        statement = con.createStatement();
    }
    
    private boolean executarComando(String sql) throws Exception{
        return statement.execute(sql);
    }
    
    
    
    private void fecharConexao() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(con != null){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
           }
        }
    
    public void testarConexao(){
        try{
            this.abrirConexao();
            String comando = "Create table if not exists funcionario(cpf VARCHAR(11), PRIMARY KEY(cpf))";
            this.executarComando(comando);
            this.fecharConexao();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void iniciarBanco(){
        try{
            this.abrirConexao();
            String comando = "CREATE TABLE if not exists funcionario(cpf VARCHAR(11), nome VARCHAR(100) NOT NULL, gerente BOOLEAN NOT NULL, senha VARCHAR(10) NOT NULL, dataCadastro DATE NOT NULL, salario REAL, PRIMARY KEY(cpf))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists hospede(cpf VARCHAR(11),nome VARCHAR(100) NOT NULL, telefone VARCHAR(12) NOT NULL, debito REAL , PRIMARY KEY(cpf))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists quarto(numero VARCHAR(5) , quantidadePessoas INT,diaria REAL, ocupado BOOLEAN , consumacao REAL, isPremium BOOLEAN, PRIMARY KEY(numero))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists reserva(codigo_reserva VARCHAR(5), checkin_realizado BOOLEAN DEFAULT FALSE, cpf_funcionario VARCHAR(11), numero_quarto VARCHAR(5), FOREIGN KEY(cpf_funcionario) REFERENCES funcionario(cpf), FOREIGN KEY(numero_quarto) REFERENCES quarto(numero), PRIMARY KEY(codigo_reserva))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists servico(id_servico SERIAL, nome VARCHAR(50) NOT NULL, preco REAL NOT NULL, PRIMARY KEY(id_servico))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists hospede_reserva(cpf_hospede VARCHAR(11), codigo_reserva VARCHAR(5), FOREIGN KEY(cpf_hospede) REFERENCES hospede(cpf), FOREIGN KEY(codigo_reserva) REFERENCES reserva(codigo_reserva), PRIMARY KEY(cpf_hospede, codigo_reserva))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists quarto_reservado(codigo_reserva VARCHAR(5), numero_quarto VARCHAR(5), data_entrada DATE NOT NULL, data_saida DATE NOT NULL,FOREIGN KEY(codigo_reserva) REFERENCES reserva(codigo_reserva), FOREIGN KEY(numero_quarto) REFERENCES quarto(numero), PRIMARY KEY(codigo_reserva, numero_quarto))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists reserva_servico(id_servico SERIAL, codigo_reserva VARCHAR(5), FOREIGN KEY(codigo_reserva) REFERENCES reserva(codigo_reserva), FOREIGN KEY(id_servico) REFERENCES servico(id_servico), PRIMARY KEY(codigo_reserva,id_servico))";
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
}
    
    public void adicionarFuncionario(Funcionario f){
        try{
            this.abrirConexao();
            String comando = String.format("INSERT INTO funcionario (cpf,nome,gerente,senha, dataCadastro, salario) VALUES('%s', '%s', '%s', '%s','%s','%s')", f.getCpf(), f.getNome(), f.getGerente(), f.getSenha(), f.getDataCadastro(), f.getSalario());
            this.executarComando(comando);
            this.fecharConexao();
        }catch(Exception e){

        }
    }
    
    public void removerFuncionario(Funcionario funcionario){
        try{
            this.abrirConexao();
            String comando = String.format("DELETE FROM funcionario WHERE cpf='%s'",funcionario.getCpf());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean existePessoa(Funcionario f){
        try {
            this.abrirConexao();
            String comando = String.format("SELECT * FROM funcionario WHERE cpf='%s'",f.getCpf());
            ResultSet rs = statement.executeQuery(comando);
            if(rs != null){
                String cpfA;
                String nome;
                boolean gerente;
                String senhaA;
                Date dataCadastro;
                Double salario;
                while (rs.next()){
                    cpfA = rs.getString("cpf");
                    nome = rs.getString("nome");
                    gerente = rs.getBoolean("gerente");
                    senhaA = rs.getString("senha");
                    dataCadastro = rs.getDate("dataCadastro");
                    salario = rs.getDouble("salario");
                    Funcionario func = new Funcionario(cpfA,nome,gerente,senhaA,dataCadastro,salario);
                    if(f.equals(func)){
                        return true;
                    }
                }
                
            }
        this.fecharConexao();
        
       
           
        } catch (Exception e) {
            
        }
        return false;
        
    }
    
    public Funcionario buscarPessoa(String cpf){
         try {
            this.abrirConexao();
            String comando = String.format("SELECT * FROM funcionario WHERE cpf='%s'",cpf);
            ResultSet rs = statement.executeQuery(comando);
            String cpfA;
            String nome;
            boolean gerente;
            String senhaA;
            Date dataCadastro;
            Double salario;
            while (rs.next()){
                cpfA = rs.getString("cpf");
                nome = rs.getString("nome");
                gerente = rs.getBoolean("gerente");
                senhaA = rs.getString("senha");
                dataCadastro = rs.getDate("dataCadastro");
                salario = rs.getDouble("salario");
                Funcionario func = new Funcionario(cpfA,nome,gerente,senhaA,dataCadastro,salario);
                return func;
            }
            this.fecharConexao();

           
        } catch (Exception e) {
            
        }
        return null;
        
    }
    
    public ArrayList<Funcionario> listarFuncionario() {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        try{
            
            this.abrirConexao();
            String comando = String.format("SELECT * FROM funcionario");
            ResultSet rs = statement.executeQuery(comando);
            String cpf;
            String nome;
            boolean gerente;
            String senha;
            Date dataCadastro;
            Double salario;
            while (rs.next()){
                cpf = rs.getString("cpf");
                nome = rs.getString("nome");
                gerente = rs.getBoolean("gerente");
                senha = rs.getString("senha");
                dataCadastro = rs.getDate("dataCadastro");
                salario = rs.getDouble("salario");
                lista.add(new Funcionario(cpf,nome,gerente,senha,dataCadastro,salario));
            }
            this.fecharConexao();
            return lista;
        }catch (Exception e){
            e.printStackTrace();
            return lista;
        }
}
    
    public void atualizarFuncionario(Funcionario f,boolean gerente){//Promocao e despromocao
        try{
            this.abrirConexao();
            String comando = String.format("UPDATE funcionario SET gerente='%s' WHERE cpf='%s'",gerente,f.getCpf());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    
    
    
    public void adicionarHospede(Hospede h){
        try {
            this.abrirConexao();
            String comando = String.format("INSERT INTO hospede(cpf, nome,telefone,debito) VALUES('%s', '%s', '%s', '%s')", h.getCpf(), h.getNome(), h.getTelefone(), h.getDebito());
            this.executarComando(comando);
            this.fecharConexao();
        
        } catch (Exception e) {
        
        }
    }
    
    public void removerHospede(Hospede h){
        try{
            this.abrirConexao();
            String comando = String.format("DELETE FROM hospede WHERE cpf='%s'",h.getCpf());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
}
 public ArrayList<Hospede> listarHospede() {
        ArrayList<Hospede> lista = new ArrayList<Hospede>();
        try{
            
            this.abrirConexao();
            String comando = String.format("SELECT * FROM hospede");
            ResultSet rs = statement.executeQuery(comando);
            String cpf;
            String nome;
            String telefone;
            Double debito;
            while (rs.next()){
                cpf = rs.getString("cpf");
                nome = rs.getString("nome");
                telefone = rs.getString("telefone");
                debito = rs.getDouble("debito");
                lista.add(new Hospede(cpf,nome,telefone,debito));
            }
            this.fecharConexao();
            return lista;
        }catch (Exception e){
            e.printStackTrace();
            return lista;
        }
    }
    
     public void atualizarHospede(Hospede h,String telefone){//Promocao e despromocao
        try{
            this.abrirConexao();
            String comando = String.format("UPDATE hospede SET telefone='%s' WHERE cpf='%s'",telefone,h.getCpf());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
     
     public Hospede buscarHospede(String cpf){
         try {
            this.abrirConexao();
            String comando = String.format("SELECT * FROM hospede WHERE cpf='%s'",cpf);
            ResultSet rs = statement.executeQuery(comando);
            String cpfA;
            String nome;
            String telefone;
            Double debito;
            while (rs.next()){
                cpfA = rs.getString("cpf");
                nome = rs.getString("nome");
                telefone = rs.getString("telefone");
                debito = rs.getDouble("debito");
                Hospede hos = new Hospede(cpfA,nome,telefone,debito);
                return hos;
            }
            this.fecharConexao();

           
        } catch (Exception e) {
            
        }
        return null;
        
    }
     
     public void adicionarHospede(String cpf, String nome, String telefone, double debito){
        try {
            this.abrirConexao();
            String comando = String.format("INSERT INTO hospede (cpf,nome,telefone,debito) VALUES('%s', '%s', '%s', '%s')",cpf,nome,telefone,debito);
            this.executarComando(comando);
            this.fecharConexao();
  
            
        } catch (Exception e) {
        }
    }
 
 
    
    
    public void adicionarQuarto(Quarto q){
        try {
            this.abrirConexao();
            String comando = String.format("INSERT INTO quarto(numero, quantidadePessoas,diaria, ocupado, consumacao, isPremium ) VALUES('%s','%s','%s','%s','%s','%s')",q.getNumeroQuarto(), q.getQuantidadePessoas(), q.getDiaria(),q.getOcupado(),q.getConsumação(),q.getIsPremium());
            this.executarComando(comando);
            this.fecharConexao();
        } catch (Exception e) {
        }
    }
    
        public void removerQuarto(Quarto q){
        try{
            this.abrirConexao();
            String comando = String.format("DELETE FROM quarto WHERE numero='%s'",q.getNumeroQuarto());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
}
        public boolean existeQuarto(Quarto q){
        try {
            this.abrirConexao();
            String comando = String.format("SELECT * FROM quarto WHERE = numero'%s'", q.getNumeroQuarto());
            ResultSet rs = statement.executeQuery(comando);
            if(rs != null){
                String numero;
                int quantPessoas;
                double diaria;
                boolean ocupado;
                double consumacao;
                boolean isPremium;
                while (rs.next()){
                    numero = rs.getString("numero");
                    quantPessoas = rs.getInt("quantidadePessoas");
                    diaria= rs.getDouble("diaria");
                    ocupado = rs.getBoolean("ocupado");
                    consumacao = rs.getDouble("consumacao");
                    isPremium = rs.getBoolean("isPremium");
                    Quarto quarto = new Quarto(numero, quantPessoas, diaria, ocupado, consumacao, isPremium);
                    if(q.equals(quarto)){
                        return true;
                    }
                
                }   
                
            }
        
            this.fecharConexao();
        
       
           
        } catch (Exception e) {
            
        }
        return false;
        
    }
    
    public Quarto buscarQuarto(String numero){
         try {
            this.abrirConexao();
            String comando = String.format("SELECT * FROM quarto WHERE numero='%s'",numero);
            ResultSet rs = statement.executeQuery(comando);
            String numeroA;
            int quantPessoas;
            double diaria;
            boolean ocupado;
            double consumacao;
            boolean isPremium;
                
            while (rs.next()){
                numero = rs.getString("numero");
                quantPessoas = rs.getInt("quantidadePessoas");
                diaria= rs.getDouble("diaria");
                ocupado = rs.getBoolean("ocupado");
                consumacao = rs.getDouble("consumacao");
                isPremium = rs.getBoolean("isPremium");
                Quarto quarto = new Quarto(numero, quantPessoas, diaria, ocupado, consumacao, isPremium);
                return quarto;
            }
            
            this.fecharConexao();

           
        } catch (Exception e) {
            
        }
        return null;
        
    }
        public ArrayList<Quarto> listarQuarto() {
        ArrayList<Quarto> lista = new ArrayList<Quarto>();
        try{
            
            this.abrirConexao();
            String comando = String.format("SELECT * FROM quarto");
            ResultSet rs = statement.executeQuery(comando);
            String numero;
            int quantPessoas;
            double diaria;
            boolean ocupado;
            double consumacao;
            boolean isPremium;
            while (rs.next()){
                numero = rs.getString("numero");
                quantPessoas = rs.getInt("quantidadePessoas");
                diaria= rs.getDouble("diaria");
                ocupado = rs.getBoolean("ocupado");
                consumacao = rs.getDouble("consumacao");
                isPremium = rs.getBoolean("isPremium");
                lista.add(new Quarto(numero, quantPessoas, diaria, ocupado, consumacao, isPremium));
            }
            this.fecharConexao();
            return lista;
        }catch (Exception e){
            e.printStackTrace();
            return lista;
        }
    }
    
     public void atualizarQuarto(Quarto q,boolean premium){//altera categoria do quarto
        try{
            this.abrirConexao();
            String comando = String.format("UPDATE quarto SET isPremium='%s' WHERE numero='%s'",premium,q.getNumeroQuarto());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
 
    public void adicionarServico(ServicoQuarto s){
        try {
            this.abrirConexao();
            String comando = String.format("INSERT into servico(nome, preco) VALUES('%s','%s')",s.getNome(),s.getPreço());
            this.executarComando(comando);
            this.fecharConexao();

        } catch (Exception e) {
       }
       
        
    }
    public void removerServico(ServicoQuarto s){
        try{
            this.abrirConexao();
            String comando = String.format("DELETE FROM servico WHERE nome='%s'",s.getNome());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<ServicoQuarto> listarServico() {
    ArrayList<ServicoQuarto> lista = new ArrayList<ServicoQuarto>();
    try{
     
        this.abrirConexao();
        String comando = String.format("SELECT * FROM servico");
        ResultSet rs = statement.executeQuery(comando);
        int idServico;
        String nome;
        double preco;
        while (rs.next()){
            idServico = rs.getInt("id_servico");
            nome = rs.getString("nome");
            preco = rs.getDouble("preco");
            lista.add(new ServicoQuarto(idServico, nome, preco));
            }
            this.fecharConexao();
            return lista;
        }catch (Exception e){
            e.printStackTrace();
            return lista;
        }
    }
    
    public boolean existeServico(ServicoQuarto s){
        try {
            this.abrirConexao();
            String comando = String.format("SELECT * FROM servico WHERE id_servico='%s'", s.getIdServico());
            ResultSet rs = statement.executeQuery(comando);
            if(rs != null){
                int idServico;
                String nome;
                double preco;
                
                while (rs.next()){
                    idServico = rs.getInt("id_servico");
                    nome = rs.getString("nome");
                    preco = rs.getDouble("preco");
                    
                    ServicoQuarto ser = new ServicoQuarto(idServico, nome, preco);
                    if(s.equals(ser)){
                        return true;
                    }
                
                }   
                
            }
        
            this.fecharConexao();
        
       
           
        } catch (Exception e) {
            
        }
        return false;
        
    }
    
    public ServicoQuarto buscarServico(int codigo){
         try {
            this.abrirConexao();
            String comando = String.format("SELECT * FROM servico WHERE id_servico='%s'",codigo);
            ResultSet rs = statement.executeQuery(comando);
            int idServico;
            String nome;
            double preco;
            while (rs.next()){
                idServico = rs.getInt("id_servico");
                nome = rs.getString("nome");
                preco = rs.getDouble("preco");
                ServicoQuarto ser = new ServicoQuarto(idServico, nome, preco);
                return ser;
                
            }
            
            this.fecharConexao();

           
        } catch (Exception e) {
            
        }
        return null;
        
    }
    
     public void atualizarServico(ServicoQuarto s,double preco){//altera preco
        try{
            this.abrirConexao();
            String comando = String.format("UPDATE servico SET preco='%s' WHERE nome='%s'",preco,s.getNome());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
     public void adicionarReserva(Reserva r){
        try {
            this.abrirConexao();
            String comando = String.format("INSERT into reserva(codigo_reserva, checkin_realizado, cpf_funcionario, numero_quarto) VALUES('%s','%s','%s','%s')",r.getCodigoReserva(), r.getCheckInRealizado(), r.getCpfFuncionario(), r.getNumeroQuarto());
            this.executarComando(comando);
            this.fecharConexao();

        } catch (Exception e) {
       }
       
        
    }
    public void removerReserva(Reserva r){
        try{
            this.abrirConexao();
            String comando = String.format("DELETE FROM reserva WHERE codigo_reserva='%s'",r.getCodigoReserva());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public boolean existeReserva(Reserva r){
        try {
            this.abrirConexao();
            String comando = String.format("SELECT * FROM reserva WHERE codigo_reserva='%s'",r.getCodigo_reserva());
            ResultSet rs = statement.executeQuery(comando);
            if(rs != null){
                String codigo_reserva;
                boolean checkinRealizado;
                String cpfFuncionario;
                String numeroQuarto;
            
                while (rs.next()){
                    codigo_reserva = rs.getString("codigo_reserva");
                    checkinRealizado = rs.getBoolean("checkin_realizado");
                    cpfFuncionario = rs.getString("cps_funcionario");
                    numeroQuarto = rs.getString("numero_quarto");
                    Reserva res = new Reserva(codigo_reserva,checkinRealizado, cpfFuncionario, numeroQuarto);
                    if(r.equals(res)){
                        return true;
                    }
                
                }   
                
            }
        
            this.fecharConexao();
        
       
           
        } catch (Exception e) {
            
        }
        return false;
        
    }
    
    public Reserva buscarReserva(String codigo){
         try {
            this.abrirConexao();
            String comando = String.format("SELECT * FROM funcionario WHERE codigo_reserva='%s'",codigo);
            ResultSet rs = statement.executeQuery(comando);
            String codigo_reserva;
            boolean checkinRealizado;
            String cpfFuncionario;
            String numeroQuarto;
            while (rs.next()){
                codigo_reserva = rs.getString("codigo_reserva");
                checkinRealizado = rs.getBoolean("checkin_realizado");
                cpfFuncionario = rs.getString("cps_funcionario");
                numeroQuarto = rs.getString("numero_quarto");
                Reserva res = new Reserva(codigo_reserva,checkinRealizado, cpfFuncionario, numeroQuarto);                
                return res;
            }
            
            this.fecharConexao();

           
        } catch (Exception e) {
            
        }
        return null;
        
    }
    
    public Reserva buscarReserva(int codigo){
         try {
            this.abrirConexao();
            String comando = String.format("SELECT * FROM reserva WHERE codigo_reserva='%s'",codigo);
            ResultSet rs = statement.executeQuery(comando);
            String codigo_reserva;
            boolean checkinRealizado;
            String cpfFuncionario;
            String numeroQuarto;
            while (rs.next()){
                codigo_reserva = rs.getString("codigo_reserva");
                checkinRealizado = rs.getBoolean("checkin_realizado");
                cpfFuncionario = rs.getString("cps_funcionario");
                numeroQuarto = rs.getString("numero_quarto");
                Reserva res = new Reserva(codigo_reserva,checkinRealizado, cpfFuncionario, numeroQuarto);                
                return res;
            }
            
            this.fecharConexao();

           
        } catch (Exception e) {
            
        }
        return null;
        
    }
        
        public ArrayList<Reserva> listarReserva() {
        ArrayList<Reserva> lista = new ArrayList<Reserva>();
        try{
            
            this.abrirConexao();
            String comando = String.format("SELECT * FROM reserva");
            ResultSet rs = statement.executeQuery(comando);
            
            String codigo_reserva;
            boolean checkinRealizado;
            String cpfFuncionario;
            String numeroQuarto;
            
            while (rs.next()){
                codigo_reserva = rs.getString("codigo_reserva");
                checkinRealizado = rs.getBoolean("checkin_realizado");
                cpfFuncionario = rs.getString("cps_funcionario");
                numeroQuarto = rs.getString("numero_quarto");
                lista.add(new Reserva(codigo_reserva, checkinRealizado, cpfFuncionario, numeroQuarto));
            }
            this.fecharConexao();
            return lista;
        }catch (Exception e){
            e.printStackTrace();
            return lista;
        }
    }
        
    public void checkIn(String numero){
        try {
            this.abrirConexao();
            String comando = String.format("UPDATE quarto SET ocupado= '%s' WHERE numero='%s'",true , numero);
            PreparedStatement preparedStmt = con.prepareStatement(comando); 
            preparedStmt.executeUpdate();
            
            this.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

            

                
    }
    public void checkOut(String numero){
        try {
            this.abrirConexao();
            String comando = String.format("UPDATE quarto SET ocupado= '%s' WHERE numero='%s'",false,numero);
            PreparedStatement preparedStmt = con.prepareStatement(comando); 
            preparedStmt.executeUpdate();
            
            this.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }


        
    }
}
   
    
     
       
    

     
     
    

