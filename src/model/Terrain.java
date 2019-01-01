package model;


import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;
import model.Objects.Dirt;

import javax.imageio.ImageIO;

public class Terrain extends GraphicalObject {
    
    private Object[][] map;
    
    private Dirt dirt;
    
    public Terrain(int sizeX, int sizeY){
        //map = new Object[sizeX][sizeY];
        dirt = new Dirt("assets/images/terraintiles/block_dirt.gif", "sounds/rpg-effects/world/chopwood.mp3", 15);
        map = new Object[][]{
                {null,null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null,null},
                {dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt},
                {dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt},
                {dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt},
                {dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt},
                {dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt},
                {dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt,dirt}
        };
    }
    
    @Override
    public void draw(DrawTool drawTool) {
        //drawTool.drawImage(getMyImage(),x,y);
        drawTool.drawImage(dirt.getMyImage(), 10, 10);
    }
    
    public void generateNewTerrain(){
        //TODO gebiets generier Algorithmus erstellen
    }
    
    
    /**
     * Getter
     */
    
    public Object getObjectAtPosition(int x, int y) {
        return map[x][y];
    }
}
