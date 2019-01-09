package model.textures;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

public class Background extends GraphicalObject {

    public Background(int posX, int posY){
        x = posX;
        y = posY;

        this.createAndSetNewImage("assets/images/terraintiles/background_day.gif");
    }

    public void draw(DrawTool drawTool) {
        drawTool.drawImage(this.getMyImage(),this.getX(),this.getY());
    }

}