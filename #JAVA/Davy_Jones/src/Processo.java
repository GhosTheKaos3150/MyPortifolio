import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Processo {
    
    //CHEATS:
    
    public String [] Cheats = {"AA01","AA02","AA03"};
    
    //Argumentos:
    
    Dados DA = new Dados(); // Dados Dourados
    Dados DV = new Dados(); // Dados de Sangue
    
    Dados EsP = new Dados(); // Dados Especiais
    
    Dados DVinte = new Dados(); //D20
    
    UsuárioDAO dao = new UsuárioDAO(); // DAO do Usuário
    Principal main = new Principal();
    
    private int PT_Player, PT_CPU;
    private int DadoA_Player, DadoV_Player;
    private int DadoA_CPU, DadoV_CPU;
    
    public int DadosEsp = 0;
    public int DadosDT = 0;
    
    //Métodos;
    
    
    
    public int getPT_Player(){
        
        return this.PT_Player;
        
    }
    
    public int getPT_CPU(){
        
        return this.PT_CPU;
        
    }
    
    public void setPT_Player(int player){
        
        this.PT_Player = player;
        
    }
    
    public void setPT_CPU(int cpu){
        
        this.PT_CPU = cpu;
        
    }
    
    public void INITIAL_Process() throws ClassNotFoundException{ //Processo Inicial - Abre o Jogo;
        boolean x = true;
        while (x == true){
            if (Sessao.usuarioLogado != null){
        
            this.DadosEsp = 5;
            this.DadosDT = 1;
            this.PT_Player = this.PT_CPU = 0;
        
            
            
            Sessao.usuarioProcesso = dao.newGameReturn();
            
                x = false;
            
            }else{
            
                main.janelaUsuario_logOn();
            
            }
         
        }
        
    }
    
    public void Normal_GamePl(){
        
       this.DadoA_Player += DA.roll();
       this.DadoA_Player += DA.roll();
       this.DadoA_Player += DA.roll();
       
       this.DadoV_Player += DV.roll();
       this.DadoV_Player += DV.roll();
       this.DadoV_Player += DV.roll();
       
       this.PT_Player += this.DadoA_Player - this.DadoV_Player;
       
       this.DadoV_Player = this.DadoA_Player = 0;
       
        
    }
    
    public void Normal_GameCPU(){
        
       this.DadoA_CPU += DA.roll();
       this.DadoA_CPU += DA.roll();
       this.DadoA_CPU += DA.roll();
       
       this.DadoV_CPU += DV.roll();
       this.DadoV_CPU += DV.roll();
       this.DadoV_CPU += DV.roll();
       
       this.PT_CPU += this.DadoA_CPU - this.DadoV_CPU;
       
       this.DadoV_CPU = this.DadoA_CPU = 0;
        
    }
    
    public void Queen_GamePL(){
        
        DadoA_Player += DA.roll();
        DadoA_Player += DA.roll();
        DadoA_Player += DA.roll();
        
        this.PT_Player += DadoA_Player;
        DadoA_Player = 0;
        
    }
    
    public void Queen_GameCPU(){
        
        DadoA_CPU += DA.roll();
        DadoA_CPU += DA.roll();
        DadoA_CPU += DA.roll();
        
        this.PT_CPU += DadoA_CPU;
        DadoA_CPU = 0;
        
    }
    
    public void King_GamePL(){
        
        this.PT_Player = this.PT_CPU;
        
    }
    
    public void King_GameCPU(){
        
        this.PT_CPU = this.PT_Player;
        
    }
    
    public void Valet_GamePl(){
        
        DadoV_CPU += DV.roll();
        DadoV_CPU += DV.roll();
        DadoV_CPU += DV.roll();
        
        if (this.PT_CPU >= 0) {
            this.PT_CPU -= DadoV_CPU;
        }else{
            this.PT_CPU = 0;
        }
        DadoV_CPU = 0;
        
        DadoA_Player += DA.roll();
        DadoA_Player += DA.roll();
        DadoA_Player += DA.roll();
        
        this.PT_Player += DadoA_Player;
        DadoA_Player = 0;
        
    }
    
    public void Valet_GameCPU(){
        
        DadoV_Player += DV.roll();
        DadoV_Player += DV.roll();
        DadoV_Player += DV.roll();
        
        if (this.PT_Player >= 0) {
            this.PT_Player -= DadoV_Player;
        }else{
            this.PT_Player = 0;
        }
        DadoV_Player = 0;
        
        DadoA_CPU += DA.roll();
        DadoA_CPU += DA.roll();
        DadoA_CPU += DA.roll();
        
        this.PT_CPU += DadoA_CPU;
        DadoA_CPU = 0;
        
        
    }
    
    public void Especial_Process() throws ClassNotFoundException{ //Efeito Aleatório do Dado Especial;
        
        
        
        int Result = EsP.roll();
        
        switch (Result){
            
            case 1:
                this.PT_Player += 15;
                break;
            case 4:
                this.PT_Player += 15;
                break;
            case 2:
                if (this.PT_CPU > 0) {
                    this.PT_CPU -= 15;
                }else{
                    this.PT_CPU = 0;
                }
                break;
            case 5:
                if (this.PT_CPU > 0) {
                    this.PT_CPU -= 15;
                }else{
                    this.PT_CPU = 0;
                }
                break;
            case 3:
                this.PT_CPU = 0;
                break;
            case 6:
                this.PT_Player = 0;
                break;
            
        }
        
        dao.newGameEntry(this.PT_Player, this.PT_CPU);
        
    }

    public void Especial_ProcessCPU() throws ClassNotFoundException{ //Efeito Aleatório do Dado Especial;
        
        
        
        int Result = EsP.roll();
        
        switch (Result){
            
            case 1:
                this.PT_Player += 15;
                break;
            case 4:
                this.PT_Player += 15;
                break;
            case 2:
                if (this.PT_CPU > 0) {
                    this.PT_CPU -= 15;
                }else{
                    this.PT_CPU = 0;
                }
                break;
            case 5:
                if (this.PT_CPU > 0) {
                    this.PT_CPU -= 15;
                }else{
                    this.PT_CPU = 0;
                }
                break;
            case 3:
                this.PT_CPU = 0;
                break;
            case 6:
                this.PT_Player = 0;
                break;
            
        }
        
        dao.newGameEntry(this.PT_Player, this.PT_CPU);
        
    }
    
    public void DVinte () throws ClassNotFoundException{
        
        Random r = new Random();
        int x = r.nextInt(6);
        
        switch(x+1){
            
            case 1:
                PT_Player = 0 + (DVinte.rool_DVinte()*2);
                break;
            case 2:
                PT_CPU = 0;
                PT_Player += DVinte.rool_DVinte()*2;
                break;
            case 3:
                PT_Player = 0;
                PT_CPU += DVinte.rool_DVinte()*2;
                break;
            case 4:
                PT_CPU = 0 + (DVinte.rool_DVinte()*2);
                break;
            case 5:
                PT_Player = PT_CPU = 0;
                break;
            case 6:
                PT_Player = PT_CPU = 74;
                break;
            default:
                System.out.print("Error");
                
        }
        
        dao.newGameEntry(this.PT_Player, this.PT_CPU);
        
    }
    
    public void CHEAT(String read){
        
        String Acess = read;
        
        for (int cntrl=0; cntrl<=this.Cheats.length; cntrl++){
            
            if (this.Cheats[cntrl].equals(Acess) && Acess.equals("AA01") ){
                
                this.PT_Player = 70;
                
            }else if (this.Cheats[cntrl].equals(Acess) && Acess.equals("AA02") ){
                
                this.PT_CPU = 0;
                
            }else if (this.Cheats[cntrl].equals(Acess) && Acess.equals("AA03") ){
                
                this.DadosEsp = 100;
                
            }
            
        }
        
    }
    
    public void END_Process(){
        
        this.PT_Player = this.PT_CPU = 0;
        
    }
    
    
}
