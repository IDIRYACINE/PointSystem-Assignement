package Src.Engine;

import java.util.ArrayList;

import Src.Compilateur;
import Src.Figure;
import Src.Gymnaste;
import Src.Judge;
import Src.Team;

public class Engine {
    private  ArrayList<Gymnaste>  gymnastes ;
    private ArrayList<Judge>  judges ;
    private ArrayList<Team>  teams;
    private Compilateur compilateur ;

    public Engine(Compilateur compilateur ){
        this.compilateur = compilateur;
    }

    private void AnounceAndEvauateGymnaste(Gymnaste gymnaste , Figure figure){

        compilateur.SetEvaluatedGymnasteId(gymnaste.GetId());
        compilateur.SetEvaluatedFigure(figure);
        Judge judge;

        for (int i=0 ; i > judges.size() ;i++){
            judge = judges.get(i);
            judge.SetEvaluatedGymnasteId(gymnaste.GetId());
            judge.EvaluateGymnasteFigure(figure);
            compilateur.retrieveNoteFromJudge(judge);
        }
        compilateur.CompileGymnasteNotes();
    }

    public void AppendGymnaste(Gymnaste gymnaste ){
        gymnastes.add(gymnaste);
    }

    public void RemoveGymnaste( Gymnaste gymnaste ){
        gymnastes.remove(gymnaste);
    }

    public void AppendJudge(Judge judge){
        judges.add(judge);
    }

    public void RemoveJudge(Judge judge ){
        judges.remove(judge);
    }

    public Team GetTeam(Integer index ){
        return teams.get(index);
    }

    public Gymnaste GetGymnaste(Integer index ){
        return gymnastes.get(index);
    }

    public Judge GetJudge(Integer index ){
        return judges.get(index);
    }

    public Integer GetJudgeCount(){
        return judges.size();
    }

    public Integer GetTeamCount(){
        return teams.size();
    }

    public Integer GetGymnasteCount(){
        return gymnastes.size();
    }

    public void StartFigureCompetition(Figure figure){
        for (int i = 0 ; i < gymnastes.size() ; i++){
            AnounceAndEvauateGymnaste(gymnastes.get(i), figure);
        }
    }

    
}
