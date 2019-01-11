package model;

import akkgframework.control.fundamental.SoundController;
import akkgframework.model.abitur.datenstrukturen.Stack;

public class MusicStack {
    private Stack<String> sampleStack1;
    private Stack<String> sampleStack2;
    private boolean stack1to2;
    SoundController soundController;

    public MusicStack(SoundController soundController){
        this.soundController = soundController;
        sampleStack1 = new Stack<>();
        sampleStack2 = new Stack<>();
        stack1to2 = true;
    }

    public boolean addSample(String filename, String name){
        if(filename != null && name != null){
            soundController.loadSound(filename, name, false);
            sampleStack1.push(name);
        }
        return false;
    }

    public String getSample(){
        if(stack1to2){
            sampleStack2.push(sampleStack1.top());
            sampleStack1.pop();
            if(sampleStack1.isEmpty()){
                stack1to2 = false;
            }
            return sampleStack2.top();
        }else{
            sampleStack1.push(sampleStack2.top());
            sampleStack2.pop();
            if(sampleStack2.isEmpty()){
                stack1to2 = true;
            }
            return sampleStack1.top();
        }
    }

    public void update(double dt){

    }
}
