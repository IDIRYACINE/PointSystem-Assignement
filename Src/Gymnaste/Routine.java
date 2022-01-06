package Src.Gymnaste;

import java.util.ArrayList;

public class Routine {
    private ArrayList<Figure> figures;

    public Routine(){
        figures = new ArrayList<Figure>();
    }

    public void AppendFigure(Figure figure){
        figures.add(figure);
    }

    public void RemoveFigure(Figure figure){
        figures.remove(figure);
    }

    public Figure GetFigure(Integer index){
        return figures.get(index);
    }

    public Integer GetFigureCount(){
        return figures.size();
    }

}
