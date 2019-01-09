package model.textures;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.abitur.datenstrukturen.List;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

import java.awt.event.MouseWheelEvent;


public class Inventory extends GraphicalObject {

    private List<Item> items;
    private int places;
    private int usedPlaces;
    private int actual;
    private UIController uic;

    public Inventory(UIController uic){
        items = new List<>();
        places = 5;
        actual = 1;
        this.uic = uic;
    }

    public void draw(DrawTool drawTool){

    }

    public void addItem(Item added){
        if(usedPlaces < places){
            items.append(added);
            usedPlaces ++;
        }
    }

    public Item dropItem(){
        Item dropped = items.getContent();
        if(items.getContent().getAmount() == 1) {
            items.remove();
            usedPlaces--;
        }else{
            items.getContent().setAmount(items.getContent().getAmount() - 1);
        }
        return dropped;
    }

    public void addPlace(){
        places ++;
    }

    public Item getItem(){
        return items.getContent();
    }



    public int getPlaces(){
        return usedPlaces;
    }

    public void mouseWheelMoved(MouseWheelEvent e){
        if(actual < places && e.getWheelRotation() >= 1){
            actual ++;
            items.next();
        }
        if(actual > 0 && e.getWheelRotation() <= -1){
            actual --;
            items.toFirst();
            for(int i = actual; i > 0; i--){
                items.next();
            }
        }
    }
}
