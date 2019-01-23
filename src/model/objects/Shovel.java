package model.objects;

import akkgframework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Shovel extends Item {



    public Shovel(BufferedImage image){
        this.setName("shovel");
        this.setAmount(1);
    }

    public void draw(DrawTool drawTool){
        setMyImage("assets/images/tree.png");
    }
}
