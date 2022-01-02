package Src;

import Src.Engine.CompetitionMode;
import Src.Engine.EngineModerationSystem;
import Src.NotesSystem.GymnasteNotesRegister;

public class PointGym {
    
    private GymnasteNotesRegister gymnasteNotesRegister ;
    private RegistrationAgent registrationAgent ;
    private EngineModerationSystem engineModerationSystem;  

    public PointGym() {
        gymnasteNotesRegister = new GymnasteNotesRegister();
        registrationAgent = new RegistrationAgent();
        engineModerationSystem = new EngineModerationSystem(3);
    }
    
    public void RegisterGymnaste(String firstName ,String lastName  ,Integer age,String addresse,String teamName) {
        registrationAgent.RegisterGymnaste(firstName, lastName, age, addresse, teamName);
    }

    public void RegisterJudge(String firstName , String lastName  ,Integer matricule) {
        registrationAgent.RegisterJudge(firstName, lastName, matricule);
    }

    public void StartFirstDayCompetition() {
        engineModerationSystem.setCompetitionMode(CompetitionMode.Solo);
        engineModerationSystem.StartEngineCompetition();
    }

    public void StartSecondDayCompetition() {
        engineModerationSystem.setCompetitionMode(CompetitionMode.Team);
        engineModerationSystem.StartEngineCompetition();
    }
}
