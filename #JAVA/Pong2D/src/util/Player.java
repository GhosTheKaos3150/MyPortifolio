package util;

import java.awt.Color;
import pong2d.Pong2D;

public class Player {
    
    private int x;
    private int y;
    private int speed;
    private final int width, height;
    private final Color color;
    private final Ball ball;
    
    private boolean upY;
    private boolean downY;
    
    private final Pong2D jogo;
    
    public Player(int x, int y, int w, int h, Color color, Ball ball, Pong2D game) {
        
        this.x = x;
        this.y = y;
        this.speed = 5;
        this.width = w;
        this.height = h;
        this.color = color;
        this.ball = ball;
        this.jogo = game;
        
        this.upY = false;
        this.downY = false;
        
    }
    
    public void updateY (){
        
        if (isUpY() && !isDownY() && this.y > 0) {
            this.setY(this.y - this.getSpeed());
            
        } else if (!isUpY() && isDownY() && this.y+this.getHeight() < 480) {
            this.setY(this.y + this.getSpeed());
            
       }
        
    }
    
    public void upY (boolean up) {
        this.upY = up;
        
        if (up == true)
            this.downY = false;
        
    }
    
    public void downY(boolean down) {
        this.downY = down;
        
        if (down == true)
            this.upY = false;
     
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isUpY() {
        return upY;
    }

    public boolean isDownY() {
        return downY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
