package Src.PrizeSystem;

import java.util.ArrayList;

import Src.NotesSystem.GymnasteNotesRegister;

public class PrizeSystem {
    private GymnasteNotesRegister notesRegister;
    private Integer enginesCount;
    private ArrayList<WinnerParticipant> bestTeams;
    private ArrayList<WinnerParticipant> bestGymnastes;

    public PrizeSystem(GymnasteNotesRegister register , Integer enginesCount){
        notesRegister =register;
        this.enginesCount = enginesCount;
        bestGymnastes = new ArrayList<>();
        bestTeams = new ArrayList<>();
    }

    public void AnounceSoloCompetitionWinners(){
        System.out.println("Winner Gymnastes By Engine");
        System.out.println("-----------------------");
        
        for ( WinnerParticipant winner : bestGymnastes){
            System.out.println("EngineId : " + winner.getEngineId());
            System.out.println("GymnasteId : " + winner.getId());
            System.out.println("Note : " + winner.getNote());
            System.out.println("-----------------------");
        }
    }

    public void AnounceTeamCompetitionWinners(){
        System.out.println("Winner Teams By Engine");
        System.out.println("-----------------------");
        for ( WinnerParticipant winner : bestTeams){
            System.out.println("EngineId : " + winner.getEngineId());
            System.out.println("TeamId : " + winner.getId());
            System.out.println("Note : " + winner.getNote());
            System.out.println("-----------------------");

        }
    }

    public void CompileWinnersList(){
        bestGymnastes.clear();
        bestTeams.clear();
        for(int i = 0 ; i < enginesCount ;i++){
            bestGymnastes.add(notesRegister.getEngineBestGymnaste(i));
            bestTeams.add(notesRegister.getEngineBestTeam(i));
        }
    }
    
}
