package Src.Judge;

import Src.Gymnaste.Figure;
import java.util.Random;

public class Judge
{

    private String firstName ;
    private String lastName ;
    private Integer matricule  ;
    private NumeriqueCard numeriqueCard ;
    private AssignementCertificate assignementCertificate;
    private String evaluatedGymnasteId;

    public Judge(String firstName,String lastName,Integer matricule){
        this.numeriqueCard = new NumeriqueCard();
        this.firstName = firstName;
        this.lastName = lastName;
        this.matricule = matricule;

    }

    public String GetFirstName(){
        return firstName;
    }

    public String GetLastName() {
        return lastName;
    }

    public Integer GetMatricule() {
        return matricule;
    } 

    public Integer GetNextEngine() {
        return assignementCertificate.getNextEngine();
    }

    public void SetEvaluatedGymnasteId(String id ){
        evaluatedGymnasteId = id;
    }

    public void EvaluateGymnasteFigure(Figure figure) {
        Random random = new Random();
        int note = random.nextInt(10-1 + 1) + 1;
        numeriqueCard.SetNote(note);
    }

    public Integer GetFigureEvaluation(){
        return numeriqueCard.GetNote();
    } 

    public void SetAssignementCertificate(AssignementCertificate certificate){
        this.assignementCertificate = certificate;
    }

    public void Reset(){
        assignementCertificate.Reset();
    }
    
}
