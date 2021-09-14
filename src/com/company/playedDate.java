package com.company;


import java.io.Serializable;

public class playedDate implements Serializable {

    /*Initialise variables for math Played Day,
    Month and Year*/
    private int matchPlayedDay;
    private int matchPlayedMonth;
    private int matchPlayedYear;

    //Default Constructor for Date Class
    public playedDate() {
    }

    //Constructor with  Day Month and Year
    public playedDate(int matchPlayedDay, int matchPlayedMonth, int matchPlayedYear){

        this.matchPlayedDay = matchPlayedDay;
        this.matchPlayedMonth = matchPlayedMonth;
        this.matchPlayedYear = matchPlayedYear;
    }

    //Create getters and setters for Match played day
    public int getMatchDay() {
        return matchPlayedDay;
    }

    public void setMatchDay(String date) throws InvalidDate {
        //Validate the Day
        int P_day = Integer.parseInt(date.substring(0, 2));

        if (P_day > 0 && P_day <= 31){
            this.matchPlayedDay =P_day;
        }else
            throw new InvalidDate();

    }

    //Create getters and setters for match played month
    public int getMatchMonth() {
        return matchPlayedMonth;
    }

    public void setMatchMonth(String date) throws InvalidDate {

        int matchPlayedMonth = Integer.parseInt(date.substring(3,5));
        //Validate the match played month
        if (matchPlayedMonth >0 && matchPlayedMonth <= 12){
            this.matchPlayedMonth =matchPlayedMonth;
        }else {
            throw new InvalidDate();

        }
    }

    //Create getters and setters for match played Year
    public int getMatchYear() {
        return matchPlayedYear;
    }

    public void setMatchYear(String date) {
        this.matchPlayedYear = 2020 ;

    }

    //Date to String method
    @Override
    public String toString() {
        return matchPlayedDay +"/"+ matchPlayedMonth +"/"+ matchPlayedYear;
    }

    public static class InvalidDate extends Exception{

    }

}
