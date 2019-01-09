package model.textures;

import akkgframework.model.fundamental.GraphicalObject;

public abstract class Item extends GraphicalObject {

    private String name;
    private int amount;

    public int getAmount(){
       return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
}
