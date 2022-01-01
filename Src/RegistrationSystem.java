package Src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegistrationSystem {
    private ArrayList<Gymnaste> gymnastes ;
    private ArrayList<Judge> judges ;
    private Map<String , Team> teams ;

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

    public void RegisterJudge(Judge judge) {
        judges.add(judge);
    }
    
}
