package model.blocks;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

public class Grass extends GraphicalObject {

    public Grass(int posX, int posY){
        x = posX;
        y = posY;

        this.createAndSetNewImage("assets/images/terraintiles/block_grass.gif");
    }

    public void draw(DrawTool drawTool) {
        drawTool.drawImage(this.getMyImage(),this.getX(),this.getY());
    }

}
