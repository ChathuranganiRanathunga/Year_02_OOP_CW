package Test;

import com.company.school_footBallClub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class school_footBallClubTest {

    @Test
    void getF_SchoolName() {
        school_footBallClub scl_01 = new school_footBallClub("High School","Government");
        //assertEquals("d","High School");
        assertEquals("High School",scl_01.getF_SchoolName());
    }

    @Test
    void setF_SchoolName() {
        school_footBallClub scl_01 = new school_footBallClub("High School","Government");
        scl_01.setF_SchoolName("a");
        assertEquals("a",scl_01.getF_SchoolName());
    }

    @Test
    void getF_SchoolType() {
        school_footBallClub sclType = new school_footBallClub("High School","Government");
        assertEquals("Government",sclType.getF_SchoolType());
    }

    @Test
    void setF_SchoolType() {
        school_footBallClub sclType = new school_footBallClub("High School","Government");
        sclType.setF_SchoolType("Private");
        assertEquals("Private",sclType.getF_SchoolType());
    }
}