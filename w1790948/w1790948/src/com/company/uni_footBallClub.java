package com.company;

public class uni_footBallClub extends footBall_club {

    /*Initialise an instance private variables for
    University Type and University Name */


    private String universityName;

    //University type = private or government
    private String universityType;


    //Create a constructor with arguments
    public uni_footBallClub(String SCName, String SCLocation, String universityName, String universityType){

        super(SCName,SCLocation);
        this.universityName = universityName;
        this.universityType = universityType;
    }

    /* Create  getter and setter methods for
    Club members University Name*/
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    /*Create getter and setter methods for
   Club members University Type */
    public String getUniversityType() {
        return universityType;
    }

    public void setUniversityType(String universityType) {
        this.universityType = universityType;
    }

    //To String Method
    public String toString(){
        return super.toString()+
                "   University Name : "+universityName +
                "   University Type : "+universityType+ "   |  ";
    }
}
