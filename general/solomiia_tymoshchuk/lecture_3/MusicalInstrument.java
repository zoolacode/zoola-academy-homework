package general.solomiia_tymoshchuk.lecture_3;

abstract class MusicalInstrument {
    String instrumentName;

    public MusicalInstrument(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    abstract void uniqSound();
}
class Piano extends MusicalInstrument{

    String pianoSound = "pianoSound";

    public Piano(String instrumentName) {
        super(instrumentName);
    }

    @Override
    void uniqSound(){
        System.out.println(pianoSound);
    }

}

