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
    private boolean reward;

    public Quest(Player player, String task, String command, int number, int commandNumber, String direction, boolean done, boolean reward) {
        this.player = player;
        fillQuests(task, command, number, commandNumber, direction, done, reward);
    }

    public void fillQuests(String task, String command, int number, int commandNumber, String direction, boolean done, boolean reward) {
        this.task = task;
        this.command = command;
        this.number = number;
        this.commandNumber = commandNumber;
        this.direction=direction;
        this.done = done;
        this.reward=reward;
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

    public int getCommandNumber() {
        return commandNumber;
    }

    public void setCommandNumber(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isReward() {
        return reward;
    }

    public void setReward(boolean reward) {
        this.reward = reward;
    }
}
