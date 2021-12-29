package Src;

public class Judge
{

    private String firstName ;
    private String lastName ;
    private Integer matricule  ;
    private NumeriqueCard numeriqueCard ;
    private AssignementCertificate assignementCertificate;

    public Judge(String firstName,String lastName,Integer matricule){}

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

    public void EvaluateGymnasteFigure(Integer gymnasteId , Figure figure) {
        int note = 0;
        numeriqueCard.SetNote(note);
    }

    public Integer GetFigureEvaluation(){
        return numeriqueCard.GetNote();
    } 
    
}
