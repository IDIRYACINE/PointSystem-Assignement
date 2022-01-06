package Src.NotesSystem;

import java.util.HashMap;
import java.util.Map;

import Src.Gymnaste.Figure;

public class EngineNotesRegister {
    private Map<Integer , TeamNote> teamNotes;
    private Map<Integer , SoloNote> gymnasteNotes ;

    
    public EngineNotesRegister(){
        teamNotes = new HashMap<>();
    }

    public void registerTeamNote(Integer teamId , double teamNote){
        if(teamNotes.containsKey(teamId)){
            teamNotes.get(teamId).addNote(teamNote);
        }
        else{
            TeamNote noteCache = new TeamNote();
            noteCache.addNote( teamNote);
            teamNotes.put(teamId, noteCache);
        }
    }


    public void RegisterGymnasteNote(Integer gymnasteId, Figure figure, double note) {
        if(gymnasteNotes.containsKey(gymnasteId)){
            gymnasteNotes.get(gymnasteId).addNote(figure, note);
        }
        else{
            SoloNote noteCache = new SoloNote();
            noteCache.addNote(figure, note);
            gymnasteNotes.put(gymnasteId, noteCache);
        }
    }

}
