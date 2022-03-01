package game;

import game.Game.STATE;
import java.awt.event.*;

public class KeyInput extends KeyAdapter {
    
    private Handler handler;
    private boolean[] keyDown = new boolean[4];
    
    Game game;
    
    public KeyInput(Handler handler, Game game) {
        this.handler = handler;
        
        this.game = game;
        
        for (int i = 0; i < keyDown.length; i++) {
            keyDown[i] = false;
        }
        
    }
    
    public void keyPressed(KeyEvent e) {
        // key code for each letter pressed
        int key = e.getKeyCode();
        System.out.println("Pressed");
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player) {
                // all key events for player one 
                
                if (key == KeyEvent.VK_W) { tempObject.setVelY(-handler.speed); keyDown[0] = true; }
                if (key == KeyEvent.VK_S) { tempObject.setVelY(handler.speed); keyDown[1] = true; }
                if (key == KeyEvent.VK_D) { tempObject.setVelX(handler.speed); keyDown[2] = true; }
                if (key == KeyEvent.VK_A) { tempObject.setVelX(-handler.speed); keyDown[3] = true; }
            }
         }
        
        if (key == KeyEvent.VK_P) {
        
            if (game.gameState == STATE.Game) {
                
                if (Game.paused) Game.paused = false;
                else Game.paused = true;
            
            }
            
        }
        
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
        if (key == KeyEvent.VK_SPACE) {
            if (Game.gameState == STATE.Game) {
                
                Game.gameState = STATE.Shop;         
            }else if (Game.gameState == STATE.Shop) {
                
                Game.gameState = STATE.Game;         
            }
        }
 }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("Released");
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.Player) {
                // all key events for player one 
                
                if (key == KeyEvent.VK_W) keyDown[0] = false; 
                if (key == KeyEvent.VK_S) keyDown[1] = false; 
                if (key == KeyEvent.VK_D) keyDown[2] = false; 
                if (key == KeyEvent.VK_A) keyDown[3] = false; 
                
                //vertical movement
                if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
                //horizontal movement
                if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
                
                
                
                
            }
        }
           
    }
    
    
}
