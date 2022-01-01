package Src;

public class RegistrationAgent {
    private RegistrationSystem registrationSystem;
    private static int currentGymnasteId = 0;

    public RegistrationAgent(  ){
        registrationSystem = new RegistrationSystem();
    }

    public void RegisterGymnaste(String firstName , String lastName ,Integer age,String addresse,String teamName){
        Gymnaste gymnaste = new Gymnaste(firstName, lastName, currentGymnasteId, age, addresse, teamName);
        registrationSystem.RegisterGymnaste(gymnaste);
        currentGymnasteId++;
    }

    public void RegisterJudge(String firstName ,String lastName  ,Integer matricule){
        Judge judge = new Judge(firstName, lastName, matricule);
        registrationSystem.RegisterJudge(judge);
    }

}
