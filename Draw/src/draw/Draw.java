package draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Draw extends JPanel implements KeyListener {
    private JFrame frame;
    player pc;
    
    public Draw() {
        pc = new player();
        frame = new JFrame("Draw");
        frame.addKeyListener(this);
        frame.setContentPane(this);
        frame.setSize(300,300);
        
        frame.setVisible(true);
    }
    
    public void paintComponent(Graphics g) {
        //g.setColor(Color.red);
        //g.drawString("Draw", x++, y++);
        g.setColor(Color.blue);
        //g.fillRect(x, y, 50, 50);
        //g.drawImage(pc.getImage(3), pc.getX(), pc.getX(), null);
        if (pc.getDirection() == 1) {
            //g.fillRect(x, y--, 50, 50);
            g.drawImage(pc.getPacUp(), pc.getX(), pc.getY(), null);
        }else if (pc.getDirection() == 2) {
            //g.fillRect(x, y++, 50, 50);
             g.drawImage(pc.getPacDown(), pc.getX(), pc.getY(), null);
        }else if (pc.getDirection() == 3) {
            //g.fillRect(x++, y, 50, 50);
            g.drawImage(pc.getPacRight(), pc.getX(), pc.getY(), null);
        }else {
            //g.fillRect(x--, y, 50, 50);
            g.drawImage(pc.getPacLeft(), pc.getX(), pc.getY(), null);
        }
    }
    
    
    public static void main(String[] args) {
        new Draw();
    }

    
    public void keyTyped(KeyEvent e) {
    }

    
    public void keyPressed(KeyEvent e) { 
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pc.changeY(-1);
            pc.setDirection(1);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pc.changeY(1);
            pc.setDirection(2);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pc.changeX(1);
            pc.setDirection(3);
            repaint();
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            pc.changeX(-1);
            pc.setDirection(4);
            repaint();
        }
    }

  
    public void keyReleased(KeyEvent e) {
    }
    
}
