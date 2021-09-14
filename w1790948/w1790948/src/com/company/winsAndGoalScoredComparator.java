package com.company;

import java.util.Comparator;

public class winsAndGoalScoredComparator {

    //Create a Method to compare Clubs according to the number of wins they got
    Comparator<footBall_club> SortAccordingToWins = new Comparator<footBall_club>() {
        @Override
        public int compare(footBall_club team01, footBall_club team02) {
            if (team01.getF_Wins() > team02.getF_Wins()){
                return  -1 ;
            } else if(team01.getF_Wins() < team02.getF_Wins()){
                return  1 ;
            }
            return 0;
        }
    };


    //Create a Method to compare Clubs according to the number of Goals teams achieved
    Comparator<footBall_club> SortAccordingToGoalScored = new Comparator<footBall_club>() {
        @Override
        public int compare(footBall_club team01, footBall_club team02) {
            if (team01.getF_GScored() > team02.getF_GScored()){
                return  -1;
            } else if(team01.getF_GScored() < team02.getF_GScored()) {
                return 1;
            }
            return 0;
        }
    };
}

