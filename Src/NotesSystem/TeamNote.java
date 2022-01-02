package Src.NotesSystem;

import java.util.ArrayList;


public class TeamNote {
    private ArrayList<Double> notes;

    public TeamNote(){
        notes = new ArrayList<>();
    }

    public void addNote(Double note){
        notes.add(note);
    }

    public Integer getNotesCount(){
        return notes.size();
    }
    
}
