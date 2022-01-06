package Src.Gymnaste;

import java.util.ArrayList;

public class Gymnaste{
    private String firstName ;   
    private String lastName ;
    private Integer age  ;
    private String adresse  ;
    private String teamName ;
    private String participationId ;
    private ArrayList<Integer> notes ;
    
    public Gymnaste(String firstName,String lastName,String id,Integer age,String addresse,String teamName) {
        this.teamName = teamName;
        this.adresse = addresse;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        participationId = id;
        notes = new ArrayList<Integer>();
    }

    public String GetFirstName(){
        return firstName;
    }
    public String GetLastName(){
        return lastName;
    }
    public Integer GetAge() {
        return age;
    }
    public String GetAddresse() {
        return adresse;
    }
    public String GetTeamName(){
        return teamName;
    }
    public String GetId(){
        return participationId;
    }

    public void setNote(Integer note){
        notes.add(note);
    }

}