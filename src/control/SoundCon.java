package control;

import model.MusicStack;
import model.Sound;

import javax.sound.sampled.*;
import java.io.File;

public class SoundCon{

    //Sound loop = new Sound("HiHatLoopV1.wav");
    MusicStack melody = new MusicStack();
    double timer;
    double timer2;
    double melodySpeed;
    boolean loopPlays = false;

    public SoundCon(){
        melodySpeed = 1;
        melody.addSample("melody C3");
        melody.addSample("melody D3");
        timer = 0;
    }

    public void update(double dt){
        timer = timer + dt;
        timer2 = timer2 + dt;

        if(timer >= melodySpeed){
            melody.playSample();
            timer = 0;
        }

        /*if(!loopPlays){
            loop.play();
            loop.loop();
            loopPlays = true;
        }*/

        if(timer2 >= 10 && timer2 < 11){
            melody.addSample("melody D2");
            timer2 = 11;
            melodySpeed = 0.5;
        }
        if(timer2 >= 21 && timer2 < 22){
            melody.addSample("melody F2");
            melody.addSample("melody G3");
            timer2 = 22;
            melody.randomize();
            melodySpeed = 1;
        }
        if(timer2 >= 32 && timer2 < 33){
            melody.addSample("melody A2");
            melody.addSample("melody F3");
            melody.addSample("melody G2");
            timer2 = 33;
            melodySpeed = 0.5;
        }
    }

}
