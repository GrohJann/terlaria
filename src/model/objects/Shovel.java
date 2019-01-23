package model.objects;

import akkgframework.control.fundamental.UIController;
import java.awt.event.KeyEvent;


public class Shovel extends Item {


    public Shovel(String name, int amount){
        super(name, amount);
        this.setImage(createNewImage("assets/images/barel.png"));
    }

    /*
     *   public void use(UIController uic){
     *     if(uic.isKeyDown(KeyEvent.VK_E)){
     *
     *     }
     *   }
     */
}
