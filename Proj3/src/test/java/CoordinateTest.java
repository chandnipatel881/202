import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CoordinateTest {

    //coordinate 1 and 2 is to test class invariant
    /*Coordinate coordinate1 = new Coordinate(2,-1);
    Coordinate coordinate2 = new Coordinate(-2,3);*/
    //coordinate 3 is to test getColumn and getRow
    Coordinate coordinate3 = new Coordinate(2,3);

    @Test
    public void testGetColumnTrueCase() {
        assertEquals(3,coordinate3.getColumn());
    }

    @Test
    public void testGetColumnFalseCase(){
        assertNotEquals(4,coordinate3.getColumn());
    }
    @Test
    public void testGetRowTrueCase() {
        assertEquals(2, coordinate3.getRow());
    }
    @Test
    public void testGetRowFalseCase() {
        assertNotEquals(-2, coordinate3.getRow());
    }
}