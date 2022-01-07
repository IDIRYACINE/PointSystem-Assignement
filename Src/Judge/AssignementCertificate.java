package Src.Judge;

import java.util.ArrayList;

public class AssignementCertificate {
    private ArrayList<Integer> enginesId ;
    private Integer currentEngine ;

    public AssignementCertificate(ArrayList<Integer> enginesId){
        currentEngine = -1;
        this.enginesId = enginesId;
    } 

    public Integer getNextEngine() {
        if (currentEngine + 1 < enginesId.size() ){
            currentEngine++;
        }
        else {
            return -1;
        }
        return enginesId.get(currentEngine);
    }
    
    public void Reset(){
        currentEngine = 0;
    }
}
