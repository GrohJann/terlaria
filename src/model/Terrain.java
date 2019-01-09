package model;

import akkgframework.model.fundamental.GraphicalObject;
import control.Config;

public class Terrain {
    
    private Config conf;
    
    private GraphicalObject[][] terrain;
    
    public Terrain(){
        conf = new Config();
        
        //2D Array um das ganze Fenster mit Tiles auszufüllen, wobei zuerst die Spalte und dann die Zeile eingegeben wird
        terrain = new GraphicalObject[50][32];
    }
}
