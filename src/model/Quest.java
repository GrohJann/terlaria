package model;

import akkgframework.model.abitur.datenstrukturen.List;
import akkgframework.model.fundamental.GraphicalObject;

public class Quest{

    private int number;
    private boolean done;

    private String task;
    private Player player;

    public Quest(Player player,String task, int number, boolean done){
        this.player=player;
        fillQuests(task, number, done);
    }

    public void fillQuests(String task, int number, boolean done){
        this.task=task;
        this.number=number;
        this.done=done;
    }

    public void check(){
        /*if(player.getTask(task)>=number){
            setDone(true);
        }*/
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
