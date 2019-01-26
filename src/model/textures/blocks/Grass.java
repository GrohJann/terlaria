package model.textures.blocks;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

public class Grass extends GraphicalObject {
    
    public Grass(int posX, int posY) {
        x = posX;
        y = posY;
        width = 32;
        height = 32;
        setX(posX);
        setY(posY);
        setWidth(32);
        setHeight(32);
        setKind("grass");
        
        this.createAndSetNewImage("assets/images/custom/grass.png");
    }
    
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(), x, y);
    }

}
