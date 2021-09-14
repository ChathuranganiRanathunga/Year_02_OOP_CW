package Test;

import com.company.uni_footBallClub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class uni_footBallClubTest {

    @Test
    void getUniversityName() {
        uni_footBallClub uniName = new uni_footBallClub("Westminster","London","Westminster","Private");
        //assertEquals("j","Westminster");
        assertEquals("Westminster",uniName.getUniversityName());
    }

    @Test
    void getUniversityType() {
        uni_footBallClub uniType = new uni_footBallClub("Westminster","London","Westminster","Private");
        assertEquals("Westminster",uniType.getUniversityType());
    }

    @Test
    void setUniversityName() {
        uni_footBallClub uniName = new uni_footBallClub("Westminster","London","Westminster","Private");
        uniName.setUniversityName("a");
        assertEquals("a",uniName.getUniversityName());
    }

    @Test
    void setUniversityType() {
        uni_footBallClub uniType = new uni_footBallClub("Westminster","London","Westminster","Private");
        uniType.setUniversityType("b");
        assertEquals("b",uniType.getUniversityType());
    }
}