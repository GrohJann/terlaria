package model;

import akkgframework.control.fundamental.SoundController;
import akkgframework.model.abitur.datenstrukturen.Stack;

public class MusicStack {
    //Attribute
    private boolean stack1to2;

    //Referenzen
    private Stack<Sound> sampleStack1;
    private Stack<Sound> sampleStack2;

    public MusicStack(){
        sampleStack1 = new Stack<>();
        sampleStack2 = new Stack<>();
        stack1to2 = true;
    }

    public boolean addSample(String filename){
        if(filename != null){
            Sound tmp = new Sound(filename);
            sampleStack1.push(tmp);
        }
        return false;
    }

    public void playSample(){
        if(stack1to2){
            sampleStack2.push(sampleStack1.top());
            sampleStack1.pop();
            if(sampleStack1.isEmpty()){
                stack1to2 = false;
            }
            sampleStack2.top().play();
        }else{
            sampleStack1.push(sampleStack2.top());
            sampleStack2.pop();
            if(sampleStack2.isEmpty()){
                stack1to2 = true;
            }
            sampleStack1.top().play();
        }
    }

    public void update(double dt){

    }
}
