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
    private boolean lookingLeft;
    private boolean idle;

    public Player(UIController uic) {
        this.tileset = new Tileset("assets/images/terraintiles/entity_player_01.gif", 32, 48);
        this.uic = uic;

        speed = 300;
        image = 0;
        timer = 0;
        lookingLeft = true;
        idle = true;
    }

    public void draw(DrawTool drawTool) {
        drawTool.drawImage(tileset.getTile(0, image), x + gd.getDisplayMode().getWidth() / 2, y);
    }

    public void update(double dt) {
        if (uic.isKeyDown(KeyEvent.VK_W)){
            y -= 10;
        }else if (uic.isKeyDown(KeyEvent.VK_SPACE)) {
            y -= 20;
        }
        if (uic.isKeyDown(KeyEvent.VK_A)) {
            x = x - speed * dt;
            lookingLeft = true;
            idle = false;
        } else if (uic.isKeyDown(KeyEvent.VK_D)) {
            x = x + speed * dt;
            lookingLeft = false;
            idle = false;
        } else {
            idle = true;
        }
        /*if(!collision) {
            y = y + speed * dt;
        }*/

        /*
         * animation
         */
        timer = timer + dt*2;

        if (lookingLeft) {
            if (!idle) {
                if (timer >= 0 && timer <= 0.5) {
                    image = 0;
                }
                if (timer >= 0.5 && timer <= 1) {
                    image = 1;
                }
                if (timer >= 1 && timer <= 1.5) {
                    image = 2;
                }
                if (timer >= 1.5 && timer <= 2) {
                    image = 3;
                }


                if (timer >= 2 && timer <= 2.5) {
                    image = 4;
                }
                if (timer >= 2.5 && timer <= 3) {
                    image = 5;
                }
                if (timer >= 3 && timer <= 3.5) {
                    image = 6;
                }
                if (timer >= 3.5 && timer <= 4) {
                    image = 7;
                }


                if (timer >= 4 && timer <= 4.5) {
                    image = 8;
                }
                if (timer >= 4.5 && timer <= 5) {
                    image = 9;
                }
                if (timer >= 5 && timer <= 5.5) {
                    image = 10;
                }
                if (timer >= 5.5 && timer <= 6) {
                    image = 11;
                }


                if (timer >= 6 && timer <= 6.5) {
                    image = 12;
                }
                if (timer >= 6.5 && timer <= 7) {
                    image = 13;
                    timer = 0;
                }
            } else {
                image = 0;
            }
        }
        if (!lookingLeft){
            if (!idle) {
                if (timer >= 0 && timer <= 0.5) {
                    image = 14;
                }
                if (timer >= 0.5 && timer <= 1) {
                    image = 15;
                }

                if (timer >= 1 && timer <= 1.5) {
                    image = 16;
                }

                if (timer >= 1.5 && timer <= 2) {
                    image = 17;
                    timer = 0;
                }
            } else {
                image = 14;
            }
        }
        time+=dt;
    }

    public int getTask(String task){
        if(task.equalsIgnoreCase("y")){
            return (int)y;
        }
        if(task.equalsIgnoreCase("x")) {
            return (int) x;
        }
        if(task.equalsIgnoreCase("time")) {
            return (int) time;
        }
        return 0;
    }

    public void addGravity(double dt){
        y += speed * dt;
    }

    public Tileset getTileset() {
        return tileset;
    }

    public void setTileset(Tileset tileset) {
        this.tileset = tileset;
    }

    public UIController getUic() {
        return uic;
    }

    public void setUic(UIController uic) {
        this.uic = uic;
    }

    public GraphicsDevice getGd() {
        return gd;
    }

    public void setGd(GraphicsDevice gd) {
        this.gd = gd;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTimer() {
        return timer;
    }

    public void setTimer(double timer) {
        this.timer = timer;
    }

    public boolean isLookingLeft() {
        return lookingLeft;
    }

    public void setLookingLeft(boolean lookingLeft) {
        this.lookingLeft = lookingLeft;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }
}


