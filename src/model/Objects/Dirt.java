package model.Objects;

import javax.imageio.ImageIO;

import model.Object;


public class Dirt extends Object {
    
    public Dirt(String  pictureFile, String  soundFile, int durability){
        super("Dirt", pictureFile, soundFile, durability, "Block", false, null);
        
    }
    
}
