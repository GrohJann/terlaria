package control;

import javax.sound.sampled.*;
import java.io.File;

public class SoundCon{




    public static synchronized void playSound(String file){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream((new File(file))));
            clip.start();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
