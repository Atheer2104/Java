package game;

import java.awt.*;
import javax.swing.JFrame;

public class Window extends Canvas {
    
    public Window(int width, int height, String title, Game game) {
        // create the frame
        JFrame frame = new JFrame(title);
        
        // seting the size for the frame
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        // when we press red button it will close the programm completly
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //cannot resize window
        frame.setResizable(false);
        // frame will start in the center instead of top left
        frame.setLocationRelativeTo(null);
        // we add our game class to our frame
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
    
}
