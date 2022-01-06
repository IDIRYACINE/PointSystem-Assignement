package Src.PrizeSystem;

import Src.NotesSystem.GymnasteNotesRegister;

public class PrizeSystem {
    private GymnasteNotesRegister notesRegister;
    private Integer enginesCount;

    public PrizeSystem(GymnasteNotesRegister register , Integer enginesCount){
        notesRegister =register;
        this.enginesCount = enginesCount;
    }

    public void AnounceSoloCompetitionWinners(){
    
    }

    public void AnounceTeamCompetitionWinners(){
        
    }

    public void CompileWinnersList(){
        for(int i = 0 ; i < enginesCount ;i++){
            notesRegister.getEngineFigureNotes(i);
            notesRegister.getEngineTeamNotes(i);
            
        }
    }
}
