package general.solomiia_tymoshchuk.lecture_3;

abstract class Musician
{
    private final MusicalInstrument musicalInstrument;
    private String name;

    public Musician(String name, MusicalInstrument musicalInstrument) {
        this.name = name;
        this.musicalInstrument = musicalInstrument;
    }

    void musicianDetails(){
        System.out.println("Name of musician" + musicianName + "Name of instrument" + musicalInstrument.getInstrumentName());
    }

    void makeInstrumentSound(){
        musicalInstrument.uniqSound();
    }
    String musicianName;

    public String getMusicianName() {
        return musicianName;
    }

    public void setMusicianName(String musicianName) {
        this.musicianName = musicianName;
    }
}

class Pianist extends Musician {

    public Pianist(String name, MusicalInstrument musicalInstrument) {
        super(name, musicalInstrument);
    }



}
