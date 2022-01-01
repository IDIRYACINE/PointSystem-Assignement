package Src;

import java.util.ArrayList;

public class Team {
    private ArrayList<Gymnaste> gymnastes ;
    private Routine routine ; 
    public Team(){}

    public void AppendGymnaste(Gymnaste gymnaste){
        gymnastes.add(gymnaste);
    }

    public Gymnaste GetGymnaste(Integer index){
        return gymnastes.get(index);
    }

    public Integer GetTeamMembersCount(){
        return gymnastes.size();
    }

    public void SetRoutine(Routine routine){
        this.routine = routine;
    }
    
}
