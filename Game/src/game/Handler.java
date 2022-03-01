package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public int speed = 5;
    
    // tick all of the gameObject
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            
            GameObject tempObject =  object.get(i);
            
            tempObject.tick();
        }
    }
    
    // renders all of the gameObject
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            
            GameObject tempObject =  object.get(i);
            try{
            tempObject.render(g);
            } catch (NullPointerException e) {}
        }
    }
    
    public void clearEnemys() {
         for (int i = 0; i < object.size(); i++) {
            GameObject tempObject =  object.get(i);
            
            if (tempObject.getId() == ID.Player) {
                
                object.clear();
                if (Game.gameState != Game.STATE.End)
                addObject(new Player((int)tempObject.GetX(), (int)tempObject.GetY(), ID.Player, this));
            
            }
        }
    }
    
    public void addObject(GameObject object) {
        this.object.add(object);
    }
    
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
    
    
}
