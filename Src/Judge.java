package Src;

public class Judge
{

    private String firstName ;
    private String lastName ;
    private Integer matricule  ;
    private NumeriqueCard numeriqueCard ;
    private AssignementCertificate assignementCertificate;
    private Integer evaluatedGymnasteId;

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

    public void SetEvaluatedGymnasteId(Integer id ){
        evaluatedGymnasteId = id;
    }

    public void EvaluateGymnasteFigure(Figure figure) {
        int note = 0;
        numeriqueCard.SetNote(note);
    }

    public Integer GetFigureEvaluation(){
        return numeriqueCard.GetNote();
    } 

    public void SetAssignementCertificate(AssignementCertificate certificate){
        this.assignementCertificate = certificate;
    }
    
}
