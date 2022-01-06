package Src;

import Src.Engine.CompetitionMode;
import Src.Engine.EngineModerationSystem;
import Src.RegistrationSystem.RegistrationAgent;

public class PointGym {
    
    private RegistrationAgent registrationAgent ;
    private EngineModerationSystem engineModerationSystem;  

    public PointGym() {
        registrationAgent = new RegistrationAgent();
        engineModerationSystem = new EngineModerationSystem();
    }
    
    private void RegisterGymnaste(String firstName ,String lastName  ,Integer age,String addresse,String teamName) {
        registrationAgent.RegisterGymnaste(firstName, lastName, age, addresse, teamName);
    }

    private void RegisterJudge(String firstName , String lastName  ,Integer matricule) {
        registrationAgent.RegisterJudge(firstName, lastName, matricule);
    }

    private String[] generateTeams(Integer gymnastesCount){
        int teamCount = gymnastesCount/4;

        String[] Teams = new String[teamCount];
        String team = "team";
        
        for (int i = 0 ; i < teamCount ; i++){
            Teams[i] = team+i;
        }

        return Teams;
    }

    public void SetUpSystem(Integer judgesCount , Integer gymnastesCount , Integer enginesCount){

        engineModerationSystem.initEngines(enginesCount);

        registrationAgent.RegisterEngines(enginesCount);


        String[] Teams = generateTeams(gymnastesCount);

        String judgeN = "judge";

        for (int i = 0 ; i < judgesCount ; i++){
            RegisterJudge(judgeN+i, judgeN+i+"b", i*100);
        }

        String gymnasteN = "gymnaste";

        for (int i = 0 ; i < gymnastesCount ; i++){

            RegisterGymnaste(gymnasteN+i, gymnasteN+i+"b", 18, "bba", Teams[i/4]);
        }
        
    }

    public void StartFirstDayCompetition() {
        engineModerationSystem.SetUpCompetition(CompetitionMode.Solo);
        engineModerationSystem.StartEngineCompetition();
    }

    public void StartSecondDayCompetition() {
        engineModerationSystem.SetUpCompetition(CompetitionMode.Team);
        engineModerationSystem.StartEngineCompetition();
    }
    
}
