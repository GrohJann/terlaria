package model.textures.entitys;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.model.fundamental.Tileset;
import akkgframework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GraphicalObject {

    private Tileset tileset;
    private UIController uic;
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    private int speed;
    private int image;
    private double time;
    private double timer;
    private boolean idle;

    public Player(UIController uic) {
        this.tileset = new Tileset("assets/images/custom/player.png", 32, 48);
        this.uic = uic;

        setX(gd.getDisplayMode().getWidth() / 2);
        setY(0);
        setWidth(32);
        setHeight(48);

        speed = 75;
        image = 0;
        timer = 0;
        idle = true;
    }

    public void draw(DrawTool drawTool) {
        drawTool.drawImage(tileset.getTile(image, (int)(timer)), x , y);
    }

    public void update(double dt) {
        
        time+=dt;
        
        /*
         * movement
         */
        if (uic.isKeyDown(KeyEvent.VK_W)) {
            y -= 10;
        } else if (uic.isKeyDown(KeyEvent.VK_SPACE)) {
            y -= 20;
        }
        if (uic.isKeyDown(KeyEvent.VK_A)) {
            x = x - speed * dt;
            idle = false;
            image = 0;
        } else if (uic.isKeyDown(KeyEvent.VK_D)) {
            x = x + speed * dt;
            idle = false;
            image = 1;
        } else {
            idle = true;
        }

        
        /*
         * animation
         */
        if (!idle) {
            timer = timer + dt * 9;
        }else {
            timer = 0;
        }
        
        if (timer > 14) timer = 0;
        
    }

    /**
     * gibt wert zur überprüfung zurück
     * @param task was zurück gegeben wird
     * @param direction ob links oder rechts
     * @return
     */
    public int getTask(String task,String direction){
        if(task.equalsIgnoreCase("y")){
            return (int)y;
        }
        if(task.equalsIgnoreCase("x")) {
            if(direction.equalsIgnoreCase("left")){
                return (int) x*-1;
            }else{
                return (int) x;
            }
        }
        if(task.equalsIgnoreCase("time")) {
            return (int) time;
        }
        return 0;
    }
    public void addGravity(double dt) {
        y += 200 * dt;
    }
    
    
    /**
     * getter und setter
     */
    
    public void setTime(double time) {
        this.time = time;
    }
}


