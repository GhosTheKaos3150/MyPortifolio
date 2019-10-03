package util;

public class Controlador {
    
    private int placarP1;
    private int placarP2;
    private int rebatidas;
    private final Ball ball;

    private boolean playing;
    
    private Player p1;
    private Player p2;
    
    public Controlador (Ball b, Player p1, Player p2){
        
        this.playing = false;
        
        this.placarP1 = 0;
        this.placarP2 = 0;
        this.rebatidas = 0;
        
        this.ball = b;
        
        this.p1 = p1;
        this.p2 = p2;
        
    }
    
    public void reloadGame (){
        
        this.placarP1 = 0;
        this.placarP2 = 0;
        this.rebatidas = 0;
        this.setPlaying(false);
        
        this.p1.setX(0);
        this.p1.setY(205);
        
        this.p2.setX(620);
        this.p2.setY(205);
        
    }
    
    public void sumPlacarP1() {
        
        if (this.placarP1 == 9){
            this.reloadGame();
            return;
        }
        
        this.placarP1++;
    }

    public void sumPlacarP2() {
        
        if (this.placarP2 == 9){
            this.reloadGame();
            return;
        }
        
        this.placarP2++;
    }
    
    public int getPlacarP1() {
        return placarP1;
    }

    public int getPlacarP2() {
        return placarP2;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    
}
