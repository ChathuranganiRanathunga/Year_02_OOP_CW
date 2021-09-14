package com.company;

import java.io.Serializable;

public class sports_club implements Serializable {


    /*Initialise private instance Variables to
    sport club ID, Sport Club Name and Sport Club Location */


    private String s_clubName;
    private String s_clubLocation;


    //Create a default constructor
    public sports_club(){

    }

    //Create a constructor with arguments
    public sports_club(String s_clubName , String s_clubLocation ){

        this.s_clubName = s_clubName;
        this.s_clubLocation = s_clubLocation;
    }



    /*Create a getter and setter methods for
    Sport club Name */
    public String getS_ClubName() {
        return s_clubName;
    }

    public void setS_ClubName(String s_clubName){
        this.s_clubName = s_clubName;
    }

    /*Create a getter and setter methods for
    Sport Club Location */
    public String getS_ClubLocation() {
        return s_clubLocation;
    }

    public void setS_ClubLocation(String s_clubLocation){
        this.s_clubLocation = s_clubLocation;
    }
    //To String Method
    public String toString(){
        return  "   Club Name: "+s_clubName+
                "               Club Location : "+s_clubLocation + "                    |  ";
    }

}

