package Src;

import java.util.ArrayList;

public class Engine {
    private  ArrayList<Gymnaste>  gymnastes ;
    private ArrayList<Judge>  judges ;
    private ArrayList<Team>  teams;
    private  Compilateur compilateur ;

    public Engine(Compilateur compilateur ){}

    private void AnounceGymnasteId(){}

    public void AppendGymnaste(Gymnaste gymnaste ){}

    public void RemoveGymnaste( Gymnaste gymnaste ){}

    public void AppendJudge(Judge judge){}

    public void RemoveJudge(Judge judge ){}

    public Team GetTeam(Integer index ){}

    public Gymnaste GetGymnaste(Integer index ){}

    public Judge GetJudge(Integer index ){}

    public Integer GetJudgeCount(){}

    public Integer GetTeamCount(){}

    public Integer GetGymnasteCount(){}

    public void StartFigureCompetition(){}
}
