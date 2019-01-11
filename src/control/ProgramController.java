package control;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.Display;
import akkgframework.control.fundamental.SoundController;
import model.Terrain;
import model.textures.Background;
import model.textures.blocks.Dirt;
import model.textures.blocks.Grass;
import model.textures.blocks.Water;
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

    private model.textures.entitys.Player player;
    private Terrain terrain;

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
