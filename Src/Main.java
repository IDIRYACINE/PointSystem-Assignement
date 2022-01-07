package Src;

public class Main {
    public static void  main(String args[]){
        PointGym pointGym = new PointGym();
        // JudgesCOunt , GymnastesCount , EnginesCOunt
        // Teams are randomly generated and registred
        pointGym.SetUpSystem(12, 20, 3);
        pointGym.StartFirstDayCompetition();
        pointGym.StartSecondDayCompetition();
        /* CompetitionResult Cant be anounced seperatly must anounce both after the secondDay ends
            The exercise didn't specify this point ,as it was ambigous on a few more things
        */
        pointGym.AnnounceCompetitionResults();
    }
}