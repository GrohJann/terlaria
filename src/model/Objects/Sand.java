package model.Objects;

import javax.imageio.ImageIO;

import model.Object;


public class Sand extends Object {
    
    public Sand(String pictureFile, String  soundFile, int durability){
        super("Dirt", pictureFile, soundFile, durability, "Block", false, null);
        
    }
    
}