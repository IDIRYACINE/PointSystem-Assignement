package Src.RegistrationSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


import Src.Engine.CompetitionMode;
import Src.Engine.EngineModerationSystem;
import Src.Gymnaste.Gymnaste;
import Src.Gymnaste.Team;
import Src.Judge.AssignementCertificate;
import Src.Judge.Judge;

public class RegistrationSystem {
    private ArrayList<Gymnaste> gymnastes ;
    private ArrayList<Judge> judges ;
    private Map<String,Team> teams ;
    private ArrayList<Integer> availlableEngines ;

    public RegistrationSystem() {
        gymnastes = new ArrayList<Gymnaste>();
        judges = new ArrayList<Judge>();
        teams = new HashMap<String , Team>();
    }

    public void RegisterGymnaste(Gymnaste gymnaste) {
        gymnastes.add(gymnaste);
        String teamName = gymnaste.GetTeamName();

        if(teams.containsKey(teamName)){
            teams.get(teamName).AppendGymnaste(gymnaste);
        }
        else{
            Team team = new Team();
            team.AppendGymnaste(gymnaste);
            teams.put(teamName, team);
        }
    }

    public void RegisterJudge(Judge judge ) {
        ArrayList<Integer> enginesId = (ArrayList<Integer>) availlableEngines.clone();
        Collections.shuffle(enginesId);

        AssignementCertificate certificate = new AssignementCertificate(enginesId);
        judge.SetAssignementCertificate(certificate);
        judges.add(judge);
        
    }

    public void AssigneParticipants(CompetitionMode mode , EngineModerationSystem moderationSystem){
       
        if (mode == CompetitionMode.Solo){
            AssigneRandomly(moderationSystem);
        }
        else{
            AssigneTeams(moderationSystem);
        }

    }

    private void AssigneTeams(EngineModerationSystem moderationSystem){
        Random random = new Random();
        int engineId ;
        int enginesCount = availlableEngines.size();
        Team teamTemp;

        for (Map.Entry<String, Team> team : teams.entrySet()) {
            engineId = random.nextInt(enginesCount + 1 ) + 1;
            
            teamTemp = team.getValue();

            for (int i = 0 ; i < teamTemp.GetTeamMembersCount() ; i++){
                
                moderationSystem.AssigneGymnasteToEngine(engineId, teamTemp.GetGymnaste(i));
            }

        }
    }

    private void AssigneRandomly(EngineModerationSystem moderationSystem){
        Random random = new Random();
        int engineId ;
        int enginesCount = availlableEngines.size();
        for (Gymnaste gymnaste : gymnastes) {
            engineId = random.nextInt(enginesCount + 1 ) + 1;
            moderationSystem.AssigneGymnasteToEngine(engineId , gymnaste);
        }

    }

    public void RegisterEngines(Integer enginesCount){
        availlableEngines = new ArrayList<>();

        for (int i = 0 ; i < enginesCount ;i++){
            availlableEngines.add(i) ;
        }
    }
    
}
