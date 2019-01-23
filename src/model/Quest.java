package model;

import akkgframework.model.abitur.datenstrukturen.List;
import akkgframework.model.fundamental.GraphicalObject;
import model.textures.entitys.Player;

public class Quest {

    private int number;
    private int commandNumber;
    private boolean done;

    private String task;
    private String command;
    private String direction;
    private Player player;

    public Quest(Player player, String task, String command, int number, int commandNumber, String direction, boolean done) {
        this.player = player;
        fillQuests(task, command, number, commandNumber, direction, done);
    }

    public void fillQuests(String task, String command, int number, int commandNumber, String direction, boolean done) {
        this.task = task;
        this.command = command;
        this.number = number;
        this.commandNumber = commandNumber;
        this.direction=direction;
        this.done = done;
    }

    public void check() {
        if (commandNumber > 1) {
            if (player.getTask(command, direction) > commandNumber) {
                setDone(true);
            }
        }
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
