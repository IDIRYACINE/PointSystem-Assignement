package Src.NotesSystem;

import java.util.HashMap;
import java.util.Map;

import Src.Gymnaste.Figure;

public class EngineNotesRegister {
    private Map<String , TeamNote> teamNotes;
    private Map<String , SoloNote> gymnasteNotes ;

    
    public EngineNotesRegister(){
        teamNotes = new HashMap<>();
        gymnasteNotes = new HashMap<>();
    }

    public void registerTeamNote(String teamId , double teamNote){
        if(teamNotes.containsKey(teamId)){
            teamNotes.get(teamId).addNote(teamNote);
        }
        else{
            TeamNote noteCache = new TeamNote(teamId);
            noteCache.addNote( teamNote);
            teamNotes.put(teamId, noteCache);
        }
    }


    public void RegisterGymnasteNote(String gymnasteId, Figure figure, double note) {
        if(gymnasteNotes.containsKey(gymnasteId)){
            gymnasteNotes.get(gymnasteId).addNote(figure, note);
        }
        else{
            SoloNote noteCache = new SoloNote(gymnasteId);
            noteCache.addNote(figure, note);
            gymnasteNotes.put(gymnasteId, noteCache);
        }
    }

    public TeamNote getBestTeam() {
        double bestNote = -1;
        TeamNote bestTeam = null;
        for(TeamNote teamNote : teamNotes.values()){
            if(teamNote.getNote() > bestNote){
                bestTeam = teamNote;
            }
        }

        return bestTeam;
    }

    public SoloNote getBestGymnaste() {
        double bestNote = -1;
        SoloNote bestGymnaste = null;

        
        for(SoloNote gymnasNote : gymnasteNotes.values()){
            if(gymnasNote.getNote() > bestNote){
                bestGymnaste = gymnasNote;
            }
        }
        return bestGymnaste;
    }

}
