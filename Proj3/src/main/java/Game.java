import java.util.*;

public class Game {

    private Tableau monteCarlo;
    private int gameScore;
    private int tableauRows;
    private int tableauColumns;
    private long gameNumber;

    /**
     * Constructs a new Monte Carlo Solitaire object
     * @param tableauRows - the number of rows in tableau
     * @param tableauColumns - the number of Columns in tableau
     */
    public Game(int tableauRows, int tableauColumns){
        Random random = new Random();
        this.tableauColumns = tableauColumns;
        this.tableauRows = tableauRows;
        newGame(random.nextLong());
    }

    /**
     * Moves cards in the tableau towards the top (left and up) to replace the cards that were removed
     */
    public void consolidate(){
        monteCarlo.consolidate();
    }

    private Card cardAtGivenIndex(Coordinate coordinate){
        return monteCarlo.tableau[coordinate.getRow() * this.tableauRows + coordinate.getColumn()];
    }
    /**
     * Returns the Rank of the card at a given co-ordinate
     * @param coordinates
     * @return
     */
    public Rank getRank(Coordinate coordinates){
        Card card = cardAtGivenIndex(coordinates);
        if (card == null){
            return null;
        }
        return card.getRank();
    }

    /**
     * Returns the Suit of the Card at a given co-ordinate
     * @param coordinates
     * @return
     */
    public Suit getSuit(Coordinate coordinates){
        Card card = cardAtGivenIndex(coordinates);
        if(card == null){
            return null;
        }
        return card.getSuit();
    }

    /**
     * Returns the size of the deck
     * @return
     */
    public int numberOfCardsLeft(){
        return monteCarlo.deck.getSizeOfDeck();
    }

    /**
     * Returns true if cards can be removed, false otherwise
     * @param coordinate1
     * @param coordinate2
     * @return
     */
    public boolean removeCards(Coordinate coordinate1, Coordinate coordinate2){
        if(Math.abs(coordinate1.getRow() - coordinate2.getRow()) > 1 || Math.abs(coordinate1.getColumn() - coordinate2.getColumn()) > 1){
            return false;
        }
        if (getRank(coordinate1) == getRank(coordinate2)){
            gameScore  = gameScore + 2;
            monteCarlo.tableau[coordinate1.getRow() * this.tableauRows + coordinate1.getColumn()] = null;
            monteCarlo.tableau[coordinate2.getRow() * this.tableauRows + coordinate2.getColumn()] = null;
            return true;
        }
        return false;
    }

    /**
     * Returns a help message explaining the rules of the game
     * @return
     */
    public String getHelpText(){
        return "The HELP";
    }

    /**
     * Returns true if Hint is implemented, false otherwise
     * @return
     */
    public boolean isHintImplemented(){
        return false;
    }

    public Coordinate[] getHint(){
        return null;
    }

    /**
     * Returns the score of the player for the current game
     * @return
     */
    public int getScore(){
        return gameScore;
    }

    /**
     * Determines if the player has won the game by removing all the cards and thereby achieving a score of 52
     * @return
     */
    public boolean isWin(){
        if (gameScore == 52){
            return true;
        }
        return false;
    }

    /**
     * Starts a new game of solitaire for the specified game number in accordance to project specifications.
     * @param gameNumber
     */
    public void newGame(long gameNumber){
        Deck deck = new Deck();
        deck.shuffle(gameNumber);
        this.monteCarlo = new Tableau(tableauRows,tableauColumns,deck);
        this.gameScore = 0;
        this.gameNumber = gameNumber;
    }

    /**
     * Restarts the current game
     */
    public void replay(){
        newGame(gameNumber);
    }
}
