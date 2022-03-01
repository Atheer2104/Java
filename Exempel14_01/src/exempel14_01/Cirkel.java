package exempel14_01;

import java.awt.Color;
import java.awt.Graphics;

public class Cirkel {

    private int x = 0;
    private int y = 0;
    private int diameter = 10;
    
    public Cirkel(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }
    
    public void rita(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, diameter, diameter);
    }
    
    public boolean ärTräffad(int musX, int musY) {
        boolean träffad = false;
        int dx = musX - (x + diameter / 2);
        int dy = musY - (y + diameter / 2);
        int ds2 = dx * dx + dy * dy;
        if (ds2 < (diameter / 2)* (diameter / 2)) {
            träffad = true;
        }
        return träffad;
    }
}
