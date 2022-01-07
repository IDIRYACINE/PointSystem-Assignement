package Src.NotesSystem;

import java.util.Collection;
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
        Collection<TeamNote> notes = teamNotes.values();
        double bestNote = -1;
        TeamNote bestTeam = notes.iterator().next();
        for(TeamNote teamNote : notes){
            if(teamNote.getNote() > bestNote){
                bestTeam = teamNote;
            }
        }

        return bestTeam;
    }

    public SoloNote getBestGymnaste() {
        Collection<SoloNote> notes = gymnasteNotes.values();
        double bestNote = -1;
        SoloNote bestGymnaste = notes.iterator().next();

        for(SoloNote gymnasNote : notes){
            if(gymnasNote.getNote() > bestNote){
                bestGymnaste = gymnasNote;
            }
        }

        return bestGymnaste;
    }

}
