package model;

import akkgframework.control.fundamental.SoundController;
import akkgframework.model.abitur.datenstrukturen.Stack;

public class MusicStack {
    private Stack<String> sampleStack1;
    private Stack<String> sampleStack2;
    SoundController soundController;

    public MusicStack(SoundController soundController){
        this.soundController = soundController;
    }

    public boolean addSample(String filename, String name){
        if(filename != null && name != null){
            soundController.loadSound(filename, name, false);
            sampleStack1.push(name);
        }
        return false;
    }

    public void update(double dt){

    }
}
