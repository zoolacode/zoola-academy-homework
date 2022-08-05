package general.solomiia_tymoshchuk.lecture3._1;

import javax.sound.midi.Instrument;

public class MusicalInstrument {
    private String instrumentName;
    private String uniqSound;

    public MusicalInstrument(String instrumentName, String uniqSound) {
        this.instrumentName = instrumentName;
        this.uniqSound = uniqSound;

    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getSound() {
        return uniqSound;
    }

    void playUniqSound() {
        System.out.println(uniqSound);
    }
}


