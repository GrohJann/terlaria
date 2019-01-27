package model.terrainelements;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;
import model.textures.blocks.Dirt;
import model.textures.blocks.Grass;
import model.textures.blocks.Stone;

public class Plain {
    GraphicalObject[][] terrainelement;
    Grass grass;
    Dirt dirt;
    Stone stone;
    
    int posX;
    
    public Plain(int posX) {
        this.posX = posX;
        generateTerrain();
    }
    
    private void generateTerrain() {
        terrainelement = new GraphicalObject[][]{
                {
                        grass = new Grass(posX + (32 * 9), 32 * 16),
                        grass = new Grass(posX + (32 * 10), 32 * 16),
                        grass = new Grass(posX + (32 * 11), 32 * 16),
                },
                
                {
                        grass = new Grass(posX + (32 * 5), 32 * 17),
                        grass = new Grass(posX + (32 * 6), 32 * 17),
                        grass = new Grass(posX + (32 * 7), 32 * 17),
                        grass = new Grass(posX + (32 * 8), 32 * 17),
                        dirt = new Dirt(posX + (32 * 9), 32 * 17),
                        dirt = new Dirt(posX + (32 * 10), 32 * 17),
                        dirt = new Dirt(posX + (32 * 11), 32 * 17),
                        grass = new Grass(posX + (32 * 12), 32 * 17),
                },
                
                {
                        grass = new Grass(posX + (32 * 0), 32 * 18),
                        grass = new Grass(posX + (32 * 1), 32 * 18),
                        grass = new Grass(posX + (32 * 2), 32 * 18),
                        grass = new Grass(posX + (32 * 3), 32 * 18),
                        grass = new Grass(posX + (32 * 4), 32 * 18),
                        dirt = new Dirt(posX + (32 * 5), 32 * 18),
                        dirt = new Dirt(posX + (32 * 6), 32 * 18),
                        dirt = new Dirt(posX + (32 * 7), 32 * 18),
                        dirt = new Dirt(posX + (32 * 8), 32 * 18),
                        dirt = new Dirt(posX + (32 * 9), 32 * 18),
                        dirt = new Dirt(posX + (32 * 10), 32 * 18),
                        dirt = new Dirt(posX + (32 * 11), 32 * 18),
                        dirt = new Dirt(posX + (32 * 12), 32 * 18),
                        grass = new Grass(posX + (32 * 13), 32 * 18),
                        grass = new Grass(posX + (32 * 14), 32 * 18),
                },
                
                {
                        dirt = new Dirt(posX + (32 * 0), 32 * 19),
                        dirt = new Dirt(posX + (32 * 1), 32 * 19),
                        dirt = new Dirt(posX + (32 * 2), 32 * 19),
                        dirt = new Dirt(posX + (32 * 3), 32 * 19),
                        dirt = new Dirt(posX + (32 * 4), 32 * 19),
                        dirt = new Dirt(posX + (32 * 5), 32 * 19),
                        dirt = new Dirt(posX + (32 * 6), 32 * 19),
                        dirt = new Dirt(posX + (32 * 7), 32 * 19),
                        dirt = new Dirt(posX + (32 * 8), 32 * 19),
                        dirt = new Dirt(posX + (32 * 9), 32 * 19),
                        dirt = new Dirt(posX + (32 * 10), 32 * 19),
                        dirt = new Dirt(posX + (32 * 11), 32 * 19),
                        dirt = new Dirt(posX + (32 * 12), 32 * 19),
                        dirt = new Dirt(posX + (32 * 13), 32 * 19),
                        dirt = new Dirt(posX + (32 * 14), 32 * 19),
                },
                
                {
                        dirt = new Dirt(posX + (32 * 0), 32 * 20),
                        dirt = new Dirt(posX + (32 * 1), 32 * 20),
                        dirt = new Dirt(posX + (32 * 2), 32 * 20),
                        dirt = new Dirt(posX + (32 * 3), 32 * 20),
                        dirt = new Dirt(posX + (32 * 4), 32 * 20),
                        stone = new Stone(posX + (32 * 5), 32 * 20),
                        stone = new Stone(posX + (32 * 6), 32 * 20),
                        stone = new Stone(posX + (32 * 7), 32 * 20),
                        stone = new Stone(posX + (32 * 8), 32 * 20),
                        stone = new Stone(posX + (32 * 9), 32 * 20),
                        dirt = new Dirt(posX + (32 * 10), 32 * 20),
                        dirt = new Dirt(posX + (32 * 11), 32 * 20),
                        dirt = new Dirt(posX + (32 * 12), 32 * 20),
                        dirt = new Dirt(posX + (32 * 13), 32 * 20),
                        dirt = new Dirt(posX + (32 * 14), 32 * 20),
                },
                
                {
                        dirt = new Dirt(posX + (32 * 0), 32 * 21),
                        dirt = new Dirt(posX + (32 * 1), 32 * 21),
                        stone = new Stone(posX + (32 * 2), 32 * 21),
                        stone = new Stone(posX + (32 * 3), 32 * 21),
                        stone = new Stone(posX + (32 * 4), 32 * 21),
                        stone = new Stone(posX + (32 * 5), 32 * 21),
                        stone = new Stone(posX + (32 * 6), 32 * 21),
                        stone = new Stone(posX + (32 * 7), 32 * 21),
                        stone = new Stone(posX + (32 * 8), 32 * 21),
                        stone = new Stone(posX + (32 * 9), 32 * 21),
                        stone = new Stone(posX + (32 * 10), 32 * 21),
                        stone = new Stone(posX + (32 * 11), 32 * 21),
                        dirt = new Dirt(posX + (32 * 12), 32 * 21),
                        dirt = new Dirt(posX + (32 * 13), 32 * 21),
                        dirt = new Dirt(posX + (32 * 14), 32 * 21),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 22),
                        stone = new Stone(posX + (32 * 1), 32 * 22),
                        stone = new Stone(posX + (32 * 2), 32 * 22),
                        stone = new Stone(posX + (32 * 3), 32 * 22),
                        stone = new Stone(posX + (32 * 4), 32 * 22),
                        stone = new Stone(posX + (32 * 5), 32 * 22),
                        stone = new Stone(posX + (32 * 6), 32 * 22),
                        stone = new Stone(posX + (32 * 7), 32 * 22),
                        stone = new Stone(posX + (32 * 8), 32 * 22),
                        stone = new Stone(posX + (32 * 9), 32 * 22),
                        stone = new Stone(posX + (32 * 10), 32 * 22),
                        stone = new Stone(posX + (32 * 11), 32 * 22),
                        stone = new Stone(posX + (32 * 12), 32 * 22),
                        stone = new Stone(posX + (32 * 13), 32 * 22),
                        stone = new Stone(posX + (32 * 14), 32 * 22),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 23),
                        stone = new Stone(posX + (32 * 1), 32 * 23),
                        stone = new Stone(posX + (32 * 2), 32 * 23),
                        stone = new Stone(posX + (32 * 3), 32 * 23),
                        stone = new Stone(posX + (32 * 4), 32 * 23),
                        stone = new Stone(posX + (32 * 5), 32 * 23),
                        stone = new Stone(posX + (32 * 6), 32 * 23),
                        stone = new Stone(posX + (32 * 7), 32 * 23),
                        stone = new Stone(posX + (32 * 8), 32 * 23),
                        stone = new Stone(posX + (32 * 9), 32 * 23),
                        stone = new Stone(posX + (32 * 10), 32 * 23),
                        stone = new Stone(posX + (32 * 11), 32 * 23),
                        stone = new Stone(posX + (32 * 12), 32 * 23),
                        stone = new Stone(posX + (32 * 13), 32 * 23),
                        stone = new Stone(posX + (32 * 14), 32 * 23),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 24),
                        stone = new Stone(posX + (32 * 1), 32 * 24),
                        stone = new Stone(posX + (32 * 2), 32 * 24),
                        stone = new Stone(posX + (32 * 3), 32 * 24),
                        stone = new Stone(posX + (32 * 4), 32 * 24),
                        stone = new Stone(posX + (32 * 5), 32 * 24),
                        stone = new Stone(posX + (32 * 6), 32 * 24),
                        stone = new Stone(posX + (32 * 7), 32 * 24),
                        stone = new Stone(posX + (32 * 8), 32 * 24),
                        stone = new Stone(posX + (32 * 9), 32 * 24),
                        stone = new Stone(posX + (32 * 10), 32 * 24),
                        stone = new Stone(posX + (32 * 11), 32 * 24),
                        stone = new Stone(posX + (32 * 12), 32 * 24),
                        stone = new Stone(posX + (32 * 13), 32 * 24),
                        stone = new Stone(posX + (32 * 14), 32 * 24),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 25),
                        stone = new Stone(posX + (32 * 1), 32 * 25),
                        stone = new Stone(posX + (32 * 2), 32 * 25),
                        stone = new Stone(posX + (32 * 3), 32 * 25),
                        stone = new Stone(posX + (32 * 4), 32 * 25),
                        stone = new Stone(posX + (32 * 5), 32 * 25),
                        stone = new Stone(posX + (32 * 6), 32 * 25),
                        stone = new Stone(posX + (32 * 7), 32 * 25),
                        stone = new Stone(posX + (32 * 8), 32 * 25),
                        stone = new Stone(posX + (32 * 9), 32 * 25),
                        stone = new Stone(posX + (32 * 10), 32 * 25),
                        stone = new Stone(posX + (32 * 11), 32 * 25),
                        stone = new Stone(posX + (32 * 12), 32 * 25),
                        stone = new Stone(posX + (32 * 13), 32 * 25),
                        stone = new Stone(posX + (32 * 14), 32 * 25),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 26),
                        stone = new Stone(posX + (32 * 1), 32 * 26),
                        stone = new Stone(posX + (32 * 2), 32 * 26),
                        stone = new Stone(posX + (32 * 3), 32 * 26),
                        stone = new Stone(posX + (32 * 4), 32 * 26),
                        stone = new Stone(posX + (32 * 5), 32 * 26),
                        stone = new Stone(posX + (32 * 6), 32 * 26),
                        stone = new Stone(posX + (32 * 7), 32 * 26),
                        stone = new Stone(posX + (32 * 8), 32 * 26),
                        stone = new Stone(posX + (32 * 9), 32 * 26),
                        stone = new Stone(posX + (32 * 10), 32 * 26),
                        stone = new Stone(posX + (32 * 11), 32 * 26),
                        stone = new Stone(posX + (32 * 12), 32 * 26),
                        stone = new Stone(posX + (32 * 13), 32 * 26),
                        stone = new Stone(posX + (32 * 14), 32 * 26),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 27),
                        stone = new Stone(posX + (32 * 1), 32 * 27),
                        stone = new Stone(posX + (32 * 2), 32 * 27),
                        stone = new Stone(posX + (32 * 3), 32 * 27),
                        stone = new Stone(posX + (32 * 4), 32 * 27),
                        stone = new Stone(posX + (32 * 5), 32 * 27),
                        stone = new Stone(posX + (32 * 6), 32 * 27),
                        stone = new Stone(posX + (32 * 7), 32 * 27),
                        stone = new Stone(posX + (32 * 8), 32 * 27),
                        stone = new Stone(posX + (32 * 9), 32 * 27),
                        stone = new Stone(posX + (32 * 10), 32 * 27),
                        stone = new Stone(posX + (32 * 11), 32 * 27),
                        stone = new Stone(posX + (32 * 12), 32 * 27),
                        stone = new Stone(posX + (32 * 13), 32 * 27),
                        stone = new Stone(posX + (32 * 14), 32 * 27),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 28),
                        stone = new Stone(posX + (32 * 1), 32 * 28),
                        stone = new Stone(posX + (32 * 2), 32 * 28),
                        stone = new Stone(posX + (32 * 3), 32 * 28),
                        stone = new Stone(posX + (32 * 4), 32 * 28),
                        stone = new Stone(posX + (32 * 5), 32 * 28),
                        stone = new Stone(posX + (32 * 6), 32 * 28),
                        stone = new Stone(posX + (32 * 7), 32 * 28),
                        stone = new Stone(posX + (32 * 8), 32 * 28),
                        stone = new Stone(posX + (32 * 9), 32 * 28),
                        stone = new Stone(posX + (32 * 10), 32 * 28),
                        stone = new Stone(posX + (32 * 11), 32 * 28),
                        stone = new Stone(posX + (32 * 12), 32 * 28),
                        stone = new Stone(posX + (32 * 13), 32 * 28),
                        stone = new Stone(posX + (32 * 14), 32 * 28),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 29),
                        stone = new Stone(posX + (32 * 1), 32 * 29),
                        stone = new Stone(posX + (32 * 2), 32 * 29),
                        stone = new Stone(posX + (32 * 3), 32 * 29),
                        stone = new Stone(posX + (32 * 4), 32 * 29),
                        stone = new Stone(posX + (32 * 5), 32 * 29),
                        stone = new Stone(posX + (32 * 6), 32 * 29),
                        stone = new Stone(posX + (32 * 7), 32 * 29),
                        stone = new Stone(posX + (32 * 8), 32 * 29),
                        stone = new Stone(posX + (32 * 9), 32 * 29),
                        stone = new Stone(posX + (32 * 10), 32 * 29),
                        stone = new Stone(posX + (32 * 11), 32 * 29),
                        stone = new Stone(posX + (32 * 12), 32 * 29),
                        stone = new Stone(posX + (32 * 13), 32 * 29),
                        stone = new Stone(posX + (32 * 14), 32 * 29),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 30),
                        stone = new Stone(posX + (32 * 1), 32 * 30),
                        stone = new Stone(posX + (32 * 2), 32 * 30),
                        stone = new Stone(posX + (32 * 3), 32 * 30),
                        stone = new Stone(posX + (32 * 4), 32 * 30),
                        stone = new Stone(posX + (32 * 5), 32 * 30),
                        stone = new Stone(posX + (32 * 6), 32 * 30),
                        stone = new Stone(posX + (32 * 7), 32 * 30),
                        stone = new Stone(posX + (32 * 8), 32 * 30),
                        stone = new Stone(posX + (32 * 9), 32 * 30),
                        stone = new Stone(posX + (32 * 10), 32 * 30),
                        stone = new Stone(posX + (32 * 11), 32 * 30),
                        stone = new Stone(posX + (32 * 12), 32 * 30),
                        stone = new Stone(posX + (32 * 13), 32 * 30),
                        stone = new Stone(posX + (32 * 14), 32 * 30),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 31),
                        stone = new Stone(posX + (32 * 1), 32 * 31),
                        stone = new Stone(posX + (32 * 2), 32 * 31),
                        stone = new Stone(posX + (32 * 3), 32 * 31),
                        stone = new Stone(posX + (32 * 4), 32 * 31),
                        stone = new Stone(posX + (32 * 5), 32 * 31),
                        stone = new Stone(posX + (32 * 6), 32 * 31),
                        stone = new Stone(posX + (32 * 7), 32 * 31),
                        stone = new Stone(posX + (32 * 8), 32 * 31),
                        stone = new Stone(posX + (32 * 9), 32 * 31),
                        stone = new Stone(posX + (32 * 10), 32 * 31),
                        stone = new Stone(posX + (32 * 11), 32 * 31),
                        stone = new Stone(posX + (32 * 12), 32 * 31),
                        stone = new Stone(posX + (32 * 13), 32 * 31),
                        stone = new Stone(posX + (32 * 14), 32 * 31),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 32),
                        stone = new Stone(posX + (32 * 1), 32 * 32),
                        stone = new Stone(posX + (32 * 2), 32 * 32),
                        stone = new Stone(posX + (32 * 3), 32 * 32),
                        stone = new Stone(posX + (32 * 4), 32 * 32),
                        stone = new Stone(posX + (32 * 5), 32 * 32),
                        stone = new Stone(posX + (32 * 6), 32 * 32),
                        stone = new Stone(posX + (32 * 7), 32 * 32),
                        stone = new Stone(posX + (32 * 8), 32 * 32),
                        stone = new Stone(posX + (32 * 9), 32 * 32),
                        stone = new Stone(posX + (32 * 10), 32 * 32),
                        stone = new Stone(posX + (32 * 11), 32 * 32),
                        stone = new Stone(posX + (32 * 12), 32 * 32),
                        stone = new Stone(posX + (32 * 13), 32 * 32),
                        stone = new Stone(posX + (32 * 14), 32 * 32),
                },
                
                {
                        stone = new Stone(posX + (32 * 0), 32 * 33),
                        stone = new Stone(posX + (32 * 1), 32 * 33),
                        stone = new Stone(posX + (32 * 2), 32 * 33),
                        stone = new Stone(posX + (32 * 3), 32 * 33),
                        stone = new Stone(posX + (32 * 4), 32 * 33),
                        stone = new Stone(posX + (32 * 5), 32 * 33),
                        stone = new Stone(posX + (32 * 6), 32 * 33),
                        stone = new Stone(posX + (32 * 7), 32 * 33),
                        stone = new Stone(posX + (32 * 8), 32 * 33),
                        stone = new Stone(posX + (32 * 9), 32 * 33),
                        stone = new Stone(posX + (32 * 10), 32 * 33),
                        stone = new Stone(posX + (32 * 11), 32 * 33),
                        stone = new Stone(posX + (32 * 12), 32 * 33),
                        stone = new Stone(posX + (32 * 13), 32 * 33),
                        stone = new Stone(posX + (32 * 14), 32 * 33),
                },
            
        };
    }
    
    public void draw(DrawTool drawTool) {
        for (int i = 0; i < terrainelement.length; i++) {
            for (int j = 0; j < terrainelement[i].length; j++) {
                drawTool.drawImage(terrainelement[i][j].getMyImage(), terrainelement[i][j].getX(), terrainelement[i][j].getY());
            }
        }
    }
    
    public GraphicalObject[][] getTerrainelement() {
        return terrainelement;
    }
    
    public int getPosX() {
        return posX;
    }
    
    public  int getWidth(){
        return 32 * 15;
    }
}

