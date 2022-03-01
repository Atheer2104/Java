package exempel14_01;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;

public class samlingarKap14 extends JFrame{
    private Exempel14_01 pan;
    
    public samlingarKap14(){
       pan = new Exempel14_01();
       pan.addMouseListener(new MyMouseListener());
     
        this.setContentPane(pan);
        this.setSize(new Dimension(200, 150));
        this.setVisible(true);
    }
    
    private class MyMouseListener extends MouseAdapter{ 
      public void mouseClicked(MouseEvent me){

          pan.formMouseClicked(me);
      } 
  }
    public static void main(String[] args) {
        // TODO code application logic here
        new samlingarKap14();
          
    }
}
