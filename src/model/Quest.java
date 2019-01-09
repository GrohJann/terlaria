package model;

import akkgframework.model.abitur.datenstrukturen.List;
import akkgframework.model.fundamental.GraphicalObject;

public class Quest{

    private List<String> task;

    public Quest(){
        task=new List<>();
    }

    public void fillQuests(String task){
        this.task.append(task);
    }
}
