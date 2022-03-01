package exempel14_01;

import java.awt.*;
import java.util.*;

public class Exempel14_01 extends javax.swing.JPanel {
    private ArrayList<Cirkel> cirklar = new ArrayList<>();
    private boolean speletÄrSlut = false;
    
    public Exempel14_01() {
        for (int rad = 0; rad < 4; rad++) {
            for (int kolumn = 0; kolumn < 6; kolumn++) {
                int x = 10 + 30 * kolumn;
                int y = 10 + 30 * rad;
                int diameter = 20;
                Cirkel cirkel = new Cirkel(x, y, diameter);
                cirklar.add(cirkel);
            }
        }
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < cirklar.size(); i++) {
            Cirkel cirkel = cirklar.get(i);
            cirkel.rita(g);
        }
        
        if (speletÄrSlut) {
            String text = "Grattis!";
            Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
            g.setFont(font);
            g.setColor(Color.blue);
            
            int x = 25;
            int y = 30;
            g.drawString(text, x, y);
        }
    }
    
    public void formMouseClicked(java.awt.event.MouseEvent evt) {
        boolean träff = false;
        for (int i = 0; i < cirklar.size() && !träff; i++) {
            Cirkel cirkel = cirklar.get(i);
            if (cirkel.ärTräffad(evt.getX(), evt.getY())) {
                cirklar.remove(i);
                träff = true;
            }
        }
        
        if (cirklar.isEmpty()) {
            speletÄrSlut = true;
        }
        repaint();
    }
    
    
}
