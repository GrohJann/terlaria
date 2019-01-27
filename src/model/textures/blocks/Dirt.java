package model.textures.blocks;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

public class Dirt extends GraphicalObject {

    public Dirt(int posX, int posY){
        x = posX;
        y = posY;
        width = 32;
        height = 32;
        setKind("dirt");
        this.createAndSetNewImage("assets/images/custom/dirt.png");
    }

    public void draw(DrawTool drawTool) {
        drawTool.drawImage(this.getMyImage(), this.getX(), this.getY());
    }

}
