package model.textures.blocks;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.model.fundamental.Tileset;
import akkgframework.view.DrawTool;

public class Water extends GraphicalObject {

    private Tileset tileset;
    private int image;
    private double timer;

    public Water(int posX, int posY) {
        x = posX;
        y = posY;
        width = 32;
        height = 32;
        image = 0;
        timer = 0;
        setType("water");
         tileset = new Tileset("assets/images/terraintiles/animation_block_water.gif", 32, 32);
    }


    public void draw(DrawTool drawTool) {
        drawTool.drawImage(tileset.getTile(0, image), this.getX(), this.getY());
    }


    /**
     * Wird vom Hintergrundprozess für jeden Frame aufgerufen. Hier kann das verhalten des Objekts festgelegt werden, zum Beispiel
     * seine Bewegung.
     */
    public void update(double dt) {
        timer = timer + dt;
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
            timer = 0;
        }
    }
}
