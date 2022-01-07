package Src.Engine;

import java.util.ArrayList;
import java.util.Random;

import Src.Gymnaste.Figure;
import Src.Gymnaste.Gymnaste;
import Src.Gymnaste.Routine;
import Src.Gymnaste.Team;
import Src.Judge.Judge;
import Src.NotesSystem.GymnasteNotesRegister;

public class EngineModerationSystem {

    private ArrayList<Engine> engines;
    private Integer currentEngineIndex;
    private CompetitionMode mode;

    public EngineModerationSystem(){
        engines = new ArrayList<Engine>();

    }

    private void CheckJudgesForReAssignement(Engine engine){
        int judgeCount = engine.GetJudgeCount();
        int index = 0;
        Judge judge;

        while (index < judgeCount ){
            judge = engine.GetJudge(index);
            int nextEngine = judge.GetNextEngine();
            if ((nextEngine != -1) && (nextEngine != currentEngineIndex)){
                engine.RemoveJudge(judge);
                engines.get(nextEngine).AppendJudge(judge);
                judgeCount = engine.GetJudgeCount();
            }

            index++;
        }

    }

    private void AnounceAndEvauateGymnastes(Engine engine){
        if(mode == CompetitionMode.Solo){
            int gymnasteIndex = engine.GetGymnasteCount() - 1 ;

            while(engine.GetGymnasteCount() > 0){
                Gymnaste gymnaste = engine.GetGymnaste(gymnasteIndex);

                engine.AnounceAndEvauateGymnaste(gymnaste);
                engine.RemoveGymnaste(gymnaste);

                if(currentEngineIndex + 1 < engines.size()){
                    engines.get(currentEngineIndex + 1).AppendGymnaste(gymnaste);
                }
                gymnasteIndex = engine.GetGymnasteCount() - 1 ;
            }
        }

        else{
            int teamIndex = 0 ;
            Routine routine = randomRoutine();
            while(teamIndex < engine.GetTeamCount() ){
                Team team = engine.GetTeam(teamIndex);
                EvaluateTeamGymnaste(team,routine, engine);
                teamIndex++;
            }
        }
    }    

    private void EvaluateTeamGymnaste(Team team ,Routine routine, Engine engine){

        for (int i =0 ; i < team.GetTeamMembersCount() ; i ++){
            Gymnaste gymnaste = team.GetGymnaste(i);

            engine.AnounceAndEvaluateGymnasteRoutine(gymnaste , routine);
            engine.RemoveGymnaste(gymnaste);

            if(currentEngineIndex +  1 < engines.size()){
                engines.get(currentEngineIndex + 1).AppendGymnaste(gymnaste);
            }
        }
    }
    
    private Figure randomFigure(){
        Figure[] figures = Figure.values();
        Random random = new Random();
        int randomFigureIndex = random.nextInt(figures.length ) ;

        return figures[randomFigureIndex];
    }

    private Routine randomRoutine(){
        Figure[] figures = Figure.values();
        Random random = new Random();
        int randomFigureIndex;

        Routine routine = new Routine();

        for(int i = 0 ; i < 4 ; i++){
            randomFigureIndex = random.nextInt(figures.length ) ;
            routine.AppendFigure(figures[randomFigureIndex]);
        }

        return routine;
    }

    public void StartEngineCompetition(){

        while (currentEngineIndex < engines.size()){

            Figure figure = randomFigure();

            Engine engine = engines.get(currentEngineIndex);
            
            engine.SetFigureCompetition(figure);

            AnounceAndEvauateGymnastes(engine );

            CheckJudgesForReAssignement(engine);

            currentEngineIndex++;
        }

    }

    public void SetUpCompetition(CompetitionMode mode) {
        currentEngineIndex = 0;
        this.mode = mode;
        for (Engine engine : engines){
            engine.Reset();
        }
    }

    public void initEngines(Integer engineCount){
        Compilateur compilateur;
        GymnasteNotesRegister register = GymnasteNotesRegister.getInstance();

       for (int i = 0 ; i < engineCount ; i++){
           compilateur = new Compilateur(i, register);

           engines.add(new Engine(compilateur));
       }

    }

    public void AssigneGymnasteToEngine(int engineId, Gymnaste gymnaste) {
        engines.get(engineId).AppendGymnaste(gymnaste);
    }

    public void AssigneJudgeToEngine(Integer engineId, Judge judge) {
        engines.get(engineId).AppendJudge(judge);

    }

    public void AssigneTeamToEngine(int engineId, Team team) {
        engines.get(engineId).AppendTeam(team);
    }
    
}
