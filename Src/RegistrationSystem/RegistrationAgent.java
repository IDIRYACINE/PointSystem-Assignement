package Src.RegistrationSystem;

import Src.Engine.CompetitionMode;
import Src.Engine.EngineModerationSystem;
import Src.Gymnaste.Gymnaste;
import Src.Judge.Judge;

public class RegistrationAgent {
    private RegistrationSystem registrationSystem;
    private Integer gymnasteCount = -1;
    

    public RegistrationAgent(){
        registrationSystem = new RegistrationSystem();
    }

    public void RegisterGymnaste(String firstName , String lastName ,Integer age,String addresse,String teamName){
        gymnasteCount++;
        String currentGymnasteId = "gymnaste" + gymnasteCount;

        Gymnaste gymnaste = new Gymnaste(firstName, lastName, currentGymnasteId, age, addresse, teamName);
        registrationSystem.RegisterGymnaste(gymnaste);
    }

    public void RegisterJudge(String firstName ,String lastName  ,Integer matricule){
        Judge judge = new Judge(firstName, lastName, matricule);
        registrationSystem.RegisterJudge(judge);
    }

    public void RegisterEngines(Integer enginesCount){
        registrationSystem.RegisterEngines(enginesCount);
    }

    public void AssigneParticipants(CompetitionMode mode, EngineModerationSystem engineModerationSystem) {
        /*
        Assigne Participants to their engine depending on the competitionMode 
        Solo : randomly assign gymnaste to engines
        Team : assign team members to the same engine
        */
        registrationSystem.AssigneParticipantsToEngines(mode, engineModerationSystem);
    }

}
