package Src.Engine;

import java.util.ArrayList;
import Src.Figure;
import Src.Judge;

public class EngineModerationSystem {
    private ArrayList<Engine> engines ;
    private Integer currentEngineIndex  ;
    private CompetitionMode mode;

    public EngineModerationSystem(Integer engineCount){
        currentEngineIndex = -1;
        engines = new ArrayList<Engine>();
    }
    
    private void CheckJudgesForReAssignement(Engine engine){
        int judgeCount = engine.GetJudgeCount();
        Judge judge;
        while (judgeCount > 0 ){
            judge = engine.GetJudge(judgeCount - 1);
            
            int nextEngine = judge.GetNextEngine();
            if (nextEngine != -1){
                engine.RemoveJudge(judge);
                engines.get(nextEngine).AppendJudge(judge);
            }
        }
    }

    private Figure randomFigure(){
        return Figure.Anneaux;
    }

    public void StartEngineCompetition(){
        Figure figure = randomFigure();
        for (int i = 0 ; i < engines.size() ; i++){
            Engine engine = engines.get(i);
            engine.StartFigureCompetition(figure);
            CheckJudgesForReAssignement(engine);
        }

    }

    public void setCompetitionMode(CompetitionMode mode) {
        this.mode = mode;
    }
    
}
