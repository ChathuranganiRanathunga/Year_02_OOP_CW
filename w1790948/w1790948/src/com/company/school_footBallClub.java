package com.company;

public class school_footBallClub extends footBall_club {


    /*Create a private instance variables for
    School Name and School type(Whether it is government or private) */

    private String f_schoolName;
    private String f_schoolType;

    //Create Default Constructor
    public school_footBallClub(String SCName, String SCLocation, String f_schoolName, String f_schoolType){
        super(SCName,SCLocation);
        this.f_schoolName = f_schoolName;
        this.f_schoolType = f_schoolType;

    }

    //Create a constructor with arguments
    public school_footBallClub(String f_schoolName, String f_schoolType){

        this.f_schoolName = f_schoolName;
        this.f_schoolType = f_schoolType;
    }

    /*Create public getter and setter methods for
    Club Members School Name*/
    public String getF_SchoolName() {
        return f_schoolName;
    }

    public void setF_SchoolName(String f_schoolName) {
        this.f_schoolName = f_schoolName;
    }

    /*Create public getter and setter methods for
    Club members School Type(Government/Private) */

    public String getF_SchoolType() {
        return f_schoolType;
    }

    public void setF_SchoolType(String f_schoolType) {
        this.f_schoolType = f_schoolType;
    }

    //To String Method
    public String toString(){
        return super.toString()+
                "   School Name : "+ f_schoolName+
                "   School Type : "+ f_schoolType+"   |  ";
    }
}
