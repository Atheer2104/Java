package swing;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

import java.awt.event.*;

public class Swing extends JFrame {

    JButton button1;
    JTextField textField1;
    JTextArea textArea1;
    int buttonClicked;
    
    
    public static void main(String[] args) {
        
        new Swing();
        
    }
    
    
    public Swing() {
        
        // set width n height
        this.setSize(400,400);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        Dimension dim = tk.getScreenSize();
        
        // first value the width/height of the screen, the second is the width/height of the frame
        int xPos = (dim.width/2) - (this.getWidth()/2);
        int yPos = (dim.height/2) - (this.getHeight()/2);
        
        // set location of the frame 
        this.setLocation(xPos, yPos);
        
        // set to not be able resize the frame
        this.setResizable(false);
        
        // when we press close button the program shutsdown
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // set title
        this.setTitle("My First Frame");
        
        JPanel thePanel = new JPanel();
        
        /*JLabel label1 = new JLabel("Tell me something");
        
        // change the text after it has been created
        label1.setText("New Text");
        
        // popup comes up when the mouse course us on the label
        label1.setToolTipText("Doesn't do anything");
        
        // add label to panel
        thePanel.add(label1);*/
        
        JButton button1 = new JButton("Click Here");
        
        // create listner
        ListenForButton lForButton = new ListenForButton();
        
        // adding listner to button
        button1.addActionListener(lForButton);
       
        thePanel.add(button1);
        
        // first is placeholder second is how many columns it should have
        JTextField textField1 = new JTextField("", 15);
        
        ListenForKeys lForKeys = new ListenForKeys();
        
        textField1.addKeyListener(lForKeys);
        
        thePanel.add(textField1);
        
        JTextArea textArea1 = new JTextArea(15, 20);
        
        textArea1.setText("Tracking Events\n");
        
        // it automatically wraps to next line
        textArea1.setLineWrap(true);
        
        // to make sure we don't wrap and break the word
        textArea1.setWrapStyleWord(true);
        
        int numOfLines = textArea1.getLineCount();
        
        textArea1.append(" number of lines: " + numOfLines);
        
        // we add tha scroll bar to the text area 
        JScrollPane scrollBar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        thePanel.add(scrollBar1);
        
        // add the panel to the frame
        this.add(thePanel);
        
        ListenForWindow lForWindow = new ListenForWindow();
        
        this.addWindowListener(lForWindow);
        
        // make it visible
        this.setVisible(true);
    
        // as soon we launch the app the first thing highlited will be textfield
        //textField1.requestFocus();
        
        ListenForMouse lForMouse = new ListenForMouse();
        thePanel.addMouseListener(lForMouse);
        
        
        
    }
    
        private class ListenForButton implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == button1) {
            
                buttonClicked++;
                
                textArea1.append("Button clicked " + buttonClicked + " times\n");
                
                e.getSource().toString();
            
            }
            
        }
        
    }
        
        private class ListenForKeys implements KeyListener {

            @Override
            public void keyTyped(KeyEvent e) {
                textArea1.append("Key Hit: " + e.getKeyChar() + "\n");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        }
        
        
        private class ListenForWindow implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
            textArea1.append("Window is created ");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowClosed(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowIconified(WindowEvent e) {
            textArea1.append("Window is minimized ");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
             textArea1.append("Window in Normal State ");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            textArea1.append("Window is active ");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            textArea1.append("Window is Not active ");
        }
            
        }
        
        
        private class ListenForMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
            
            
            
            
        }
        
}
