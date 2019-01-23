package control;

import model.MusicStack;


public class SoundCon{

    //Sound loop = new Sound("HiHatLoopV1");
    private MusicStack melody = new MusicStack();
    private MusicStack bass = new MusicStack();
    private MusicStack cymbals = new MusicStack();
    private double timerMelody;
    private double timerBass;
    private double timerCymbals;
    private double melodySpeed;
    private double bassSpeed;
    private double cymbalSpeed;
    private boolean melodyPlays;
    private boolean bassPlays;
    private boolean cymbalsPlay;
    int stage;
    //boolean loopPlays = false;

    public SoundCon(){
        stage = 0;

        timerMelody = 0;
        timerBass = 0;
        timerCymbals = 0;

        melodySpeed = 1;
        bassSpeed = 4;
        cymbalSpeed = 0.25;

        melodyPlays = true;
        bassPlays = false;
        cymbalsPlay = false;

        melody.addSample("melody C3");
        melody.addSample("melody D3");
        cymbals.addSample("silence");
        cymbals.addSample("silence");
        cymbals.addSample("silence");
    }

    public void update(double dt){
        timerMelody = timerMelody + dt;
        timerBass = timerBass + dt;
        timerCymbals = timerCymbals + dt;

        if(melodyPlays && timerMelody >= melodySpeed){
            melody.playSample();
            timerMelody = 0;
        }

        if(bassPlays && timerBass >= bassSpeed){
            bass.playSample();
            timerBass = 0;
        }

        if(cymbalsPlay && timerCymbals >= cymbalSpeed){
            cymbals.playSample();
            timerCymbals = 0;
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
            bassPlays = true;
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
            //cymbalsPlay = true;
            bass.addSample("bass F3");
            bass.addSample("bass D2");
            cymbals.addSample("temp C high");
            melody.randomize();
            stage++;
        }
        if(stage == 11){
            bass.addSample("bass G3");
            melody.randomize();
            stage++;
        }
        if(stage == 13){
            melody.randomize();
            bass.addSample("bass A2");
            //cymbals.delete("silence");
            cymbals.addSample("temp C");
            cymbals.addSample("silence");
            cymbals.addSample("silence");
            stage++;
        }
    }

}
