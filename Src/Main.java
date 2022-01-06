package Src;

public class Main {
    public static void  main(String args[]){
        PointGym pointGym = new PointGym();
        pointGym.SetUpSystem(12, 20, 3);
        pointGym.StartFirstDayCompetition();
        pointGym.StartSecondDayCompetition();
    }
}