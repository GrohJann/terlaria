package control;

import model.MusicStack;


public class SoundCon {

    //Attribute
    int stage;
    private double timerMelody;
    private double timerBass;
    private double timerCymbals;
    private double melodySpeed;
    private double bassSpeed;
    private double cymbalSpeed;
    private boolean melodyPlays;
    private boolean bassPlays;
    private boolean cymbalsPlay;

    //Referenzen
    private MusicStack melody = new MusicStack();
    private MusicStack bass = new MusicStack();
    private MusicStack cymbals = new MusicStack();

    //Konstruktor
    public SoundCon() {
        //Initialisierung des Stage-Counters
        stage = 0;

        //Initialisierung der Timer.
        timerMelody = 0;
        timerBass = 0;
        timerCymbals = 0;

        //Initialisierung der Abspielgeschwindigkeit der verschiedenen Stimmen.
        melodySpeed = 1;
        bassSpeed = 4;
        cymbalSpeed = 2;

        //Initialisierung der Variable, welcher der jeweiligen Stimme "sagt", ob sie gespielt werden soll.
        melodyPlays = true;
        bassPlays = false;
        cymbalsPlay = false;

        //Hinzufügen erster Samples in die Melodie: in dem Fall ein C und ein D.
        melody.addSample("melody C3");
        melody.addSample("melody D3");
        //Hinzufügen von Stille in den SampleStack für die Cymbals (Becken).
        cymbals.addSample("silence");
        cymbals.addSample("silence");
    }

    /**
     * Spielt die Samples in den Music-Stacks der jeweiligen Stimmen ab und fügt, wenn die Stage erhöht wurde, neue Samples hinzu.
     * @param dt die Zeit zwischen der letzten und dem jetzigen Aufruf der Update-Methoden.
     */
    public void update(double dt) {
        //Addiert dt auf die Timer
        timerMelody = timerMelody + dt;
        timerBass = timerBass + dt;
        timerCymbals = timerCymbals + dt;

        //Spielt die Samples, wenn die Timer größer sind als die einzelnen Zeiten der Stimmen.

        if (melodyPlays && timerMelody >= melodySpeed) {
            melody.playSample();
            timerMelody = 0;
        }

        if (bassPlays && timerBass >= bassSpeed) {
            bass.playSample();
            timerBass = 0;
        }

        if (cymbalsPlay && timerCymbals >= cymbalSpeed) {
            cymbals.playSample();
            timerCymbals = 0;
        }

        //Überprüft auf welcher Stufe die Quests sind und passt die Musik dementsprechend an: fügt Samples und Stimmen hinzu.
        switch (stage) {
            case 1:
                melody.addSample("melody D2");  //Fügt Sample "melody D2.wav" der Melodie hinzu.
                melody.addSample("melody F3");
                stage++;                                //Erhöht die Stage um 1, damit dieser Fall nur einmal aufgerufen wird.
                break;
            case 3:
                bassPlays = true;                       //Aktiviert den Bass.
                melody.addSample("melody F2");
                melody.addSample("melody G2");
                bass.addSample("bass D3");      //Fügt Sample "bass D3.wav" dem Bass hinzu.
                bass.addSample("bass G2");
                stage++;
                break;
            case 5:
                cymbalsPlay = true;                     //Aktiviert die Cymbals
                cymbals.addSample("cymbal crash");
                melody.addSample("melody A2");
                bass.addSample("bass C3");
                stage++;
                break;
            case 7:
                melody.addSample("melody G3");
                melodySpeed = 0.5;                      //Erhöht die Geschwindigkeit der Melodie.
                bass.addSample("bass F2");
                cymbals.addSample("cymbal china dark");
                cymbals.addSample("silence");
                cymbals.addSample("silence");
                stage++;
                break;
            case 9:
                bass.addSample("bass F3");
                bass.addSample("bass D2");
                cymbals.addSample("silence");
                cymbals.addSample("cymbal china warm");
                cymbals.addSample("silence");
                melody.randomize();                     //Arrangiert die Melodie zufällig neu.
                stage++;
                break;
            case 11:
                bass.addSample("bass G3");
                melody.randomize();
                stage++;
                break;
            case 13:
                melody.randomize();
                bass.addSample("bass A2");
                stage++;
                break;
            case 15:
                cymbals.randomize();                    //Arrangiert die Cymbals zufällig neu.
                bass.randomize();                       //Arrangiert den Bass zufällig neu.
                stage++;
                break;
            case 17:
                cymbals.randomize();
                bass.randomize();
                melody.randomize();
                stage++;
                break;
        }
    }

}
