package model.textures.blocks;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

public class Dirt extends GraphicalObject {

    public Dirt(int posX, int posY){
        x = posX;
        y = posY;
        width = 32;
        height = 32;
        setType("dirt");
        this.createAndSetNewImage("assets/images/terraintiles/block_dirt.gif");
    }

    public void draw(DrawTool drawTool) {
        drawTool.drawImage(this.getMyImage(), this.getX(), this.getY());
    }

}
