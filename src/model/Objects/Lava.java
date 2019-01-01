package model.Objects;

import javax.imageio.ImageIO;

import model.Object;


public class Lava extends Object {
    
    public Lava(String pictureFile, String  soundFile, String abientSoundFile){
        super("Lava", pictureFile, soundFile, 0, "Liquid", true, abientSoundFile);
        
    }
    
}