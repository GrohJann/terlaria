package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.abitur.datenstrukturen.List;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;
import model.objects.Item;

import java.awt.event.MouseWheelEvent;


public class Inventory extends GraphicalObject {

    private List<Item> items;
    private List<Item> drawedItems;
    private int places;
    private int usedPlaces;
    private int actual;
    private UIController uic;

    public Inventory(UIController uic){
        this.items = new List<>();
        this.drawedItems = new List<>();
        this.places = 5;
        this.actual = 1;
        this.uic = uic;
    }

    public void draw(DrawTool drawTool){
        drawedItems.toFirst();
        for(int i = 0; i < places; i++){
            drawTool.drawRectangle(1800,50 + 50 * i,50,50);
            if(!drawedItems.isEmpty() && i < usedPlaces) {
                drawTool.drawImage(drawedItems.getContent().getImage(), 1810, 60 + 50 * i);
                //System.out.println("Item gezeichnet: " + i);
            }
            drawedItems.next();
        }
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
            drawedItems.toFirst();
            for(int i = temp; i > 0; i--){
                items.next();
                drawedItems.next();
            }
            items.getContent().setAmount(items.getContent().getAmount() + 1);
            drawedItems.getContent().setAmount(items.getContent().getAmount() + 1);
            toActual();
            //System.out.println("Item vermehrt: " + temp);
        }else if(usedPlaces < places){
            items.append(added);
            drawedItems.append(added);
            usedPlaces ++;
            //System.out.println("Item hinzugefügt: " + usedPlaces + "/" + places);
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
            drawedItems.toFirst();
            for(int i = actual; i > 0; i--){
                drawedItems.next();
            }
            drawedItems.remove();
            usedPlaces--;
        }else{
            items.getContent().setAmount(items.getContent().getAmount() - 1);
            drawedItems.toFirst();
            for(int i = actual; i > 0; i--){
                drawedItems.next();
            }
            drawedItems.getContent().setAmount(items.getContent().getAmount() - 1);
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
    public int searchItem(String name){
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
