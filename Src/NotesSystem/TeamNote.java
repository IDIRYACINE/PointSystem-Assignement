package Src.NotesSystem;

import java.util.ArrayList;


public class TeamNote {
    private ArrayList<Double> notes;
    private String teamId;

    public TeamNote(String id){
        notes = new ArrayList<>();
        teamId = id;
    }

    public void addNote(Double note){
        notes.add(note);
    }

    public Integer getNotesCount(){
        return notes.size();
    }

    public double getNote(){
        double result = 0;

        for (int i =0 ; i < notes.size() ; i++){
            result += notes.get(i);
        }

        return result / notes.size();
    }

    public String getId(){
        return teamId;
    }
    
}
