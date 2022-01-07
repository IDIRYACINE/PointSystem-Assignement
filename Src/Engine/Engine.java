package Src.Engine;

import java.util.ArrayList;

import Src.Gymnaste.Figure;
import Src.Gymnaste.Gymnaste;
import Src.Gymnaste.Routine;
import Src.Gymnaste.Team;
import Src.Judge.Judge;

public class Engine {

    private ArrayList<Gymnaste>  gymnastes ;
    private ArrayList<Judge>  judges ;
    private ArrayList<Team>  teams;
    private Compilateur compilateur ;
    private Figure figure;

    public Engine(Compilateur compilateur ){
        this.compilateur = compilateur;
        gymnastes = new ArrayList<>();
        judges = new ArrayList<>();
        teams = new ArrayList<>();
    }

    public void AnounceAndEvauateGymnaste(Gymnaste gymnaste ){
        compilateur.SetEvaluatedGymnasteId(gymnaste.GetId());
        compilateur.SetEvaluatedFigure(figure);
        Judge judge;

        for (int i = 0 ; i < judges.size() ;i++){
            judge = judges.get(i);
            judge.SetEvaluatedGymnasteId(gymnaste.GetId());
            judge.EvaluateGymnasteFigure(figure);
            compilateur.RetrieveNoteFromJudge(judge);
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
        if (!judges.contains(judge)){
            judges.add(judge);
        }
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

    public void SetFigureCompetition(Figure figure) {
        this.figure = figure;
    }

    public void AnounceAndEvaluateGymnasteRoutine(Gymnaste gymnaste, Routine routine) {
        compilateur.SetEvaluatedGymnasteId(gymnaste.GetId());

        Judge judge;
        for (int j = 0 ; j< routine.GetFigureCount();j++){
            for (int i = 0 ; i < judges.size() ;i++){
                judge = judges.get(i);
                judge.SetEvaluatedGymnasteId(gymnaste.GetId());
                judge.EvaluateGymnasteFigure(routine.GetFigure(j));

                compilateur.RetrieveNoteFromJudge(judge);
            }    
        }
        
        compilateur.CompileGymnasteRoutineNotes(gymnaste.GetTeamName());
    }

    public void Reset() {
        for (Judge judge : judges){
            judge.Reset();
        }
        judges.clear();
        gymnastes.clear();
    }

    public void AppendTeam(Team team) {
        if (!teams.contains(team)){   
            teams.add(team);
        }
    }

    public void RemoveTeam(Team team){
        teams.remove(team);
    }

    
}
