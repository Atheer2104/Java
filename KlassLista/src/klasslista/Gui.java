package klasslista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Gui {
    private JFrame frame;
    private JLabel l_pnr, l_name, l_mob;
    private JTextField tf_pnr, tf_name, tf_mob;
    private JButton b_add, b_find;
    private JMenuBar baren;
    private JMenu menu;
    private JMenuItem addItem, findItem;
    private JPanel background;
    private Elevregister reg;
    
    
    public void init() {
        try {
            FileInputStream fis = new FileInputStream("elever.srz");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream in = new ObjectInputStream(bis);
            reg = (Elevregister) in.readObject();
            if (reg == null) {
                reg = new Elevregister();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        frame = new JFrame("Elevregister");
        background = new JPanel();
        background.setBackground(Color.pink);
        background.setLayout(new GridLayout(4,2));
        baren = new JMenuBar();
        menu = new JMenu("Arkiv");
        addItem = new JMenuItem("add");
        findItem = new JMenuItem("find");
        baren.add(menu);
        menu.add(findItem);
        menu.add(addItem);
        frame.setJMenuBar(baren);
        
        frame.setContentPane(background);
        
        l_pnr = new JLabel("pnr");
        background.add(l_pnr);
        tf_pnr = new JTextField(12);
        background.add(tf_pnr);
        
        l_name = new JLabel("name");
        background.add(l_name);
        tf_name = new JTextField(12);
        background.add(tf_name);
        
        l_mob = new JLabel("mob");
        background.add(l_mob);
        tf_mob = new JTextField(12);
        background.add(tf_mob);
        
        b_add = new JButton("add it ");
        b_find = new JButton("find it");
        
        AddListner al = new AddListner();
        b_add.addActionListener(al);
        addItem.addActionListener(al);
        
        findListener fl = new findListener();
        b_find.addActionListener(fl);
        findItem.addActionListener(fl);
        
        background.add(b_add);
        background.add(b_find);
        
        
        
        
        frame.pack();
        //frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
    private class AddListner implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String pnr = tf_pnr.getText();
            String name = tf_name.getText();
            String mob = tf_mob.getText();
            Elev eleven = new Elev(pnr, name, mob);
            
            reg.addElev(eleven);
            //spara ner i fil
            try {
                FileOutputStream fos = new FileOutputStream("elever.srz");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream out = new ObjectOutputStream(bos);
                out.writeObject(reg);
                out.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
            
            
            
        }
    }
    
    private class findListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String pnr = tf_pnr.getText();
            Elev hittadElev = reg.findElev(pnr);
            if (hittadElev != null) {
            tf_name.setText(hittadElev.getName());
            tf_mob.setText(hittadElev.getMob());
            } else {
                JOptionPane.showMessageDialog(background, "fanns ej försök igen");
                        
            }
            
        }
    }
    
    public static void main(String[] args) {
        Gui g = new Gui();
        g.init();
    }
    
    
    
}
