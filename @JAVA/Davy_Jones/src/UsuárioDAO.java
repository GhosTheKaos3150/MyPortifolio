
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuárioDAO {
    
    // Chamada Usuário:
    
    Usuário user = new Usuário();
    
    Process proc = new Process();
    
    //Métodos:
    
    public Usuário LogOn(int ID, String Senha) throws ClassNotFoundException, SQLException{
        
        /*
        Esse método é implementado através da interface "LogOn.FXML". Através dele, uma tela de LogOn aparecerá e você
        poderar Logar através de seu Usuário e Senha.
        */
        
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=Sansara3150@");
            Statement stm = con.createStatement();
            stm.executeQuery("USE datadv_jones");
            
            ResultSet result = stm.executeQuery("SELECT * FROM jogador WHERE Id_GamePlay = " + ID + " AND Senha = '" + Senha + "'");
            
            while(result.next()){
                
                user.setID(result.getInt("Id_GamePlay"));
                user.setNome(result.getString("user"));
                user.setJogadas(result.getInt("jogadas_"));
                user.setVitorias(result.getInt("vitorias_"));
                user.setDerrotas(result.getInt("derrotas_"));
                user.setXP(result.getInt("Experience"));
                user.setSenha(result.getString("Senha"));
                
                
                //Essa parte não faz parte do código original. Serve para testar o funcionamento do
                // Banco de Dados Implementado;
                System.out.println("Teste de FUNCIONALIDADE: ");
                System.out.println("Id_GamePlay: " + user.getID());
                System.out.println("user: " + user.getNome());
                System.out.println("jogadas_: " + user.getJogadas());
                System.out.println("vitorias_: " + user.getVitorias());
                System.out.println("derrotas_: " + user.getDerrotas());
                System.out.println("Experience: "+ user.getXP());
                System.out.println("Senha: " + user.getSenha());
                
                System.out.println("Se não houver retornado 0 ou null, a aplicação funciona.");
                
            }
            
            stm.close();
            con.close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
        return this.user;
        
    }
    
    public void LogOff(){
        
        /*
        Esse método é acionado pelo botão "LogOff" no menu da Interface "Jones.FXML". Ele desloga qualquer usuário que
        esteja dentro do jogo.
        */
        
        Sessao.usuarioLogado.setID(0);
        Sessao.usuarioLogado.setNome(null);
        Sessao.usuarioLogado.setJogadas(0);
        Sessao.usuarioLogado.setVitorias(0);
        Sessao.usuarioLogado.setDerrotas(0);
        Sessao.usuarioLogado.setXP(0);
        Sessao.usuarioLogado.setSenha(null);
        
        
    }
    
    public Usuário getOpen(){
        
        return this.user;
        
    }
    
    public void UpdateNome (int Id, String Nome) throws ClassNotFoundException, SQLException{
        
        /*
        Esse método é utilizado atraés da interface "User_Interface.FXML", pelo botão entitulado "Salvar". Ao clicar
        neste botão, ele automáricamente irá salvar qualquer valor válido para nome no "TextField"  ao seu lado.
        */
        
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=Sansara3150@");
            
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE datadv_jones");
            
            PreparedStatement stm = con.prepareStatement("UPDATE jogador SET user = ? WHERE Id_GamePlay = ?");
            
            stm.setString(1, Nome);
            stm.setInt(2, Id);
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
    }
    
    public void gameNewRun() throws ClassNotFoundException{ //Adiciona uma Jogada ao suário Conectado;
        
        //Parte 1: Aumentar Jogadas em Classe Usuário (Se não estiver conectado, não será armazenado);
        int a = Sessao.usuarioLogado.getJogadas();
        a++;
        Sessao.usuarioLogado.setJogadas(a);
        
        //Parte 2: Método Principal;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=Sansara3150@");
            
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE datadv_jones");
            
            PreparedStatement stm = con.prepareStatement("UPDATE jogador SET jogadas_ = ? WHERE Id_GamePlay = ?");
            
            stm.setInt(1, Sessao.usuarioLogado.getJogadas()); // Pega o as Jogadas do Usuário e atribui ao BD;
            stm.setInt(2, Sessao.usuarioLogado.getID()); // Pega o ID do usuário para atribuir a jogada;
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
    }
    
    public void gameNewVictory() throws ClassNotFoundException{ //Adiciona uma Vitória ao Usuário Conectado;
        
        //Parte 1: Aumentar Vitorias em Classe Usuário (Se não estiver conectado, não será armazenado);
        int a = Sessao.usuarioLogado.getVitorias();
        a++;
        Sessao.usuarioLogado.setVitorias(a);
        
        //Parte 2: Método Principal;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=Sansara3150@");
            
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE datadv_jones");
            
            PreparedStatement stm = con.prepareStatement("UPDATE jogador SET vitorias_ = ? WHERE Id_GamePlay = ?");
            
            stm.setInt(1, Sessao.usuarioLogado.getVitorias());
            stm.setInt(2, Sessao.usuarioLogado.getID());
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
    }
    
    
    public void gameNewLose() throws ClassNotFoundException{ //Adiciona uma Derrota ao Usuário conectado;
        
        //Parte 1: Aumentar Derrotas em Classe Usuário (Se não estiver conectado, não será armazenado);
        int a = Sessao.usuarioLogado.getDerrotas();
        a++;
        Sessao.usuarioLogado.setDerrotas(a);
        
        //Parte 2: Método Principal;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=Sansara3150@");
            
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE datadv_jones");
            
            PreparedStatement stm = con.prepareStatement("UPDATE jogador SET derrotas_ = ? WHERE Id_GamePlay = ?");
            
            stm.setInt(1, Sessao.usuarioLogado.getDerrotas());
            stm.setInt(2, Sessao.usuarioLogado.getID());
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
    }
    
    public void newGameEntry(int player, int cpu) throws ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=Sansara3150@");
            
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE datadv_jones");
            
            PreparedStatement stm = con.prepareStatement("INSERT INTO jogadas (process_process_id, pontos_player, pontos_cpu) values (?, ?, ?)");
            
            stm.setInt(1, Sessao.usuarioProcesso.getIdProcesso());

            stm.setInt(2, player);
            stm.setInt(3, cpu);
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
    }
    
    public void newGameOpen() throws ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=Sansara3150@");
            
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE datadv_jones");
            
            PreparedStatement stm = con.prepareStatement("INSERT INTO process (Jogador_Id_GamePlay) values (?)");
            
            stm.setInt(1, Sessao.usuarioLogado.getID());
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
    }
    
    public Process newGameReturn(){
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=Sansara3150@");
            
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE datadv_jones");
            
            PreparedStatement stm = con.prepareStatement("Select * from process where Jogador_Id_Gameplay = ?");
            
            stm.setInt(1, Sessao.usuarioLogado.getID());
            
            ResultSet result = stm.executeQuery();
            
            while (result.next()){
                
                this.proc.setIdJogador(result.getInt("Jogador_Id_Gameplay"));
                this.proc.setIdProcesso(result.getInt("process_id"));
                
            }
            
            stm.close();
            con.close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
        
        return this.proc;
    }
    
    public void newGamer(String user, String senha) throws ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=Sansara3150@");
            
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE datadv_jones");
            
            PreparedStatement stm = con.prepareStatement("INSERT INTO jogadores (user, Senha) values (?, ?)");
            
            stm.setString(1, user);
            stm.setString(2, senha);
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
    }
    
}
