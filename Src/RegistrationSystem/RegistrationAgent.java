package Src.RegistrationSystem;

import Src.Engine.CompetitionMode;
import Src.Engine.EngineModerationSystem;
import Src.Gymnaste.Gymnaste;
import Src.Judge.Judge;

public class RegistrationAgent {
    private RegistrationSystem registrationSystem;
    private static String currentGymnasteId = "";
    private Integer gymnasteCount = -1;
    

    public RegistrationAgent(){
        registrationSystem = new RegistrationSystem();
    }

    public void RegisterGymnaste(String firstName , String lastName ,Integer age,String addresse,String teamName){
        gymnasteCount++;
        currentGymnasteId = "gymnaste" + currentGymnasteId;

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
        registrationSystem.AssigneParticipants(mode, engineModerationSystem);
    }

}
