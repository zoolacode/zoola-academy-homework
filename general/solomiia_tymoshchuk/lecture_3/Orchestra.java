package general.solomiia_tymoshchuk.lecture_3;

import java.util.ArrayList;

public class Orchestra {

//    private final Musicians musicians;

    ArrayList<Musician> musiciansList = new ArrayList<>();


    void addMusicians(Musician musician){
        musiciansList.add(musician);
    }

    void removeMusicians(Musician musician){
        musiciansList.remove(musician);
    }

    void playMusic(){}
}
