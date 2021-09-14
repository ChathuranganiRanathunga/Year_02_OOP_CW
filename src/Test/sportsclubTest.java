package Test;

import com.company.sports_club;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sportsclubTest {

    @Test
    void getS_ClubName() {
        sports_club newClub_01 = new sports_club("Chelsia","London");
        assertEquals("Chelsia",newClub_01.getS_ClubName());
    }

    @Test
    void getS_ClubLocation() {
        sports_club location_01 = new sports_club("Chelsia","London");
        assertEquals("k","London");
        assertEquals("London",location_01.getS_ClubLocation());
    }

    @Test
    void setS_ClubName() {
        sports_club newClub_01 = new sports_club("Chelsia","London");
        newClub_01.setS_ClubName("Enisa");
        assertEquals("Enisa",newClub_01.getS_ClubName());
    }

    @Test
    void setS_ClubLocation() {
        sports_club location_01 = new sports_club("Chelsia","London");
        location_01.setS_ClubLocation("India");
        assertEquals("India",location_01.getS_ClubLocation());
    }
}