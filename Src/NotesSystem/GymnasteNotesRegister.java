package Src.NotesSystem;

import java.util.HashMap;
import java.util.Map;

import Src.Engine.CompetitionMode;
import Src.Gymnaste.Figure;

public class GymnasteNotesRegister {
    private static GymnasteNotesRegister instance ;

    private Map<Integer , EngineNotesRegister> engineNotesRegister ;

    public static GymnasteNotesRegister getInstance() {
        if (instance != null){
            return instance;
        }   
        else{
            instance = new GymnasteNotesRegister();
            return instance;
        }
    }

    private GymnasteNotesRegister(){
        engineNotesRegister = new HashMap<Integer ,EngineNotesRegister>();
    }

    public void RegisterTeamNote(Integer engineId,Integer teamId , double note  ){
        if(engineNotesRegister.containsKey(engineId)){
            engineNotesRegister.get(engineId).registerTeamNote(teamId, note);
        }
        else{
            engineNotesRegister.put(engineId, new EngineNotesRegister());
            engineNotesRegister.get(engineId).registerTeamNote(teamId, note);
        }

    }


    public void RegisterSoloNote(Integer gymnasteId, Figure figure, Integer engineId, double note) {
        if(engineNotesRegister.containsKey(engineId)){
            engineNotesRegister.get(engineId).RegisterGymnasteNote(gymnasteId, figure, note);
        }
        else{
            engineNotesRegister.put(engineId, new EngineNotesRegister());
            engineNotesRegister.get(engineId).RegisterGymnasteNote(gymnasteId, figure, note);
        }
    }


    public void SetEngine(String engineId ){}

    public void SetCompetitionMode(CompetitionMode mode ){

    }


}
