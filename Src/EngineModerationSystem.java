package Src;

import java.util.ArrayList;

public class EngineModerationSystem {
    private ArrayList<Engine> engines ;
    private Integer currentEngineIndex  ;
    public EngineModerationSystem(Integer engineCount){
        currentEngineIndex = -1;
        engines = new ArrayList<Engine>();
    }
    
    private void NextEngine(){
        currentEngineIndex++;
    }

    public void StartEngineCompetition(){
        for (int i = 0 ; i < engines.size() ; i++){
            Engine engine = engines.get(i);
            engine.StartFigureCompetition();
            
        }
    }
}
