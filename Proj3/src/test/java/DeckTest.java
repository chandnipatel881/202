import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DeckTest {

    Deck deck = new Deck();

    @Test
    public void testDeckConstructor() {
        System.out.println(deck);
    }

    @Test
    public void testDeckShuffle(){
        deck.shuffle();
        System.out.println(deck);
    }

    @Test
    public void testDraw(){
        Card card = deck.draw();
        System.out.println(card);
    }

    @Test
    public void testGetDeckSize(){
        int size = deck.getSizeOfDeck();
        assertEquals(51,size);
    }

}