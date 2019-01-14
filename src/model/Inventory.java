package model;

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

    /*
     * Methode zum hinzufügen eines Items.
     * Falls Items des Entsprechenden Types im Inventat vorhanden sind, wird die Anzahl erhöht.
     * Ansonsten wird das Item am Ende der Liste angehängt.
     */
    public void addItem(Item added){
        int temp = searchItem(added.getName());
        if(temp >= 0){
            items.toFirst();
            for(int i = temp; i > 0; i--){
                items.next();
            }
            items.getContent().setAmount(items.getContent().getAmount() + 1);
            toActual();
        }else if(usedPlaces < places){
            items.append(added);
            usedPlaces ++;
        }
    }

    /* Methode zum entfernen eines Items.
     * Falls mehrere Items des entsprechenden Types vorhanden sind wird eins entfernd.
     * Ansonsten wird das Item aus der Liste gelöscht.
     */
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
        return places;
    }

    public int getUsedPlaces(){
        return usedPlaces;
    }

    /*
     * Methode zum auswählen eines Items mithilfe des Mausreades.
     */
    public void mouseWheelMoved(MouseWheelEvent e){
        if(actual < places && e.getWheelRotation() >= 1){
            actual ++;
            items.next();
        }
        if(actual > 0 && e.getWheelRotation() <= -1){
            actual --;
            toActual();
        }
    }

    /*
     * Methode zum durchsuchen des Inventars auf Items eines bestimmten Types.
     * Gibt den Platz in der list zurück, in der sich das Item befindet.
     * Falls das Item nicht vorhanden ist, wird -1 zurückgegeben wird.
     */
    private int searchItem(String name){
        int output = -1;
        items.toFirst();
        for(int i = 0; i < places && output >= 0; i++){
            if(name.equals(items.getContent().getName())){
                output = i;
            }
            items.next();
        }
        toActual();
        return output;
    }

    private void toActual(){
        items.toFirst();
        for(int i = actual; i > 0; i--){
            items.next();
        }
    }
}
