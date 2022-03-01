package game;

import java.awt.*;

public abstract class GameObject {
    
    //can only be accessd by the things that inheritance GameObject
    protected float x, y;
    protected ID id;
    protected float velX, velY;
    
    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
        
    }
        
    // abstract that we need to use this method
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public float GetX() {
        return x;
    }
    
     public float GetY() {
        return y;
    }
     
    public void setId(ID id) {
        this.id = id;
    }
    
    public ID getId() {
        return id;
    }
    
    public void setVelX(int velX) {
        this.velX = velX;
    }
    
    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    public float getVelX() {
        return velX;
    }
    
    public float getVelY() {
        return velY;
    }
    
    
    
    
}
