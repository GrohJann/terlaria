package control;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;
import model.terrainelements.Abyss;
import model.terrainelements.Mountin;
import model.terrainelements.Plain;
import model.terrainelements.SmallHill;
import model.textures.entitys.Player;


public class Terrain extends GraphicalObject {
    
    
    private SmallHill smallHill;
    private Plain plain;
    private Abyss abyss;
    private Mountin mountin;
    
    
    public Terrain() {
        this.generateTerrain();
    }
    
    
    
    public void generateTerrain() {
        int posX = 0;
        int posY = 0;
        
        smallHill = new SmallHill(0);
        plain = new Plain(15 * 32);
        abyss = new Abyss(30 * 32);
        mountin = new Mountin(45 * 32);
    }
    
    public void handleCollision(Player player, double dt) {
        GraphicalObject[][] terrainelement;
    
        if ((int)(player.getX()) >= smallHill.getPosX() && (int)(player.getX() + player.getWidth()) <= smallHill.getPosX() + smallHill.getWidth()){
            //im gebiet small hill
            terrainelement = smallHill.getTerrainelement();
            handleTerrainElementCollision(player, terrainelement, dt);
        } else if ((int)(player.getX()) >= plain.getPosX() && (int)(player.getX() + player.getWidth()) <= plain.getPosX() + plain.getWidth()){
            //im gebiet plain
            terrainelement = plain.getTerrainelement();
            handleTerrainElementCollision(player, terrainelement, dt);
        } else if ((int)(player.getX()) >= abyss.getPosX() && (int)(player.getX() + player.getWidth()) <= abyss.getPosX() + abyss.getWidth()){
            //im gebiet abyss
            terrainelement = abyss.getTerrainelement();
            handleTerrainElementCollision(player, terrainelement, dt);
        } else if ((int)(player.getX()) >= mountin.getPosX() && (int)(player.getX() + player.getWidth()) <= mountin.getPosX() + mountin.getWidth()){
            //im gebiet abyss
            terrainelement = mountin.getTerrainelement();
            handleTerrainElementCollision(player, terrainelement, dt);
        }
    }
    
    private void handleTerrainElementCollision(Player player, GraphicalObject[][] terrainelement, double dt){
        boolean collides = false;
        for (int i = 0; i < terrainelement.length; i ++){
            for (int j = 0; j < terrainelement[i].length; j++){
                if (player.collidesWithTop(terrainelement[i][j])) {
                    collides = true;
                }
            }
        }
        
        if (!collides)
            player.addGravity(dt);
    }
    
    public void draw(DrawTool drawTool) {
        smallHill.draw(drawTool);
        plain.draw(drawTool);
        abyss.draw(drawTool);
        mountin.draw(drawTool);
    }
    
    public GraphicalObject[][] getTerrain(Player player){
        GraphicalObject[][] terrainElement = null;
        
        if ((int)(player.getX()) >= smallHill.getPosX() && (int)(player.getX() + player.getWidth()) <= smallHill.getPosX() + smallHill.getWidth()){
            //im gebiet small hill
            terrainElement = smallHill.getTerrainelement();
        } else if ((int)(player.getX()) >= plain.getPosX() && (int)(player.getX() + player.getWidth()) <= plain.getPosX() + plain.getWidth()){
            //im gebiet plain
            terrainElement = plain.getTerrainelement();
        } else if ((int)(player.getX()) >= abyss.getPosX() && (int)(player.getX() + player.getWidth()) <= abyss.getPosX() + abyss.getWidth()){
            //im gebiet abyss
            terrainElement = abyss.getTerrainelement();
        }
        return terrainElement;
    }
}
