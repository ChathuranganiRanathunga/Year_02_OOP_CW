package com.company;

public class footBall_club extends sports_club {

    /*initialise private instance variables to how many wins,
       how many draws and defeats */
    private int f_wins;
    private int f_draws;
    private int f_defeat;


    /*Initialise private instance variables to how may goals scored,
    how many goals received */
    private int f_gScored;
    private int f_gReceived;


    /*Initialise private instance variables to how many points
    have in related clubs and number of Matches each club played*/
    private double f_numOfPoints;
    private int f_numOfMatchesPayed;

    //Create private variable for goal difference
    private int goaldifference;

    public int getGoalDifference() {
        this.goaldifference = f_gScored-f_gReceived;
        return goaldifference;
    }

    public void setGoalDifference(int goaldifference) {

        this.goaldifference = goaldifference;
    }

    public footBall_club(String SCName, String SCLocation){
        super(SCName,SCLocation);
    }


    //Create a constructor with arguments
    public footBall_club(String s, String s1, int f_wins, int f_draws, int f_defeat, int f_gScored, int f_gReceived, double f_numOfPoints, int f_numOfMatchesPayed){
        super();
        this.f_wins = f_wins;
        this.f_draws = f_draws;
        this.f_defeat = f_defeat;
        this.f_gScored = f_gScored;
        this.f_gReceived = f_gReceived;
        this.f_numOfPoints = f_numOfPoints;
        this.f_numOfMatchesPayed = f_numOfMatchesPayed;

    }
    //Default Constructor
    public footBall_club() {

    }

    /*Create a getter and setter methods for
    Number of wins club achieves */
    public int getF_Wins() {
        return f_wins;
    }

    public void setF_Wins(int f_wins) {
        this.f_wins = f_wins;
    }

    /*Create a getter and setter methods for
    clubs draw matches */
    public int getF_Draws() {
        return f_draws;
    }

    public void setF_Draws(int f_draws) {
        this.f_draws = f_draws;
    }

    /*Create a getter and setter methods for
    Clubs Defeat matches */
    public int getF_Defeat() {
        return f_defeat;
    }

    public void setF_Defeat(int f_defeat) {
        this.f_defeat = f_defeat;
    }

    /*Create a getter and setter methods for
    Clubs Goal Scored */
    public int getF_GScored() {
        return f_gScored;
    }

    public void setF_GScored(int f_gScored) {
        this.f_gScored = f_gScored;
    }

    /*Create a getter and setter methods for
    Received goals */
    public int getF_GReceived() {
        return f_gReceived;
    }

    public void setF_GReceived(int f_gReceived) {
        this.f_gReceived = f_gReceived;
    }

    /*Create a getter and setter methods for
    Number of points each club have */
    public double getF_NumOfPoints() {
        return f_numOfPoints;
    }

    public void setF_NumOfPoints(double f_numOfPoints) {
        this.f_numOfPoints = f_numOfPoints;
    }

    /*Create a getter and setter method for
    Number of matches played */
    public int getF_NumOfMatchesPayed() {
        return f_numOfMatchesPayed;
    }

    public void setF_NumOfMatchesPayed(int f_numOfMatchesPayed) {
        this.f_numOfMatchesPayed = f_numOfMatchesPayed;
    }

    //To String Method
    public String toString(){
        return String.valueOf(super.toString()+
                "   Wins        : "+f_wins+
                "   Draws       : "+f_draws+
                "   Defeat      : "+f_defeat+
                "   Goal Scored :"+f_gScored+
                "   GReceived   : "+f_gReceived+
                "   Points      : "+f_numOfPoints+
                "   MatchesPlayed : "+f_numOfMatchesPayed +"  | ");
    }
}
