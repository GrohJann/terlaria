package model;

import akkgframework.control.fundamental.SoundController;
import akkgframework.model.fundamental.Sound;

import javax.imageio.ImageIO;

public abstract class Object extends SoundController {
    
    //TODO preferedMinigTool implentieren
    private String name;
    private ImageIO pic;
    private Sound sound;
    private int durability;
    private String type;
    
    private int damage;
    
    public Object(String name, String  pictureFile, String soundFile, int durability, String type, boolean hasAbientSound, String abientSoundFile) {
        this.name = name;
        createAndSetNewImage(pictureFile);
        if (type.equals("Block"))
            loadSound(soundFile, "soundWalk", false);
        if (hasAbientSound)
            loadSound(abientSoundFile, "soundAmbient", true);
        this.durability = durability;
        this.type = type;
        
        this.damage = 0;
    }
    
    
    /**
     * Getter and Setter
     */
    
    public void setDamage(int damage) {
        if (type.equals("Block"))
            this.damage = damage;
    }
    
    public ImageIO getPic() {
        return pic;
    }
    
    public Sound getSound() {
        return sound;
    }
    
    public int getDurability() {
        return durability;
    }
}
