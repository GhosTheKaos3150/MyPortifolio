
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuário {
    
    //Atributos:
    
    private int id;
    private String nome;
    private int jogadas;
    private int vitórias;
    private int derrotas;
    private int experiencia;
    private String Senha;
    
    //Contrutor:
    
    public Usuário(){
        
        this.id = 0;
        this.nome = null;
        this.jogadas = 0;
        this.vitórias = 0;
        this.derrotas = 0;
        this.experiencia = 0;
        this.Senha = null;
        
    }
    
    // Métodos
    //Getters e Setters:
    
    public int getID (){
        return id;
        
    }
    
    public String getNome (){
        return nome;
        
    }
    
    public int getJogadas (){
        return jogadas;
        
    }
    
    public int getVitorias (){
        return vitórias;
        
    }
    
    public int getDerrotas(){
        return derrotas;
        
    }
    
    public int getXP (){
        return experiencia;
        
    }
    
    public String getSenha (){
        return Senha;
        
    }
    
    public void setID (int ID){ //Set (INT)Id_GamePlay;
        this.id = ID;
        
    }
    
    public void setNome (String nome){ //Set (VarChar)user;
        this.nome = nome;
        
    }
    
    public void setJogadas (int jogadas){ //Set (INT)jogadas_;
        this.jogadas = jogadas;
        
    }
    
    public void setVitorias (int vitorias){ //Set (INT)vitorias_;
        this.vitórias = vitorias;
        
    }
    
    public void setDerrotas(int derrotas){ //Set (INT)derrotas_;
        this.derrotas = derrotas;
        
    }
    
    public void setXP (int xp){ //Set (INT)Experience;
        this.experiencia = xp;
        
    }
    
    public void setSenha (String senha){ //Set (INT)Senha;
        this.Senha = senha;
        
    }

    void LogOn(Integer integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
