package Src.PrizeSystem;

public class WinnerParticipant {
    private String id;
    private double note;
    private Integer engineId ;

    public WinnerParticipant(String id , double note , Integer engineId){
        this.id = id;
        this.note = note;
        this.engineId = engineId;

    }

    public String getId(){
        return id;
    }

    public double getNote(){
        return note;
    }

    public Integer getEngineId(){
        return engineId;
    }

}
