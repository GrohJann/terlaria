package model.objects;

import akkgframework.control.fundamental.UIController;
import model.Inventory;
import control.Terrain;
import model.textures.entitys.Player;

import java.awt.event.KeyEvent;


public class Shovel extends Item {


    public Shovel(String name, int amount){
        super(name, amount);
        this.setImage(createNewImage("assets/images/custom/shovel.png"));
    }

    @Override
    public void use(UIController uic, Player player, Terrain terrain, Inventory inventory){
        if(uic.isKeyDown(KeyEvent.VK_E)){
            for(int i= 0; i < terrain.getTerrain(player).length; i++) {
                if (player.collidesWithBottom(terrain.getTerrain(player)[i][(int)(player.getX() / 32)]) && (terrain.getTerrain(player)[i][(int)(player.getX() / 32)].getKind() == "grass" || terrain.getTerrain(player)[i][(int)(player.getX() / 32)].getKind() == "dirt")){
                    terrain.getTerrain(player)[i][(int)(player.getX() / 32)] = null;
                    inventory.addItem(new ItemDirt("Dirt",1));
                }
            }
        }
    }
}
