package Test;

import com.company.playedDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class playedDateTest {

    @Test
    void getMatchDay() {
        playedDate newDay_01 = new playedDate(1,12,2020);
        //assertEquals(56,1);
        assertEquals(1,newDay_01.getMatchDay());
    }

    @Test
    void getMatchMonth() {
        playedDate newMonth_01 = new playedDate(1,12,2020);
        //assertEquals(15,12);
        assertEquals(12,newMonth_01.getMatchMonth());
    }

    @Test
    void getMatchYear() {
        playedDate newYear_01 = new playedDate(1,12,2020);
        //assertEquals(12,2020);
        assertEquals(2020,newYear_01.getMatchYear());
    }

    @Test
    void setMatchDay() throws playedDate.InvalidDate {

        playedDate newDay_01 = new playedDate(1,12,2020);
        newDay_01.setMatchDay(String.valueOf(12));
        assertEquals(12,newDay_01.getMatchDay());

    }

}