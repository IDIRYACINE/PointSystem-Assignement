package Src.Engine;

import java.util.ArrayList;

import Src.Gymnaste.Figure;
import Src.Judge.Judge;
import Src.NotesSystem.GymnasteNotesRegister;

public class Compilateur {
    /* 
        engineId : the id of engine this compilateur is assigned to
        gymnasteNotes : the list of notes the judges has give the gymnaste
        example 6 judges: 
        after each judge anounce the note , the compilateur would retrieve it
        and cache it on gymnasteNotes before calculating the final note
    */

    private GymnasteNotesRegister notesRegister;
    private String evaluatedGymnasteId;
    private Figure evaluatedFigure ;
    private Integer engineId;
    private ArrayList<Integer> gymnasteNotes;
  
    public Compilateur(Integer engineId , GymnasteNotesRegister register) {
        gymnasteNotes = new ArrayList<Integer>();
        this.engineId = engineId;
        notesRegister = register;
    }

    private  ArrayList<Integer>  RemoveHigestAndLowestNote(){
        int highestNoteIndex = 0;
        int lowestNoteIndex = 0;

        for (int i = 1 ; i < gymnasteNotes.size() ; i++){
            if (gymnasteNotes.get(i) > gymnasteNotes.get(highestNoteIndex)){
                highestNoteIndex = i;
            }
            if (gymnasteNotes.get(i) < gymnasteNotes.get(lowestNoteIndex)){
                lowestNoteIndex = i;
            }
        }

        ArrayList<Integer> notes = new ArrayList<Integer>();
        for (int i = 1 ; i < gymnasteNotes.size() ; i++){
            if (!(i == highestNoteIndex || i==lowestNoteIndex) ){
                notes.add(gymnasteNotes.get(i));
            }
        } 
        return notes;
    }

    private double CalculateGymnasteNote(){
        double result = 0;
        for (int i = 0 ; i < gymnasteNotes.size();i++){
            result += gymnasteNotes.get(i);

        }
        return result/gymnasteNotes.size();
    }
    
    public void SetEvaluatedGymnasteId(String id ){
        evaluatedGymnasteId = id;
    }

    public void SetEvaluatedFigure(Figure figure) {
        evaluatedFigure = figure;
    }

    public void RetrieveNoteFromJudge(Judge judge) {
        gymnasteNotes.add(judge.GetFigureEvaluation());
    }
    /*
        Both compile methods are used to regsiter the gymnaste notes in the system
        RoutniesNotes is used on TeamCompetitions
        Notes is used SoloCompetitions 
    */

    public void CompileGymnasteRoutineNotes(String teamId) {
        gymnasteNotes = RemoveHigestAndLowestNote();
        double note = CalculateGymnasteNote();
        notesRegister.RegisterTeamNote(engineId,teamId,note);
    }

    public void CompileGymnasteNotes(){
        gymnasteNotes = RemoveHigestAndLowestNote();
        double note = CalculateGymnasteNote();
        notesRegister.RegisterSoloNote(evaluatedGymnasteId , evaluatedFigure ,engineId,note);
    }

}
