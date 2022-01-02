package Src.NotesSystem;

import java.util.HashMap;
import java.util.Map;

import Src.Figure;

public class SoloNote {
    private Map<Figure , Double> notes;

    public SoloNote(){
        notes = new HashMap<>();
    }

    public void addNote(Figure figure , Double note){
        notes.putIfAbsent(figure, note);
    }

    public Integer getNotesCount(){
        return notes.size();
    }

    

}
