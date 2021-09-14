package com.company;

public class addMatch extends footBall_club {

    //Create variables for get two teams score
    private footBall_club team_1;
    private footBall_club team_2;
    private com.company.playedDate playedDate;

    //create variables for get goals each team score
    private int team_1_score;
    private int team_2_score;

    //Create getters and setters for Add Match Class variables

    public footBall_club getTeam_1() {
        return team_1;
    }

    public void setTeam_1(footBall_club Team_1) {
        this.team_1 = Team_1;
    }

    public footBall_club getTeam_2() {
        return team_2;
    }

    public void setTeam_2(footBall_club Team_2) {
        this.team_2 = Team_2;
    }

    public com.company.playedDate getPlayedDate() {
        return playedDate;
    }

    public void setPlayedDate(com.company.playedDate playedDate) {
        this.playedDate = playedDate;
    }

    public int getTeam_1_Score() {
        return team_1_score;
    }

    public void setTeam_1_Score(int Team_1_Score) {
        this.team_1_score = Team_1_Score;
    }

    public int getTeam_2_Score() {
        return team_2_score;
    }

    public void setTeam_2_Score(int Team_2_Score) {
        this.team_2_score = Team_2_Score;
    }


    //To String Method
    public String toString(){
        return String.valueOf ("Team 01 :"+team_1 +"     |  Team 01 Score : "+team_1_score+ "       |  Team 02 : "+team_2+ "    | Team 02 Score : "+team_2_score+"       |    Match Played Date : " + playedDate);
    }

}
