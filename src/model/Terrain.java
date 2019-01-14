package model;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;
import model.textures.blocks.Grass;

public class Terrain extends GraphicalObject{
    
    private GraphicalObject[][] terrain;
    
    public Terrain(){

        //1080 * 1920
        //2D Array um das ganze Fenster mit Tiles auszufüllen, wobei zuerst die Zeile und dann die Spalte eingegeben wird
        terrain = new GraphicalObject[32][50];


        this.generateTerrain();
    }

    private void generateTerrain(){
        int posX = 0;
        int posY = 0;


        posY = 16 * 32;
        for (int j = 0; j < terrain[terrain.length / 2].length; j++) {
            terrain[terrain.length / 2][j] = new Grass(posX, posY);
            posX += 32;
        }
    }

    public void draw(DrawTool drawTool){
        /*for (int i = 0; i < terrain.length; i++){
            for (int j = 0; j < terrain[i].length; j++){
                drawTool.drawImage(terrain[i][j].getMyImage(), terrain[i][j].getX(), terrain[i][j].getY());
            }
        }*/
        for (int j = 0; j < terrain[terrain.length / 2].length; j++){
            drawTool.drawImage(terrain[terrain.length / 2][j].getMyImage(), terrain[terrain.length / 2][j].getX(), terrain[terrain.length / 2][j].getY());
        }
    }


    public GraphicalObject[][] getTerrain() {
        return terrain;
    }
}
