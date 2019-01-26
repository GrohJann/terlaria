package model.textures.blocks;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

public class Stone extends GraphicalObject {

    public Stone(int posX, int posY) {
        x = posX;
        y = posY;
        width = 32;
        height = 32;
        setX(posX);
        setY(posY);
        setWidth(32);
        setHeight(32);
        setKind("stone");


        this.createAndSetNewImage("assets/images/terraintiles/block_stone.gif");
    }

    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(), x, y);
    }

}
