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

    //Konstruktor
    public MusicStack(){
        //Initialisierung der beiden Stacks
        sampleStack1 = new Stack<>();
        sampleStack2 = new Stack<>();
        //Initialisierung der Variable, welche bestimmt von welchem Stack die Samples genommen und auf welchen sie gelegt werden.
        stack1to2 = true;
    }

    /**
     * Fügt ein Sample in den ersten Stack hinzu.
     * @param filename der Name des Samples, welcher hinzugefügt werden soll. (Ohne die Endung: Samples müssen wave-Dateien sein)
     */
    public void addSample(String filename){
        if(filename != null){
            Sound tmp = new Sound(filename);
            sampleStack1.push(tmp);
        }
    }

    public void playSample(){
        if(!sampleStack1.isEmpty() || !sampleStack2.isEmpty()) {
            if (stack1to2 && !sampleStack1.isEmpty()) {
                sampleStack1.top().play();
                //System.out.println("1 - " + sampleStack1.top().getPath() + " - " + sampleStack1.top().toString());
                sampleStack2.push(sampleStack1.top());
                sampleStack1.pop();
                if (sampleStack1.isEmpty()) {
                    stack1to2 = false;
                    sampleStack1.push(sampleStack2.top());
                    sampleStack2.pop();
                }
            } else if(!stack1to2 && !sampleStack2.isEmpty()) {
                sampleStack2.top().play();
                //System.out.println("2 - " + sampleStack2.top().getPath() + " - " + sampleStack2.top().toString());
                sampleStack1.push(sampleStack2.top());
                sampleStack2.pop();
                if (sampleStack2.isEmpty()) {
                    stack1to2 = true;
                    sampleStack2.push(sampleStack1.top());
                    sampleStack1.pop();
                }
            } else if (!sampleStack1.isEmpty()){
                stack1to2 = true;
            } else if (!sampleStack2.isEmpty()){
                stack1to2 = false;
            }
        }
    }

    public void randomize(){
        int length = countStack(sampleStack1) + countStack(sampleStack2);
        Sound[] arr = new Sound[length];
        for(int i = 0; i < arr.length; i++){
            if(!sampleStack1.isEmpty()) {
                arr[i] = sampleStack1.top();
                sampleStack1.pop();
            }else if(!sampleStack2.isEmpty()){
                arr[i] = sampleStack2.top();
                sampleStack2.pop();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            Sound tmp = arr[i];
            int rand = (int) (Math.random() * arr.length);
            arr[i] = arr[rand];
            arr[rand] = tmp;
        }
        for(int i = 0; i < arr.length; i++){
            sampleStack1.push(arr[i]);
        }
        stack1to2 = true;
    }

    private int countStack(Stack<Sound> stack){
        int output = 0;
        if(stack != null) {
            Stack<Sound> tmp = new Stack<>();
            while (!stack.isEmpty()) {
                tmp.push(stack.top());
                stack.pop();
                output++;
            }
            while (!tmp.isEmpty()){
                stack.push(tmp.top());
                tmp.pop();
            }
        }
        return output;
    }
}
