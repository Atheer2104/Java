package game;

import game.Game.STATE;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Menu extends MouseAdapter{
    
    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }
    
    
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        if (game.gameState == STATE.Menu) {
        
            //play button
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = STATE.Select;
                return;
            }

            //Help buttin
            if (mouseOver(my, mx, 210, 250, 200, 64)) {
                game.gameState = STATE.Help;
            }


            //quit button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        
        }
        
        if (game.gameState == STATE.Select) {
        
            //normal button
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                
                game.diff = 0;
                
            }

            //hard buttin
            if (mouseOver(my, mx, 210, 250, 200, 64)) {
                game.gameState = STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                
                game.diff = 1;
            }


            //back button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = STATE.Menu;
                return;
            }
        
        }
        
        //back button
        if (game.gameState == STATE.Help) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = STATE.Menu;
                return;
            }
        }
        
        //try again button
        if (game.gameState == STATE.End) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = STATE.Menu;
                hud.setLevel(1);
                hud.Setscore(0);
            }
        }
        
    }
    
    public void mouseReleased(MouseEvent e) {
    
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            if (my > y && my < y + height){
                return true;
            }else return false;
        }else return false;
        
        
    }
    
    public void tick() {
    
    }
    
    public void render(Graphics g) {
        if (game.gameState == STATE.Menu) {
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Wave", 240, 70);
        
        g.setFont(fnt2);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Play", 270, 190);
        
        g.drawRect(210, 250, 200, 64);
        g.drawString("Help", 270, 290);
        
        g.drawRect(210, 350, 200, 64);
        g.drawString("Quit", 270, 390);
        
        }else if (game.gameState == STATE.Help) {
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        Font fnt3 = new Font("arial", 1, 20);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Help", 240, 70);
        
        g.setFont(fnt3);
        g.drawString("Use WASD keys to move player and dodge enemies", 60, 200);
        
        g.setFont(fnt2);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Back", 270, 390);
            
        
        }else if (game.gameState == STATE.End) {
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        Font fnt3 = new Font("arial", 1, 20);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Game Over", 180, 70);
        
        g.setFont(fnt3);
        g.drawString("You lost with a score of: " + hud.getScore() , 175, 200);
        
        g.setFont(fnt2);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Try Again", 245, 390);
            
        
        }else if (game.gameState == STATE.Select) {
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Select difficulty", 140, 70);
        
        g.setFont(fnt2);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Normal", 260, 190);
        
        g.drawRect(210, 250, 200, 64);
        g.drawString("Hard", 270, 290);
        
        g.drawRect(210, 350, 200, 64);
        g.drawString("Back", 270, 390);
        
        }
        
        
        
    }
    
}
