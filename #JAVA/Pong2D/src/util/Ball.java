package util;
public class Ball {
    
    private final Player jogador1;
    private final Player jogador2;
    
    private final int height;
    private final int width;
    private int xCoordinate;
    private int yCoordinate;
    private int speed;
    private int xSpeed;
    private int ySpeed;
    private int rebatidas;
    
    public Ball (int h, int w, Player player1, Player player2){
        
        this.jogador1 = player1;
        this.jogador2 = player2;
        
        this.height = h;
        this.width = w;
        
        this.xCoordinate = (640/2) - w/2;
        this.yCoordinate = (480/2) - h/2;
        
        this.xSpeed = this.ySpeed = this.speed = 2;
        
        this.xSpeed *= -1;
        this.ySpeed *= -1;
        
        this.rebatidas = 0;
        
    }
    
    public boolean isBallAtWall(){
        
        if (this.getyCoordinate() <= 0 || this.getyCoordinate() >= 480-this.getHeight()) {
            
            this.invertYSpeed();
            return true;
            
        }
        
        return false;
        
    }
    
    public void updateCoordinate (){
        
        // Dá update nas coordenadas, somando a coordenada em X e Y às suas
        //respectivas velocidades.
        
        this.xCoordinate += this.speed;
        this.yCoordinate += this.ySpeed;
        
    }
    
    public void reload(){
        
        /*
        Dá reload nas bola, recentralizando no cenário e redefinindo velocidade.
        */
        
        this.xCoordinate = (640/2) - this.width/2;
        this.yCoordinate = (480/2) - this.height/2;
        
        this.invertSpeed();
        
        this.xSpeed = this.ySpeed = this.speed;
        
    }
    
    public void updateRebatidas(){
        this.rebatidas++;
        
        if (this.rebatidas == 3){
            
            this.rebatidas = 0;
            this.updateGameSpeed();
            
        }
        
    }
    
    private void updateGameSpeed(){
        
        if (this.ySpeed > 0) {
            this.ySpeed += 2;
            
        }else{
            this.ySpeed -= 2;
            
        }
        
    }
    
    public void invertSpeed(){
        
        this.speed *= -1;
        
    }
    
    public void invertXSpeed(){
        
        // Inverte a velocidade no Eixo X
        
        this.xSpeed *= -1;
        
    }
    
    public void invertYSpeed(){
        
        // Inverte a velocidade no Eixo Y
        
        this.ySpeed *= -1;
        
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }
    
}
