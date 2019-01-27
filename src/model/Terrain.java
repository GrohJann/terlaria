package model;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;
import control.MapReader;
import model.terrainelements.Abyss;
import model.terrainelements.Plain;
import model.terrainelements.SmallHill;
import model.textures.blocks.Dirt;
import model.textures.blocks.Grass;
import model.textures.blocks.Stone;
import model.textures.entitys.Player;


public class Terrain extends GraphicalObject {
    
    //private MapController mapController;
    
    //private String[][] mastermap;
    private char[][] mastermap;
    private GraphicalObject[][] terrain;
    private SmallHill smallHill;
    private Plain plain;
    private Abyss abyss;
    
    
    public Terrain() {
        //mapController = new MapController("assets/data/map.txt");
        //mastermap = mapController.getMap();
        //mastermap = MapReader.getMapFromFile("assets/data/map - Copy.txt", 33, 15);
        //terrain = new GraphicalObject[mastermap.length][mastermap[0].length];
        
        //1080 * 1920
        //2D Array um das ganze Fenster mit Tiles auszufüllen, wobei zuerst die Zeile und dann die Spalte eingegeben wird
        terrain = new GraphicalObject[33][60];
        
        
        //this.generateTerrain();
        //this.generateTerrainBlock();
    }
    
    private void generateTerrain() {
        int posX = 0;
        int posY = 0;
        
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                terrain[i][j] = new Grass(posX, posY);
                posX += 32;
            }
            posY += 32;
            posX = 0;
        }
    }
    
    public void generateTerrainBlock() {
        int posX = 0;
        int posY = 0;
        
        for (int i = 0; i < mastermap.length; i++) {
            for (int j = 0; j < mastermap[i].length; j++) {
                switch (mastermap[i][j]) {
                    case 'a':
                        posX += 32;
                        break;
                    
                    case 'd':
                        terrain[i][j] = new Dirt(posX, posY);
                        posX += 32;
                        break;
                    
                    case 'g':
                        terrain[i][j] = new Grass(posX, posY);
                        posX += 32;
                        break;
                    
                    case 's':
                        terrain[i][j] = new Stone(posX, posY);
                        posX += 32;
                        break;
                    
                    default:
                        System.err.println("No avaliable Block");
                }
            }
            posY += 32;
        }
        
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                if (terrain[i][j] != null)
                    System.out.println(terrain[i][j].getKind());
                else
                    System.out.println("air");
            }
        }
        //System.out.println(terrain[1][1].toString());
        
        smallHill = new SmallHill(0);
        plain = new Plain(15 * 32);
        abyss = new Abyss(30 * 32);
    }
    
    public void handleCollision(Player player) {
        GraphicalObject[][] terrainelement = smallHill.getTerrainelement();
        
        //for (int i = 0; i < )
    }
    
    public void draw(DrawTool drawTool) {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                if (terrain[i][j] != null) {
                    //drawTool.drawImage(terrain[i][j].getMyImage(), terrain[i][j].getX(), terrain[i][j].getY());
                    smallHill.draw(drawTool);
                    plain.draw(drawTool);
                    abyss.draw(drawTool);
                }
            }
        }
    }
    
    
    public GraphicalObject[][] getTerrain() {
        return terrain;
    }
}
