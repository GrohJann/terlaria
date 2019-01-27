package model.objects;

public class ItemDirt extends Item {

    public ItemDirt(String name, int amount) {
        super(name, amount);
        setImage(createNewImage("assets/images/custom/grass.png"));
    }
}
