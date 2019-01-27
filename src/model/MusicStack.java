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


    /**
     * Spielt den abzuspielenden Sound ab und packt ihn auf den anderen Stack
     */
    public void playSample(){
        if(!sampleStack1.isEmpty() || !sampleStack2.isEmpty()) {    //Tut das Folgende nur, wenn es Objekte auf einem der beiden oder beiden Stacks gibt.
            if (stack1to2 && !sampleStack1.isEmpty()) {     //Wenn die Samples vom ersten auf den zweiten gelegt werden sollen:
                sampleStack1.top().play();                  //Spielen des obersten Sounds von dem ersten Stack.
                sampleStack2.push(sampleStack1.top());      //Der Sound wird auf den zweiten Stack gelegt...
                sampleStack1.pop();                         //...und von dem ersten genommen.
                if (sampleStack1.isEmpty()) {               //Und wenn Stack 1 nun leer ist:
                    stack1to2 = false;                      //Wechseln der "Richtung": nun von Stack 2 auf Stack 1 und nicht mehr umgekehrt.
                    sampleStack1.push(sampleStack2.top());  //Der Sound wird wieder auf den ersten Stack gelegt...
                    sampleStack2.pop();                     //...und wieder von dem zweiten genommen, damit er nicht doppelt abgespielt wird.
                }
            } else if(!stack1to2 && !sampleStack2.isEmpty()) {  //Wenn die Samples vom zweiten auf den ersten gelegt werden sollen:
                sampleStack2.top().play();                  //Spielen des obersten Sounds von dem zweiten Stack.
                sampleStack1.push(sampleStack2.top());      //Der Sound wird auf den ersten Stack gelegt...
                sampleStack2.pop();                         //...und von dem zweiten genommen.
                if (sampleStack2.isEmpty()) {               //Und wenn Stack 2 nun leer ist:
                    stack1to2 = true;                       //Wechseln der "Richtung": nun von Stack 1 auf Stack 2 und nicht mehr umgekehrt.
                    sampleStack2.push(sampleStack1.top());  //Der Sound wird wieder auf den zweiten Stack gelegt...
                    sampleStack1.pop();                     //...und wieder von dem ersten genommen, damit er nicht doppelt abgespielt wird.
                }
            } else if (!sampleStack1.isEmpty()){            //Damit es nicht passiert, dass stack1to2 nicht mehr mit den Stacks übereinstimmt
                stack1to2 = true;                           //wird es falls dies der Fall ist wieder zurückgesetzt.
            } else if (!sampleStack2.isEmpty()){            //(z.B. bei einer Zufallsgenerierung)
                stack1to2 = false;
            }
        }
    }

    /**
     * Zufälliges Rearrangieren der Stacks
     */
    public void randomize(){
        int length = countStack(sampleStack1) + countStack(sampleStack2);   //Beide Stacks werden gezählt
        Sound[] arr = new Sound[length];                //Ein Array wird mit der Länge dieser wird erstellt.
        for(int i = 0; i < arr.length; i++){            //Einfügen aller Sounds in das Array
            if(!sampleStack1.isEmpty()) {
                arr[i] = sampleStack1.top();
                sampleStack1.pop();
            }else if(!sampleStack2.isEmpty()){
                arr[i] = sampleStack2.top();
                sampleStack2.pop();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            Sound tmp = arr[i];                             //Tauschen von jedem Objekt innerhalb des Arrays
            int rand = (int) (Math.random() * arr.length);  //mit einem zufälligem anderen.
            arr[i] = arr[rand];
            arr[rand] = tmp;
        }
        for(int i = 0; i < arr.length; i++){            //Die Sounds werden in den ersten Stack zurückgelegt.
            sampleStack1.push(arr[i]);
        }
        stack1to2 = true;                               //Um Potenzielle Fehler zu beheben wird die "Richtung" auf Stack 1 zu Stack 2 gesetzt.
    }

    /**
     * Das Zählen der Objekte innerhalb eines Stacks:
     * Ein Stack wird in einen anderen übertragen und bei jedem Objekt, welches übertragen wird wird eine Variable um 1 erhöht.
     * @param stack der zu zählende Stack
     * @return Die Nummer der Objekte
     */
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
