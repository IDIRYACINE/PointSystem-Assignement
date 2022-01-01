package Src;

import java.util.ArrayList;

public class Routine {
    private ArrayList<Figure> figures;
    private int currentFigure = -1;

    public Routine(){
        figures = new ArrayList<Figure>();
    }

    public void AppendFigure(Figure figure){
        figures.add(figure);
    }

    public void RemoveFigure(Figure figure){
        figures.remove(figure);
    }

    public Figure GetFigure(){
        currentFigure++;
        return figures.get(currentFigure);
    }

    public Integer GetFIgureCount(){
        return figures.size();
    }

}
