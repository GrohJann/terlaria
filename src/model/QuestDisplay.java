package model;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

public class QuestDisplay extends GraphicalObject {

    private Quest currentQuest;

    public QuestDisplay(Quest currentQuest){
        this.currentQuest = currentQuest;
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(255,255,255,255);
        drawTool.formatText("Comic Sans",1,30);
        if(currentQuest!=null) {
            drawTool.drawText(x + 20, y + 30, "Current Quest: " + currentQuest.getTask());
            drawTool.drawText(x + 20, y + 60, "Amount: " + currentQuest.getNumber());
        }else{
            drawTool.drawText(x+20,y+30,"All quests are done!");
        }
    }

    public Quest getCurrentQuest() {
        return currentQuest;
    }

    public void setCurrentQuest(Quest currentQuest) {
        this.currentQuest = currentQuest;
    }
}
