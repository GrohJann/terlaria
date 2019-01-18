package model;

import akkgframework.control.fundamental.SoundController;
import akkgframework.model.abitur.datenstrukturen.Queue;
import akkgframework.model.abitur.datenstrukturen.Stack;

public class MusicStack {
    //Attribute
    private boolean stack1to2;

    //Referenzen
    private Stack<Sound> sampleStack1;
    private Stack<Sound> sampleStack2;
    private Queue<Sound> waitingSamples;

    public MusicStack(){
        sampleStack1 = new Stack<>();
        sampleStack2 = new Stack<>();
        waitingSamples = new Queue<>();
        stack1to2 = true;
    }

    public void addSample(String filename){
        if(filename != null){
            Sound tmp = new Sound(filename);
            waitingSamples.enqueue(tmp);
        }
    }

    public void playSample(){
        if(!sampleStack1.isEmpty() || !sampleStack2.isEmpty()) {
            if (stack1to2) {
                if (!waitingSamples.isEmpty()) {
                    sampleStack2.push(waitingSamples.front());
                    waitingSamples.dequeue();
                }
                sampleStack1.top().play();
                //System.out.println("1 - " + sampleStack1.top().getPath() + " - " + sampleStack1.top().toString());
                sampleStack2.push(sampleStack1.top());
                sampleStack1.pop();
                if (sampleStack1.isEmpty()) {
                    stack1to2 = false;
                    sampleStack1.push(sampleStack2.top());
                    sampleStack2.pop();
                }
            } else {
                if (!waitingSamples.isEmpty()) {
                    sampleStack1.push(waitingSamples.front());
                    waitingSamples.dequeue();
                }
                sampleStack2.top().play();
                //System.out.println("2 - " + sampleStack2.top().getPath() + " - " + sampleStack2.top().toString());
                sampleStack1.push(sampleStack2.top());
                sampleStack2.pop();
                if (sampleStack2.isEmpty()) {
                    stack1to2 = true;
                    sampleStack2.push(sampleStack1.top());
                    sampleStack1.pop();
                }
            }
        }else{
            if (!waitingSamples.isEmpty()) {
                sampleStack1.push(waitingSamples.front());
                waitingSamples.dequeue();
            }
        }
    }

    public void update(double dt){

    }
}
