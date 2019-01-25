package model.objects;

import akkgframework.control.fundamental.UIController;
import model.Terrain;
import model.textures.entitys.Player;

import java.awt.event.KeyEvent;


public class Shovel extends Item {


    public Shovel(String name, int amount){
        super(name, amount);
        this.setImage(createNewImage("assets/images/barel.png"));
    }

    public void use(UIController uic, Player player, Terrain terrain){
        if(uic.isKeyDown(KeyEvent.VK_E)){
            for(int i= 0; i < terrain.getTerrain().length; i++) {
                if (player.collidesWithBottom(terrain.getTerrain()[i][(int)(player.getX() / 32)]) && (terrain.getTerrain()[i][(int)(player.getX() / 32)].getKind() == "grass" || terrain.getTerrain()[i][(int)(player.getX() / 32)].getKind() == "dirt")){
                    terrain.getTerrain()[i][(int)(player.getX() / 32)] = null;
                }
            }
        }
    }
}
