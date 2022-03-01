package converter;

import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class Converter {
    private JFrame frame;
    private JPanel background;
    private JTextField tf;
    private JLabel l;
    private JButton b_hkkw, b_kwhk;
    
    public void init() {
        //skapar grafiska kompnenter (objekt)
        frame = new JFrame("Converter");
        background = new JPanel();
        tf = new JTextField(12);
        l = new JLabel("");
        b_hkkw = new JButton("hk->kW");
        b_kwhk = new JButton("kW->hk");
        //registera lyssnare till knapparna
        b_hkkw.addActionListener(new HKListner());
        b_kwhk.addActionListener(new KWListner());
        
        //lägger in komponenter i oanel
        background.setLayout(new GridLayout(2,2));
        background.add(tf);
        background.add(l);
        background.add(b_hkkw);
        background.add(b_kwhk);
        
        //visar upp GUI
        frame.setContentPane(background);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        

        }
    
    private class HKListner implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {
            // 100 kw är 136 hk
            double hk = Double.parseDouble(tf.getText());
            double kw = hk /1.3626;
            
            l.setText(hk + " hk = " + (int)kw + " kw");
            
        }
    }
    
    private class KWListner implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {
            // 100 kw är 136 hk
            double kw = Double.parseDouble(tf.getText());
            double hk = kw * 1.3626;
            
            l.setText(kw + " kw = " + (int)hk + " hk");
            
        }
    }
    
    public static void main(String[] args) {
        Converter conv = new Converter();
        conv.init();
        
    }
    
}
