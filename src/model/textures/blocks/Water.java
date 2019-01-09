package model.textures.blocks;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.model.fundamental.Tileset;
import akkgframework.view.DrawTool;

public class Water extends GraphicalObject {
    
    private Tileset tileset;
    
    public Water(int posX, int posY) {
        x = posX;
        y = posY;
        width = 32;
        height = 32;
        
        tileset = new Tileset("assets/images/terraintiles/animation_block_water.gif", 32, 32);
    }
    
    
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(tileset.getTile(0, 0), this.getX(), this.getY());
    }
    
    
    /**
     * Wird vom Hintergrundprozess für jeden Frame aufgerufen. Hier kann das verhalten des Objekts festgelegt werden, zum Beispiel
     * seine Bewegung.
     */
    public void update(DrawTool drawTool, double dt) {
        double timer = 0;
        int image = 0;
        while (true) {
            timer = timer + dt;
            if (timer >= 0 && timer <= 0.5) {
                drawTool.drawImage(tileset.getTile(image, 0), this.getX(), this.getY());
                image++;
            }
            
            if (timer >= 0.5 && timer <= 1) {
                drawTool.drawImage(tileset.getTile(image, 0), this.getX(), this.getY());
                image++;
            }
            
            if (timer >= 1 && timer <= 1.5) {
                drawTool.drawImage(tileset.getTile(image, 0), this.getX(), this.getY());
                image++;
            }
            
            if (timer >= 1.5 && timer <= 2) {
                drawTool.drawImage(tileset.getTile(image, 0), this.getX(), this.getY());
                image = 0;
            }
        }
    }
}
