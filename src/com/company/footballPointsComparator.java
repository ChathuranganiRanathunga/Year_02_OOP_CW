package com.company;

import java.util.Comparator;

//This class for Compare the each clubs points and then place them Descending Order
public class footballPointsComparator implements Comparator<footBall_club> {

    @Override
    public int compare(footBall_club t_01, footBall_club t_02) {

        if(t_01.getF_NumOfPoints() > t_02.getF_NumOfPoints())
            return  -1 ;
        else
        if(t_01.getF_NumOfPoints()<t_02.getF_NumOfPoints())
            return 1 ;
        else{
            //To get goal Difference
            int goalDifferent_01 = t_01.getF_GScored()-t_01.getF_GReceived();
            int goalDifferent_02 = t_02.getF_GScored()-t_02.getF_GReceived();
            //Checking given Conditions
            if(goalDifferent_01>goalDifferent_02)
                return -1;
            else
            if(goalDifferent_01<goalDifferent_02)
                return 1;
        }
        return 0;
    }
}
