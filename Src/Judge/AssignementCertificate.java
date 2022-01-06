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
        currentEngine++;
        return enginesId.get(currentEngine);
    }
}
