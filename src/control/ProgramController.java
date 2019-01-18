package control;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.Display;
import akkgframework.control.fundamental.SoundController;
import akkgframework.model.abitur.datenstrukturen.Queue;
import model.*;
import model.textures.Background;
import model.textures.entitys.Player;

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

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse UIController. Diese wird als Parameter übergeben.
     * @param uiController das UIController-Objekt des Programms
     */
    public ProgramController(UIController uiController){
        this.uiController = uiController;
        soundCon = new SoundCon();
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     */
    public void startProgram() {
        programTimer = 0;
        // ******************************************* Ab hier euer eigener Code! *******************************************
        Background background = new Background(0, 0);
        uiController.registerObject(background);

        terrain = new Terrain();
        uiController.registerObject(terrain);

        player = new Player(uiController);
        uiController.drawObjectOnPanel(player,0);

        inventory = new Inventory(uiController);
        uiController.registerObject(inventory);

        //soundCon.playSound("assets/sounds/HiHatLoopV1.wav");


        createQuests();

        questDisplay=new QuestDisplay(quests.front());
        uiController.drawObjectOnPanel(questDisplay,0);
    }

    private void createQuests(){
        quests = new Queue<>();
        Quest newQuest = new Quest(player,"Go to the right", "x",1, 150,false);
        quests.enqueue(newQuest);
        Quest newQuest1 = new Quest(player,"Spend time in the game", "time",10, 10,false);
        quests.enqueue(newQuest1);
        Quest newQuest2 = new Quest(player,"Go to the left", "x",1, -900,false);
        quests.enqueue(newQuest2);
        Quest newQuest3 = new Quest(player,"Go to the right", "x",1, 950,false);
        quests.enqueue(newQuest3);
        Quest newQuest4 = new Quest(player,"Go to the left", "x",1,-560, false);
        quests.enqueue(newQuest4);
        Quest newQuest5 = new Quest(player,"Spend time in the game", "time",60,60, false);
        quests.enqueue(newQuest5);
        Quest newQuest6 = new Quest(player,"Go to the right", "x",1, 900,false);
        quests.enqueue(newQuest6);
        Quest newQuest7 = new Quest(player,"Go to the left", "x",1, -150,false);
        quests.enqueue(newQuest7);
        Quest newQuest8 = new Quest(player,"Go to the right", "x",1, 250,false);
        quests.enqueue(newQuest8);
        Quest newQuest9 = new Quest(player,"Spend time in the game", "time",120, 120,false);
        quests.enqueue(newQuest9);
        Quest newQuest10 = new Quest(player,"Go to the left", "x",1, -950,false);
        quests.enqueue(newQuest10);
        Quest newQuest11 = new Quest(player,"Go to the right", "x",1,560, false);
        quests.enqueue(newQuest11);
        Quest newQuest12 = new Quest(player,"Spend time in the game", "time",300,300, false);
        quests.enqueue(newQuest12);
        Quest newQuest13 = new Quest(player,"Go to the left", "x",1, -900,false);
        quests.enqueue(newQuest13);
    }

    /**
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){
        programTimer += dt;
        // ******************************************* Ab hier euer eigener Code! *******************************************
        System.out.println(dt);
        //handlePlayerTerrainCollision(dt);
        if(!quests.isEmpty()) {
            quests.front().check();
            if (quests.front().isDone()) {
                quests.dequeue();
                player.setTime(0);
                questDisplay.setCurrentQuest(quests.front());
            }
        }
    }

    private void handlePlayerTerrainCollision(double dt){
        boolean collision = false;
        for (int i= 0; i < terrain.getTerrain().length; i++){
            if (terrain.getTerrain()[i][(int) (player.getX()) / 32].collidesWith(player))
                collision = true;
        }

        if (!collision)
            player.addGravity(dt);
    }

}
