package Src.NotesSystem;

import java.util.HashMap;
import java.util.Map;

import Src.Gymnaste.Figure;
import Src.PrizeSystem.WinnerParticipant;

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

    public void RegisterTeamNote(Integer engineId,String teamId , double note  ){
        if(engineNotesRegister.containsKey(engineId)){
            engineNotesRegister.get(engineId).registerTeamNote(teamId, note);
        }
        else{
            engineNotesRegister.put(engineId, new EngineNotesRegister());
            engineNotesRegister.get(engineId).registerTeamNote(teamId, note);
        }

    }


    public void RegisterSoloNote(String gymnasteId, Figure figure, Integer engineId, double note) {
        if(engineNotesRegister.containsKey(engineId)){
            engineNotesRegister.get(engineId).RegisterGymnasteNote(gymnasteId, figure, note);
        }
        else{
            engineNotesRegister.put(engineId, new EngineNotesRegister());
            engineNotesRegister.get(engineId).RegisterGymnasteNote(gymnasteId, figure, note);
        }
    }

    public WinnerParticipant getEngineBestTeam(int index) {
        TeamNote team = engineNotesRegister.get(index).getBestTeam();
        return new WinnerParticipant(team.getId(), team.getNote(), index);
    }

    public WinnerParticipant getEngineBestGymnaste(int index) {
        SoloNote solo = engineNotesRegister.get(index).getBestGymnaste();
        return  new WinnerParticipant(solo.getId(), solo.getNote(), index);
    }

    

}
