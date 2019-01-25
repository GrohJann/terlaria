package control;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.Display;
import akkgframework.model.abitur.datenstrukturen.Queue;
import akkgframework.model.fundamental.GraphicalObject;
import model.Inventory;
import model.Quest;
import model.QuestDisplay;
import model.Terrain;
import model.objects.ItemDirt;
import model.objects.Shovel;
import model.textures.Background;
import model.textures.blocks.Grass;
import model.textures.entitys.Player;

import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute
    private double programTimer;

    // Referenzen
    private UIController uiController;  // diese Referenz soll auf ein Objekt der Klasse uiController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Display programmZeitAnzeige;
    private SoundCon soundCon;
    private Queue<Quest> quests;
    private QuestDisplay questDisplay;

    private Terrain terrain;
    private Player player;
    private Inventory inventory;

    private Grass grass;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse UIController. Diese wird als Parameter übergeben.
     * @param uiController das UIController-Objekt des Programms
     */
    public ProgramController(UIController uiController){
        this.uiController = uiController;
        terrain = new Terrain();
        soundCon = new SoundCon();
        grass = new Grass(1000, 200);
        player = new Player(uiController);
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     */
    public void startProgram() {
        programTimer = 0;
        // ******************************************* Ab hier euer eigener Code! *******************************************
        Background background = new Background(0, 0);
        uiController.registerObject(background);

        //uiController.registerObject(terrain);

        uiController.registerObject(grass);


        uiController.registerObject(player);

        inventory = new Inventory(uiController);
        uiController.registerObject(inventory);

        createQuests();

        questDisplay=new QuestDisplay(quests.front());
        uiController.drawObjectOnPanel(questDisplay,0);
    }

    /**
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){
        programTimer += dt;
        // ******************************************* Ab hier euer eigener Code! *******************************************
        //handlePlayerTerrainCollision(dt);
        if (player.collidesWithLeft(grass)) {
            //player.setX(grass.getX() - player.getWidth());
            //System.out.println("collides left");

        }
        if (player.collidesWithRight(grass)) {
            //player.setX(grass.getX() + grass.getWidth());
            //System.out.println("collides right");
        }
        if (player.collidesWithBottom(grass)) {
            //player.setY(grass.getY() + grass.getHeight());
            //System.out.println("collides bottom");
        }
        if (!player.collidesWithTop(grass)) {
            player.addGravity(dt);
            //System.out.println("collides top");
        }

        soundCon.update(dt);

        if(!quests.isEmpty()) {
            quests.front().check();
            if (quests.front().isDone()) {
                quests.dequeue();
                player.setTime(0);
                questDisplay.setCurrentQuest(quests.front());
                soundCon.stage++;
                if (quests.front().isReward()){
                    if(inventory.searchItem("Shovel") == -1){
                        inventory.addItem(new Shovel("Shovel",1));
                    }else {
                        inventory.addItem(new ItemDirt("Dirt",1));
                    }
                }
            }
        }
    }

    private void createQuests(){
        quests = new Queue<>();
        Quest newQuest = new Quest(player,"Go to the right", "x",1, 1590,"right",false,true);
        quests.enqueue(newQuest);
        Quest newQuest1 = new Quest(player,"Spend time in the game", "time",10, 10 ,"",false,false);
        quests.enqueue(newQuest1);
        Quest newQuest2 = new Quest(player,"Go to the left", "x",1, 150,"left",false,true);
        quests.enqueue(newQuest2);
        Quest newQuest3 = new Quest(player,"Go to the right", "x",1, 1850,"right",false,false);
        quests.enqueue(newQuest3);
        Quest newQuest4 = new Quest(player,"Go to the left", "x",1,200, "left",false,false);
        quests.enqueue(newQuest4);
        Quest newQuest5 = new Quest(player,"Spend time in the game", "time",60,60, "",false,false);
        quests.enqueue(newQuest5);
        Quest newQuest6 = new Quest(player,"Go to the right", "x",1, 1200,"right",false,false);
        quests.enqueue(newQuest6);
        Quest newQuest7 = new Quest(player,"Go to the left", "x",1, 150,"left",false,false);
        quests.enqueue(newQuest7);
        Quest newQuest8 = new Quest(player,"Go to the right", "x",1, 1500,"right",false,false);
        quests.enqueue(newQuest8);
        Quest newQuest9 = new Quest(player,"Spend time in the game", "time",120, 120,"",false,false);
        quests.enqueue(newQuest9);
        Quest newQuest10 = new Quest(player,"Go to the left", "x",1, 250,"left",false,false);
        quests.enqueue(newQuest10);
        Quest newQuest11 = new Quest(player,"Go to the right", "x",1,1560,"right",false,false);
        quests.enqueue(newQuest11);
        Quest newQuest12 = new Quest(player,"Spend time in the game", "time",300,300, "",false,false);
        quests.enqueue(newQuest12);
        Quest newQuest13 = new Quest(player,"Go to the left", "x",1, 150,"left",false,false);
        quests.enqueue(newQuest13);
    }

    private void handlePlayerTerrainCollision(double dt){
        boolean collision = false;
        GraphicalObject[][] terrainArray = terrain.getTerrain();
        for (int i= 0; i < terrain.getTerrain().length; i++){
            if (terrainArray[i][(int) (player.getX()) / 32].collidesWith(player))
                collision = true;
        }

        if (!collision)
            player.addGravity(dt);
    }

}
