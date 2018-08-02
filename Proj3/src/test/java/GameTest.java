import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

import static org.testng.Assert.*;

/**
 * Test the {@link Game} class
 */
public class GameTest {

    @Test
    public void testConstructor() {
        Game game = new Game(5,5);
        assertEquals(game.getScore(), 0);
        assertEquals(game.numberOfCardsLeft(), 27);
        assertEquals(game.isWin(), false);
        assertEquals(game.isHintImplemented(), true);
    }

    @Test
    public void testConsolidate() throws Exception {
        Game game = new Game(5,5);
        Tableau table = Mockito.mock(Tableau.class);
        setTableauOnGame(game, table);
        game.consolidate();
        Mockito.verify(table, Mockito.atLeastOnce()).shorten();
        Mockito.verify(table, Mockito.atLeastOnce()).fillTableau(Mockito.any(Deck.class));
    }

    @Test
    public void testGetHelpText() {
        Game game = new Game(5, 5);
        assertNotNull(game.getHelpText());
    }

    @Test
    public void testGetHint() throws Exception {
        Game game = new Game(5, 5);
        game.newGame(1);
        Tableau table = getTableFromGame(game);
        Coordinate[] hints = game.getHint();
        assertEquals(table.getCardAt(hints[0]).getRank(), table.getCardAt(hints[1]).getRank());
    }

    @Test
    public void testGetRank() {
        Game game = new Game(5, 5);
        assertEquals(game.getRank(new Coordinate(1, 1)), Rank.SEVEN);
    }

    @Test
    public void testGetScore() {
        Game game = new Game(5,5);
        assertEquals(game.getScore(), 0);
    }

    @Test
    public void testGetSuit() {
        Game game = new Game(5, 5);
        assertEquals(game.getSuit(new Coordinate(1, 1)), Suit.CLUBS);
    }

    @Test
    public void testIsHintImplemented() {
        Game game = new Game(5, 5);
        assertTrue(game.isHintImplemented());
    }

    @Test
    public void testIsWin() throws Exception {
        Game game = new Game(5, 5);
        assertFalse(game.isWin());
        setScoreOnGame(game, 52);
        assertTrue(game.isWin());
    }

    @Test
    public void testNewGame() throws  Exception {
        Game game = new Game(5, 5);
        game.newGame(1);
        Card c = getTableFromGame(game).getCardAt(0);
        game.newGame(2);
        Card c2 = getTableFromGame(game).getCardAt(0);
        assertNotEquals(c, c2);
    }

    @Test
    public void testNumberOfCardsLeft() throws Exception {
        Game game = new Game(5, 5);
        Deck deck = getDeckFromGame(game);
        assertEquals(game.numberOfCardsLeft(), 27);
        deck.drawCard();
        assertEquals(game.numberOfCardsLeft(), 26);
    }

    @Test
    public void testRemoveCards() {
        Game game = new Game(5, 5);
        game.newGame(1);
        assertTrue(game.removeCards(game.getHint()[0], game.getHint()[1]));
    }

    @Test
    public void testRemoveCardsInvalidCards() {
        Game game = new Game(5, 5);
        assertFalse(game.removeCards(new Coordinate(0, 0), new Coordinate(1, 1)));
    }

    @Test
    public void testReplay() throws Exception {
        Game game = new Game(5,5);
        Deck deck = getDeckFromGame(game);
        String first_deck = deck.toString();
        game.replay();
        assertEquals(deck.toString(), first_deck);
    }

    private void setTableauOnGame(Game game, Tableau table) throws Exception {
        Field field = game.getClass().getDeclaredField("table");
        field.setAccessible(true);
        field.set(game, table);
    }

    private void setScoreOnGame(Game game, int score) throws Exception {
        Field field = game.getClass().getDeclaredField("score");
        field.setAccessible(true);
        field.set(game, score);
    }

    private Tableau getTableFromGame(Game game) throws Exception {
        Field field = game.getClass().getDeclaredField("table");
        field.setAccessible(true);
        return Tableau.class.cast(field.get(game));
    }

    private Deck getDeckFromGame(Game game) throws Exception {
        Field field = game.getClass().getDeclaredField("deck");
        field.setAccessible(true);
        return Deck.class.cast(field.get(game));
    }
}