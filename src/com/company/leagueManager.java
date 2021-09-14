package com.company;

public interface leagueManager {
    //Create abstract method for add Football club to the league
    abstract void addClubToLeague(footBall_club footBall_club);


    //Create abstract method for delete football club from the league
    abstract int deleteClubFromLeague(String S_ClubName);

    //Show the clubs already in he league
    void showTheClubsInLeague();

    //Show related statistics to the entered club
    abstract void ShowRelatedDetailsEnteredClub(String S_ClubName);

}

