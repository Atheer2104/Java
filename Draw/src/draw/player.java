package draw;

import java.awt.Image;
import javax.swing.ImageIcon;

public class player {
    private int direction = 0;
    private Image pacUp, pacDown, pacRight, pacLeft; 
    private int x = 150;
    private int y = 150;
    
    public player() {
        pacUp = new ImageIcon("/Users/elev/NetBeansProjects/Draw/pacmanUP.jpg").getImage();
        pacDown = new ImageIcon("/Users/elev/NetBeansProjects/Draw/pacmanDown.jpg").getImage();
        pacRight = new ImageIcon("/Users/elev/NetBeansProjects/Draw/pacmanRight.jpg").getImage();
        pacLeft = new ImageIcon("/Users/elev/NetBeansProjects/Draw/pacmanLeft.jpg").getImage();
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void changeY(int value) {
        y+= value;
    }
    
    public void changeX(int value) {
        x+= value;
    }
    
    public Image getPacUp() {
        return pacUp;
    }
    
    public Image getPacDown() {
        return pacDown;
    }
    
    public Image getPacRight() {
        return pacRight;
    }
    
    public Image getPacLeft() {
        return pacLeft;
    }
   
    public int getDirection() {
        return direction;
    }
    
    public void setDirection(int value) {
        direction = value;
    }
    

    
    
    
    
}
