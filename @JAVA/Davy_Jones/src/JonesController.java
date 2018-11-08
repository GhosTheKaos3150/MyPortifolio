
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class JonesController implements Initializable {
    
    UsuárioDAO user = new UsuárioDAO();
    Processo Game = new Processo();
    Contador count = new Contador();
    private Principal principal;
    private Stage dialogStage;
    
    private Principal x;
    @FXML
    private Label Msg;
    @FXML
    private Label PT_Pl;
    @FXML
    private Label PT_CPU;
    @FXML
    private Button Initial_Progress;
    @FXML
    private Button Play_Dot;
    @FXML
    private Button Desistir;
    @FXML
    private Button Play_EsP;
    @FXML
    private Button Card_Sac;
    @FXML
    private Label BoxText;
    @FXML
    private Label BoxPlayer;
    @FXML
    private Label NDado;
    @FXML
    private TextArea Rules;
    @FXML
    private TextField Cheat;
    @FXML
    private Button enable;
    @FXML
    private CheckBox ativado;
    @FXML
    private Button PLAY_DT;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //this.dialogStage.isFullScreen();
        
        try {
            this.setRules();
        } catch (IOException ex) {
            Logger.getLogger(JonesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void setMainApp(Principal principal){
        this.principal = principal;
        
    }
    
    public void setPrincipal(Principal a) {
        this.x = a;
    }

    
    public void setRules() throws FileNotFoundException, IOException{
        
        String a="";
        BufferedReader leitor = new BufferedReader(new FileReader("Files/rules.txt"));
        while (leitor.ready()){
            a += leitor.readLine();
            a += "\n";
        }
        Rules.appendText(a);
        leitor.close();
        
    }
    
    
    @FXML
    private void Initialize(ActionEvent event) throws ClassNotFoundException{
        
        Game.INITIAL_Process();
        PT_Pl.setText("0");
        PT_CPU.setText("0");
        Initial_Progress.setDisable(true);
        Desistir.setDisable(false);
        Play_EsP.setDisable(false);
        Play_Dot.setDisable(false);
        Card_Sac.setDisable(false);
        if (Sessao.enableD20 == true) {
            PLAY_DT.setDisable(false);
        }
        NDado.setText(Integer.toString(Game.DadosEsp));
        
        this.user.newGameOpen();
        
        Msg.setText("Jogo INICIADO!");
        
    }


    @FXML
    private void DotRoll(ActionEvent event) throws IOException, ClassNotFoundException {
        
        BoxPlayer.setText("Você joga os dados!");
        Game.Normal_GamePl();
        if (Game.getPT_Player() >= 0){
            PT_Pl.setText(Integer.toString(Game.getPT_Player()));
        }else {
            PT_Pl.setText("0");
            Game.setPT_Player(0);
        }
        
        
        
        Random t = new Random();
        int dotA = t.nextInt(6);
        int x = t.nextInt(2);
                
        if (dotA != 5) {
            switch (dotA) {
                
                case 0:
                    if (x != 1) {
                        BoxText.setText("CPU sacou o Joker. CPU perdeu a Vez");
                        PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                        
                    } else if (x == 1 && Sessao.enableCPUEspecial == true) {
                        BoxText.setText("CPU jogou Dados Especiais;");
                        Game.Especial_ProcessCPU();
                        
                        if (Game.getPT_CPU() >= 0) {
                            PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                        } else {
                            PT_CPU.setText("0");
                            Game.setPT_CPU(0);
                        }
                        
                    }
                    
                    break;
                case 1:
                    BoxText.setText("CPU sacou A Rainha.");
                    Game.Queen_GameCPU();
                    if (Game.getPT_CPU() >= 0) {
                        PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                    } else {
                        PT_CPU.setText("0");
                        Game.setPT_CPU(0);
                    }
                    break;
                case 2:
                    BoxText.setText("CPU sacou O Rei.");
                    Game.King_GameCPU();
                    if (Game.getPT_CPU() >= 0) {
                        PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                    } else {
                        PT_CPU.setText("0");
                        Game.setPT_CPU(0);
                    }
                    break;
                case 3:
                    BoxText.setText("CPU sacou O Valete.");                    
                    Game.Valet_GameCPU();
                    if (Game.getPT_CPU() >= 0) {
                        PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                    } else {
                        PT_CPU.setText("0");
                        Game.setPT_CPU(0);
                    }
                    break;
                case 4:
                    BoxText.setText("CPU não sacou cartas.");
                    Game.Normal_GameCPU();
                    if (Game.getPT_CPU() >= 0) {
                        PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                    } else {
                        PT_CPU.setText("0");
                        Game.setPT_CPU(0);
                    }
                    break;
                default:
                    System.out.print("3RR0R UnKn0wN");
            }
        }else if (Sessao.enableCPUPassTurn == true && dotA == 5){
            
            BoxText.setText("CPU passou a vez.");
            PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
            
        }
            
            int X = Game.getPT_CPU();
            int Y = Game.getPT_Player();
        
        user.newGameEntry(Game.getPT_Player(), Game.getPT_CPU());

        this.GiveUp_CPU();
        
        if(X >= Sessao.pontuation){
            Msg.setText("Você Perdeu.");
            Game.INITIAL_Process();
            
            Initial_Progress.setDisable(false);
            Desistir.setDisable(true);
            Play_EsP.setDisable(true);
            Play_Dot.setDisable(true);
            Card_Sac.setDisable(true);
            PLAY_DT.setDisable(true);
            
            user.gameNewRun();
            user.gameNewLose();
            
        }else if(Y >= Sessao.pontuation){
            Msg.setText("Você Ganhou.");
            Game.INITIAL_Process();
            
            Initial_Progress.setDisable(false);
            Desistir.setDisable(true);
            Play_EsP.setDisable(true);
            Play_Dot.setDisable(true);
            Card_Sac.setDisable(true);
            PLAY_DT.setDisable(true);
            
            user.gameNewRun();
            user.gameNewVictory();
        
        }
        
        
    }

    @FXML
    private void TakeCard(ActionEvent event) throws ClassNotFoundException {
        Random rd = new Random();
        
        int qlq = rd.nextInt(4);
        
        switch (qlq){
            
            case 0:
                
                BoxPlayer.setText("Você sacou A Rainha!");
                Game.Queen_GamePL();
                if (Game.getPT_Player() >= 0){
                    PT_Pl.setText(Integer.toString(Game.getPT_Player()));
                }else {
                    PT_Pl.setText("0");
                    Game.setPT_Player(0);
                }
                
                Random a = new Random();
                int dotA = a.nextInt(6);
                
                if (dotA != 5) {
                    switch (dotA) {
                        
                        case 0:
                            BoxText.setText("CPU sacou o Joker. CPU perdeu a Vez");
                            PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            
                            break;
                        case 1:
                            BoxText.setText("CPU sacou A Rainha.");
                            Game.Queen_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 2:
                            BoxText.setText("CPU sacou O Rei.");
                            Game.King_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 3:
                            BoxText.setText("CPU sacou O Valete.");                            
                            Game.Valet_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 4:
                            BoxText.setText("CPU não sacou cartas.");
                            Game.Normal_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        default:
                            System.out.print("3RR0R UnKn0wN");
                    }
                }else if (Sessao.enableCPUPassTurn == true && dotA == 5){
            
                     BoxText.setText("CPU passou a vez.");
                    PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
            
                }
                
            case 1:
                
                BoxPlayer.setText("Você sacou O Rei!");
                Game.King_GamePL();
                if (Game.getPT_Player() >= 0){
                    PT_Pl.setText(Integer.toString(Game.getPT_Player()));
                }else {
                    PT_Pl.setText("0");
                    Game.setPT_Player(0);
                }
                
                Random b = new Random();
                int dotB = b.nextInt(6);
                
                if (dotB != 5) {
                    switch (dotB) {
                        
                        case 0:
                            BoxText.setText("CPU sacou o Joker. CPU perdeu a Vez");
                            PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            
                            break;
                        case 1:
                            BoxText.setText("CPU sacou A Rainha.");
                            Game.Queen_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 2:
                            BoxText.setText("CPU sacou O Rei.");
                            Game.King_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 3:
                            BoxText.setText("CPU sacou O Valete.");                            
                            Game.Valet_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 4:
                            BoxText.setText("CPU não sacou cartas.");
                            Game.Normal_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        default:
                            System.out.print("3RR0R UnKn0wN");
                    }
                }else if (Sessao.enableCPUPassTurn == true && dotB == 5){
            
                    BoxText.setText("CPU passou a vez.");
                    PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
            
                  }
                
                
            break;
            case 2:
                
                BoxPlayer.setText("Você sacou O Valete!");
                Game.Valet_GamePl();
                if (Game.getPT_Player() >= 0){
                    PT_Pl.setText(Integer.toString(Game.getPT_Player()));
                }else {
                    PT_Pl.setText("0");
                    Game.setPT_Player(0);
                }
                
                Random c = new Random();
                int dotC = c.nextInt(6);
                
                if (dotC != 5) {
                    switch (dotC) {
                        
                        case 0:
                            BoxText.setText("CPU sacou o Joker. CPU perdeu a Vez");
                            PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            
                            break;
                        case 1:
                            BoxText.setText("CPU sacou A Rainha.");
                            Game.Queen_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 2:
                            BoxText.setText("CPU sacou O Rei.");
                            Game.King_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 3:
                            BoxText.setText("CPU sacou O Valete.");                            
                            Game.Valet_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 4:
                            BoxText.setText("CPU não sacou cartas.");
                            Game.Normal_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        default:
                            System.out.print("3RR0R UnKn0wN");
                    }
                }else if (Sessao.enableCPUPassTurn == true && dotC == 5){
            
                     BoxText.setText("CPU passou a vez.");
                     PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
            
                 }
                
            break;
            case 3:
                
                BoxPlayer.setText("Você sacou O Joker. Você perdeu a vez.");
                
                Random d = new Random();
                int dotD = d.nextInt(6);
                
                if (dotD != 5) {
                    switch (dotD) {
                        
                        case 0:
                            BoxText.setText("CPU sacou o Joker. CPU perdeu a Vez");
                            PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            
                            break;
                        case 1:
                            BoxText.setText("CPU sacou A Rainha.");
                            Game.Queen_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 2:
                            BoxText.setText("CPU sacou O Rei.");
                            Game.King_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 3:
                            BoxText.setText("CPU sacou O Valete.");                            
                            Game.Valet_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        case 4:
                            BoxText.setText("CPU não sacou cartas.");
                            Game.Normal_GameCPU();
                            if (Game.getPT_CPU() >= 0) {
                                PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
                            } else {
                                PT_CPU.setText("0");
                                Game.setPT_CPU(0);
                            }
                            break;
                        default:
                            System.out.print("3RR0R UnKn0wN");
                    }
                }else if (Sessao.enableCPUPassTurn == true && dotD == 5){
            
                     BoxText.setText("CPU passou a vez.");
                     PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
            
                }
                
            break;
            default:
                System.out.print("3RR0R UnKn0wN");
            
        }
        
        int X = Game.getPT_CPU();
        int Y = Game.getPT_Player();
        
        user.newGameEntry(Game.getPT_Player(), Game.getPT_CPU());
        
        this.GiveUp_CPU();
        
        if(X >= Sessao.pontuation){
            Msg.setText("Você Perdeu.");
            Game.INITIAL_Process();
            
            Initial_Progress.setDisable(false);
            Desistir.setDisable(true);
            Play_EsP.setDisable(true);
            Play_Dot.setDisable(true);
            Card_Sac.setDisable(true);
            PLAY_DT.setDisable(true);
            
            user.gameNewRun();
            user.gameNewLose();
            
        }else if(Y >= Sessao.pontuation){
            Msg.setText("Você Ganhou.");
            Game.INITIAL_Process();
            
            Initial_Progress.setDisable(false);
            Desistir.setDisable(true);
            Play_EsP.setDisable(true);
            Play_Dot.setDisable(true);
            Card_Sac.setDisable(true);
            PLAY_DT.setDisable(true);
            
            user.gameNewRun();
            user.gameNewVictory();
        
        }
        
    }

    @FXML
    private void EspecialRoll(ActionEvent event) throws ClassNotFoundException {
        
        if (Game.DadosEsp != 0) {
            BoxPlayer.setText("Você jogou Dado Especial!");
            Game.Especial_Process();
            PT_Pl.setText(Integer.toString(Game.getPT_Player()));
            PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
            
            Game.DadosEsp--;
            NDado.setText(Integer.toString(Game.DadosEsp));
            
        }else{
            Msg.setText("Você não pode usar dados Especiais.");
        }
        
    }

    @FXML
    private void Get_OverIT(ActionEvent event) {
        
        Msg.setText("Você se Entregou.");
        Game.END_Process();
        PT_Pl.setText("0");
        PT_CPU.setText("0");
        Initial_Progress.setDisable(false);
        Desistir.setDisable(true);
        Play_EsP.setDisable(true);
        Play_Dot.setDisable(true);
        Card_Sac.setDisable(true);
        PLAY_DT.setDisable(true);
    }
    
    private void GiveUp_CPU() {
        
        Random possibilitie = new Random();
        int x = possibilitie.nextInt(4);
        
        if (Game.getPT_CPU() >= (Sessao.pontuation * 0.75) && x == 4) {
            Msg.setText("CPU se Entregou.");
            Game.END_Process();
            PT_Pl.setText("0");
            PT_CPU.setText("0");
            Initial_Progress.setDisable(false);
            Desistir.setDisable(true);
            Play_EsP.setDisable(true);
            Play_Dot.setDisable(true);
            Card_Sac.setDisable(true);
            PLAY_DT.setDisable(true);
        }
    }

    @FXML
    private void Exit0(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void MenuIniciarGM(ActionEvent event) throws IOException, ClassNotFoundException {
        this.Initialize(event);
    }

    @FXML
    private void AtivarCheat(ActionEvent event) {
        
        if (enable.isPressed()) {
            
            String leitura = Cheat.getAccessibleText();
            Game.CHEAT(leitura);
            NDado.setText(Integer.toString(Game.DadosEsp));
            
        }
        
    }

    @FXML
    private void SeAtivado(ActionEvent event) {
        
        if (ativado.isSelected() == true){
            
            enable.setDisable(false);
            Cheat.setDisable(false);
            
        }else {
            
            enable.setDisable(true);
            Cheat.setDisable(true);
            
        }
        
    }

    @FXML
    private void DT_Roll(ActionEvent event) throws ClassNotFoundException {
        
        if (Game.DadosDT != 0){
            
            BoxPlayer.setText("Você jogou um D20!");
            Game.DVinte();
            PT_Pl.setText(Integer.toString(Game.getPT_Player()));
            PT_CPU.setText(Integer.toString(Game.getPT_CPU()));
            
            Game.DadosDT--;
            
            this.PLAY_DT.setDisable(true);
            
        }else{
            
            Msg.setText("Você já usou o D20 nessa rodada!");
            
        }
        
    }

    @FXML
    private void Profile(ActionEvent event) {
        
        if (Sessao.usuarioLogado != null){
           this.principal.janelaUsuario_Profile();
        }else{
            this.principal.janelaUsuario_logOn();
        }
        
    }

    @FXML
    private void LogOn(ActionEvent event) {
        this.principal.janelaUsuario_logOn();
        
    }

    @FXML
    private void LogOff(ActionEvent event) {
        
        this.Msg.setText("Você foi desconectado com sucesso.");
        
    }

    @FXML
    private void Cadastro(ActionEvent event) {
        
        this.principal.janelaUsuario_Cadastro();
        
    }

    @FXML
    private void proprietades(ActionEvent event) {
        
        this.principal.janelaPropriedades();
        
    }

    
}
