package Test;

import com.company.footBall_club;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class footBall_clubTest {

    @Test
    void getF_Wins() {
        footBall_club w =new footBall_club("a","c",12,3,5,16,18,10.2,20);
        //assertEquals(56,12);
        assertEquals(12,w.getF_Wins());
    }

    @Test
    void setF_Wins() {
        footBall_club w =new footBall_club("a","c",12,3,5,16,18,10.2,20);
        w.setF_Wins(10);
        assertEquals(10,w.getF_Wins());
    }

    @Test
    void getF_Draws() {
        footBall_club d =new footBall_club("a","c",12,3,5,16,18,10.2,20);
        assertEquals(3,d.getF_Draws());
    }

    @Test
    void setF_Draws() {
        footBall_club d =new footBall_club("a","c",12,3,5,16,18,10.2,20);
        d.setF_Wins(10);
        assertEquals(10,d.getF_Draws());
    }

    @Test
    void getF_Defeat() {
        footBall_club de =new footBall_club("a","c",12,3,5,16,18,10.2,20);
        assertEquals(5,de.getF_Defeat());
    }

    @Test
    void setF_Defeat() {
        footBall_club de =new footBall_club("a","c",12,3,5,16,18,10.2,20);
        de.setF_Wins(1);
        assertEquals(1,de.getF_Draws());
    }


    @Test
    void getF_GScored() {
        footBall_club gs =new footBall_club("a","c",12,3,5,16,18,10.2,20);
        assertEquals(16,gs.getF_GScored());
    }

    @Test
    void getF_GReceived() {
        footBall_club gr =new footBall_club("a","c",12,3,5,16,18,10.2,20);
        assertEquals(18,gr.getF_GReceived());
    }
}