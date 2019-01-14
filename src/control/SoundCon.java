package control;

import model.MusicStack;
import model.Sound;

import javax.sound.sampled.*;
import java.io.File;

public class SoundCon{

    Sound loop = new Sound("assets/sounds/HiHatLoopV1.wav");
    MusicStack melody = new MusicStack();

    public SoundCon(){
        loop.play();
        loop.loop();
        melody.addSample("assets/sounds/temp C.wav");
        melody.playSample();
    }

    public static synchronized void playSound(String file){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream((new File(file))));
            clip.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(double dt){

    }

}
