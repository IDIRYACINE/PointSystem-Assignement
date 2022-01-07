package Src.NotesSystem;


import Src.Gymnaste.Figure;

public class SoloNote {
    private double note;
    private String gymnasteId;
    private Figure figure;

    public SoloNote(String id){
        gymnasteId = id;
    }

    public void addNote(Figure figure , Double note){
        this.note = note;
        this.figure = figure;
    }

    public double getNote() {        
        return note;
    }

    public String getId(){
        return gymnasteId;
    }

    public Figure getFigure(){
        return figure;
    }

}
