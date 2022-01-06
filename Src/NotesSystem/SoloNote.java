package Src.NotesSystem;

import java.util.HashMap;
import java.util.Map;

import Src.Gymnaste.Figure;

public class SoloNote {
    private Map<Figure , Double> notes;
    private String gymnasteId;

    public SoloNote(String id){
        notes = new HashMap<>();
        gymnasteId = id;
    }

    public void addNote(Figure figure , Double note){
        notes.putIfAbsent(figure, note);
    }

    public Integer getNotesCount(){
        return notes.size();
    }

    public double getNote() {
        double result = 0;

        for (int i =0 ; i < notes.size() ; i++){
            result += notes.get(i);
        }
        return result / notes.size();
    }

    public String getId(){
        return gymnasteId;
    }

    

}
