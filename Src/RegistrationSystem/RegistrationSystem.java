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
    /*
        enginesIds is basically the numbers 0-NumberOfEngines
        to avoid any complexity of generating and managing UID
    */

    private ArrayList<Gymnaste> gymnastes ;
    private ArrayList<Judge> judges ;
    private Map<String,Team> teams ;
    private ArrayList<Integer> enginesIds ;

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
        /*
            a copy of enginesIds is created then shuffled to try and simulate a realLife-like experience
            concering the judges assignement
        */

        ArrayList<Integer> enginesId = (ArrayList<Integer>) enginesIds.clone();
        Collections.shuffle(enginesId);
        AssignementCertificate certificate = new AssignementCertificate(enginesId);
        judge.SetAssignementCertificate(certificate);
        judges.add(judge);
    }

    public void AssigneParticipantsToEngines(CompetitionMode mode , EngineModerationSystem moderationSystem){  
        if (mode == CompetitionMode.Solo){
            AssigneGymnastesRandomlyToEngine(moderationSystem);
        }
        else{
            AssigneTeamsToEngine(moderationSystem);
        }
        AssigneJudges(moderationSystem);
    }

    private void AssigneJudges(EngineModerationSystem moderationSystem) {
        for (Judge judge : judges) {
            moderationSystem.AssigneJudgeToEngine(judge.GetNextEngine(),judge);
        }
    }

    private void AssigneTeamsToEngine(EngineModerationSystem moderationSystem){
        Random random = new Random();
        int engineId ;
        int enginesCount = enginesIds.size();
        Team teamTemp;

        for (Map.Entry<String, Team> team : teams.entrySet()) {
            engineId = random.nextInt(enginesCount) ;
            teamTemp = team.getValue();
                moderationSystem.AssigneTeamToEngine(engineId , teamTemp);
            for (int i = 0 ; i < teamTemp.GetTeamMembersCount() ; i++){
                moderationSystem.AssigneGymnasteToEngine(engineId, teamTemp.GetGymnaste(i));
            }
        }

    }

    private void AssigneGymnastesRandomlyToEngine(EngineModerationSystem moderationSystem){
        Random random = new Random();
        int engineId ;
        int enginesCount = enginesIds.size();
        for (Gymnaste gymnaste : gymnastes) {
            engineId = random.nextInt(enginesCount ) ;
            moderationSystem.AssigneGymnasteToEngine(engineId , gymnaste);
        }

    }

    public void RegisterEngines(Integer enginesCount){
        enginesIds = new ArrayList<>();
        for (int i = 0 ; i < enginesCount ;i++){
            enginesIds.add(i) ;
        }
    }
    
}
