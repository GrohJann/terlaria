package control;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.Display;
import akkgframework.control.fundamental.SoundController;
import akkgframework.model.abitur.datenstrukturen.Queue;
import model.Quest;
import model.QuestDisplay;
import model.Terrain;
import model.textures.Background;
import model.textures.entitys.Player;

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
    private SoundController soundController;
    private Queue<Quest> quests;
    private QuestDisplay questDisplay;

    private Terrain terrain;
    private Player player;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse UIController. Diese wird als Parameter übergeben.
     * @param uiController das UIController-Objekt des Programms
     */
    public ProgramController(UIController uiController){
        this.uiController = uiController;
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

        //soundController.loadSound("/sounds/HiHatLoopV1.wav", "loop", true);
        //soundController.playSound("loop");

        quests = new Queue<>();
        Quest newQuest = new Quest(player,"Go to the right", 1, false);
        quests.enqueue(newQuest);
        Quest newQuest1 = new Quest(player,"Jump", 3, false);
        quests.enqueue(newQuest1);
        Quest newQuest2 = new Quest(player,"Go to the left", 1, false);
        quests.enqueue(newQuest2);
        Quest newQuest3 = new Quest(player,"Jump", 5, false);
        quests.enqueue(newQuest3);
        Quest newQuest4 = new Quest(player,"Jump", 1, false);
        quests.enqueue(newQuest4);
        Quest newQuest5 = new Quest(player,"Exist", 1, false);
        quests.enqueue(newQuest5);
        Quest newQuest6 = new Quest(player,"Exist", 1, false);
        quests.enqueue(newQuest6);
        Quest newQuest7 = new Quest(player,"Exist", 1, false);
        quests.enqueue(newQuest7);
        Quest newQuest8 = new Quest(player,"Exist", 1, false);
        quests.enqueue(newQuest8);
        Quest newQuest9 = new Quest(player,"Exist", 1, false);
        quests.enqueue(newQuest9);

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
