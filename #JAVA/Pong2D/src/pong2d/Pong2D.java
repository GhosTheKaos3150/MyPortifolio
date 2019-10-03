package pong2d;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import util.*;

public class Pong2D extends JPanel implements Runnable, KeyListener {

    Player P1 = new Player(0, 205, 20, 70, Color.GRAY, this.ball, this);
    Player P2 = new Player(620, 205, 20, 70, Color.GRAY, this.ball, this);
    
    Ball ball = new Ball(20, 20, this.P1, this.P2);
    Controlador cntrl = new Controlador(ball, P1, P2);
    
    private static final int WND_WIDTH = 640;
    private static final int WND_HEIGHT = 480;
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame ("Pong2D");
        window.setVisible(true);
        window.setSize(646, 510);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);
        
        Pong2D canvas = new Pong2D();
        canvas.setBounds(0, 0, WND_WIDTH, WND_HEIGHT);
        canvas.setVisible(true);
        
        window.add(canvas);
        
        window.addKeyListener(canvas);
        
    } 
    
    public Pong2D() {
        
        Thread jogo = new Thread(this);
        jogo.start();
        
        
    }
    
    @Override
    public void run() {
        
        do {
            
           this.loop();
           this.repaint();
           this.waitDeltaTime();
            
        }while (true);
        
    }
    
    public void loop (){
        
        if (cntrl.isPlaying()) {            
            ball.updateCoordinate();
            ball.isBallAtWall();
            P1.updateY();
            P2.updateY();
            
            if (ball.getxCoordinate() == 0) {
                
                cntrl.sumPlacarP2();
                ball.reload();
                
            } else if (ball.getxCoordinate() == 640 - ball.getHeight()) {
                
                cntrl.sumPlacarP1();
                ball.reload();
                
            }
            
            if (ball.getxCoordinate() <= (P1.getX() + P1.getWidth())
                    && (ball.getyCoordinate() >= P1.getY() && ball.getyCoordinate() + ball.getHeight() <= P1.getY() + P1.getHeight())) {
                this.ball.invertSpeed();
                this.ball.updateRebatidas();
                
            }
            
            if (ball.getxCoordinate() + ball.getWidth() >= P2.getX()
                    && (ball.getyCoordinate() >= P2.getY() && ball.getyCoordinate() + ball.getHeight() <= P2.getY() + P2.getHeight())) {
                this.ball.invertSpeed();
                this.ball.updateRebatidas();
                
            }
        }
        
    }
    
    public void waitDeltaTime() {
        
        try {
            
            Thread.sleep(15);
            
        } catch (InterruptedException ex) {
            
            Logger.getLogger(Pong2D.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 640, 480);
        
        g.setColor(Color.GRAY);
        g.drawLine(640/2, 0, 640/2, 480);
        g.drawOval(0-30, (480/2)-30, 60, 60);
        g.drawOval(640-30, (480/2)-30, 60, 60);
        
        if (cntrl.isPlaying()) {
            
            g.setColor(Color.WHITE);
            g.fillOval(ball.getxCoordinate(), ball.getyCoordinate(), ball.getWidth(), ball.getHeight());
            
            g.setColor(this.P1.getColor());
            g.fillRect(this.P1.getX(), this.P1.getY(), this.P1.getWidth(), this.P1.getHeight());
            
            g.setColor(this.P2.getColor());
            g.fillRect(this.P2.getX(), this.P2.getY(), this.P2.getWidth(), this.P2.getHeight());
            
            g.setColor(Color.yellow);
            g.drawString(Integer.toString(cntrl.getPlacarP1()), 640 / 4, 20);
            g.drawString(Integer.toString(cntrl.getPlacarP2()), 640 / 2 + 640 / 4, 20);
            
        }else{      
            g.setColor(Color.YELLOW);
            g.drawString("PRESS ENTER TO BEGIN", 240, 320-75);
            
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        // TODO
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (this.cntrl.isPlaying()) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                P1.upY(true);
            }
            
            if (e.getKeyCode() == KeyEvent.VK_S) {
                P1.downY(true);
            }
            
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                P2.upY(true);
            }
            
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                P2.downY(true);
            }
        } else {
            
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            this.cntrl.setPlaying(true);
            
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_W)
            P1.upY(false);
        
        if (e.getKeyCode() == KeyEvent.VK_S)
            P1.downY(false);
        
        if (e.getKeyCode() == KeyEvent.VK_UP)
            P2.upY(false);
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            P2.downY(false);
        
    }
    
}
