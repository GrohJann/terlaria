package control;

import model.MusicStack;
import model.Sound;


public class SoundCon{

    //Sound loop = new Sound("HiHatLoopV1.wav");
    private MusicStack melody = new MusicStack();
    private MusicStack bass = new MusicStack();
    private double timer;
    private double timer2;
    private double melodySpeed;
    private double bassSpeed;
    int stage;
    private boolean randomizeMelody;
    //boolean loopPlays = false;

    public SoundCon(){
        melodySpeed = 1;
        bassSpeed = 4;
        melody.addSample("melody C3");
        melody.addSample("melody D3");
        timer = 0;
        stage = 0;
        randomizeMelody = false;
    }

    public void update(double dt){
        timer = timer + dt;
        timer2 = timer2 + dt;

        if(timer >= melodySpeed){
            melody.playSample();
            timer = 0;
        }

        if(timer2 >= bassSpeed){
            bass.playSample();
            timer2 = 0;
        }
        /*if(!loopPlays){
            loop.play();
            loop.loop();
            loopPlays = true;
        }*/

        if(stage == 1){
            melody.addSample("melody D2");
            stage++;
        }
        if(stage == 3){
            melody.addSample("melody F2");
            melody.addSample("melody G2");
            bass.addSample("bass D3");
            bass.addSample("bass G2");
            stage++;
        }
        if(stage == 5){
            melody.addSample("melody A2");
            melody.addSample("melody F3");
            bass.addSample("bass C3");
            stage++;
        }
        if(stage == 7){
            melody.addSample("melody G3");
            melodySpeed = 0.5;
            bass.addSample("bass F2");
            stage++;
        }
        if(stage == 9){
            bass.addSample("bass F3");
            bass.addSample("bass D2");
            melody.randomize();
            stage++;
        }
        if(stage == 11){
            bass.addSample("bass G3");
            bass.addSample("bass A2");
            melody.randomize();
            stage++;
        }
    }

}
