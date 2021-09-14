package com.company;

import java.util.Comparator;

public class dateComparator {
    //Sort Played matches by date
    Comparator<addMatch> sortByDate = new Comparator<addMatch>() {
        @Override
        public int compare(addMatch match_01_date, addMatch match_02_date) {

            //Set Validations to sort the date
            if (match_01_date.getPlayedDate().getMatchYear() < match_02_date.getPlayedDate().getMatchYear()){
                return 1;

            } else if (match_01_date.getPlayedDate().getMatchYear() > match_02_date.getPlayedDate().getMatchYear()){
                return -1;

            } else if (match_01_date.getPlayedDate().getMatchMonth() < match_02_date.getPlayedDate().getMatchMonth()){
                return 1;

            } else if (match_01_date.getPlayedDate().getMatchMonth() > match_02_date.getPlayedDate().getMatchMonth()){
                return -1;

            } else if (match_01_date.getPlayedDate().getMatchDay() > match_02_date.getPlayedDate().getMatchDay()){
                return -1;

            } else if (match_01_date.getPlayedDate().getMatchDay() < match_02_date.getPlayedDate().getMatchDay()){
                return 1;

            } else
                return 0;

        }
    };
}
