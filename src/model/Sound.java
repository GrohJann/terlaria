package model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Sound {

    //Referenzen
    private String path;
    private Clip clip;

    //Konstruktor
    public Sound(String fileName) {
        try {
            File file = new File("assets/sounds/" +fileName +".wav");
            path = "assets/sounds/" +fileName +".wav";
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                // lädt den Sound in den Specher
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            else {
                throw new RuntimeException("Sound: file not found: " + fileName);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Malformed URL: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
        }
    }

    //Abspielen des Sounds
    public void play(){
        clip.setFramePosition(0);  // Zurücksetzen des Sounds auf den Ursprung
        clip.start();
    }

    //Loopen des Sounds
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    //Stoppen des Sounds
    public void stop(){
        clip.stop();
    }

    public String getPath(){
        return path;
    }
}
