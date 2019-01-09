package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GraphicalObject {

    private int speed;
    private UIController uic;
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    public Player(UIController uic){
        speed=100;
        this.uic=uic;
    }

    public void draw(DrawTool draw){
        draw.setCurrentColor(255,0,0,255);
        draw.drawFilledRectangle(x+gd.getDisplayMode().getWidth()/2,y,50,50);
    }

    public void update(double dt){
        /*if (uic.isKeyDown(KeyEvent.VK_W)){
            y=y+speed*dt;
        }*/
        if(uic.isKeyDown(KeyEvent.VK_A)){
            x=x-speed*dt;
        }
        if(uic.isKeyDown(KeyEvent.VK_D)){
            x=x+speed*dt;
        }
        /*if(!collision) {
            y = y + speed * dt;
        }*/
    }
}
