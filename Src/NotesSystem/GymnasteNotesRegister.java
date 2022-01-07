package Src.NotesSystem;

import java.util.HashMap;
import java.util.Map;

import Src.Gymnaste.Figure;
import Src.PrizeSystem.WinnerParticipant;

public class GymnasteNotesRegister {
    /*
        a map was used so that each engine would get a correspending registre
    */

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
        /*
            This will register the routine note of each gymnaste in the team,
            further calculations are done before retriving it
        */

        if(engineNotesRegister.containsKey(engineId)){
            engineNotesRegister.get(engineId).registerTeamNote(teamId, note);
        }
        else{
            engineNotesRegister.put(engineId, new EngineNotesRegister());
            engineNotesRegister.get(engineId).registerTeamNote(teamId, note);
        }

    }


    public void RegisterSoloNote(String gymnasteId, Figure figure, Integer engineId, double note) {
        /*
            Solo refers to the individual gymnaste nots on the first day (Solo Competition)
        */
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
