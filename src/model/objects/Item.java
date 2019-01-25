package model.objects;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import model.Inventory;
import model.Terrain;
import model.textures.entitys.Player;

import java.awt.image.BufferedImage;

public abstract class Item extends GraphicalObject {

    protected String name;
    private int amount;
    private BufferedImage image;

    public Item(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    protected void use(UIController uic, Player player, Terrain terrain, Inventory inventory){

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAmount(){
       return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public BufferedImage getImage(){
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
