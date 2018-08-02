import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CardTest {

    Card card1 = new Card(Rank.ACE, Suit.CLUBS);

    @Test(expectedExceptions = RuntimeException.class)
    public void testClassInvariant() {
        Card card2 = new Card(null, Suit.DIAMONDS);
    }

    @Test
    public void testGetRankTrue() {
        assertEquals(Rank.ACE, card1.getRank());
    }

    @Test
    public void testGetRankFalse() {
        assertNotEquals(Rank.EIGHT, card1.getRank());
    }

    @Test
    public void testGetSuitTrue() {
        assertEquals(Suit.CLUBS,card1.getSuit());
    }

    @Test
    public void testGetSuitFalse() {
        assertNotEquals(Suit.DIAMONDS,card1.getSuit());
    }
}