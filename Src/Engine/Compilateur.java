package Src.Engine;

import java.util.ArrayList;

import Src.Gymnaste.Figure;
import Src.Judge.Judge;
import Src.NotesSystem.GymnasteNotesRegister;

public class Compilateur {
    private GymnasteNotesRegister notesRegister;
    private Integer evaluatedGymnasteId;
    private Figure evaluatedFigure ;
    private Integer engineId;
    private ArrayList<Integer> gymnasteNotes;
  
    public Compilateur(Integer engineId , GymnasteNotesRegister register) {
        gymnasteNotes = new ArrayList<Integer>();
        this.engineId = engineId;
        notesRegister = register;
    }

    private  ArrayList<Integer>  purgeHigestAndLowestNote(){
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

    private double calculateGymnasteNote(){
        double result = 0;
        for (int i = 0 ; i < gymnasteNotes.size();i++){
            result += gymnasteNotes.get(i);
        }

        return result/gymnasteNotes.size();
    }
    
    public void SetEvaluatedGymnasteId(Integer id ){
        evaluatedGymnasteId = id;
    }

    public void CompileGymnasteNotes(){
        gymnasteNotes = purgeHigestAndLowestNote();
        double note = calculateGymnasteNote();

        notesRegister.RegisterSoloNote(evaluatedGymnasteId , evaluatedFigure ,engineId,note);
    }

    public void SetEvaluatedFigure(Figure figure) {
        evaluatedFigure = figure;
    }

    public void retrieveNoteFromJudge(Judge judge) {
        gymnasteNotes.add(judge.GetFigureEvaluation());
    }
}
