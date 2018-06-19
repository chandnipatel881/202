import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GarageTest {

    @Test
    public void testPullCarIn() {
        Garage g = new Garage();
        g.pullCarIn();
        //assertEquals(g.isOperating,false);
    }

    @Test
    public void testBackCarOut() {
    }

    @Test
    public void testOpenDoor() {
    }

    @Test
    public void testCloseDoor() {
    }
}