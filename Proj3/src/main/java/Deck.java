import java.util.*;
/**
 * Deck class consists of 52 unique objects of Card class
 */
public class Deck {

    private final int NUM_CARDS = 52;
    private Card[] deck = new Card[NUM_CARDS];
    private int sizeOfDeck;

    /**
     * Constructor of Deck class
     * Creates 52 unique Card objects
     */
    public Deck() {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Rank.values().length; j++) {
                deck[Rank.values().length * i + j] = new Card(Rank.values()[j], Suit.values()[i]);
            }
        }
        sizeOfDeck = deck.length;
    }

    /**
     * Shuffles the Deck
     * Assumes the deck is full
     */
    public void shuffle(long seed) {
        Random num = new Random(seed);
        int n = deck.length - 1;
        Card temp;
        do {
            int k = num.nextInt(n + 1);
            temp = deck[k];
            deck[k] = deck[n];
            deck[n] = temp;
            n -= 1;
        } while (n >= 0);
    }

    /**
     * Draws one card from top of the deck
     * @return - first card from the deck
     */
    public Card draw(){
        if(sizeOfDeck == 0){
            return null;
        }
        Card retCard = this.deck[NUM_CARDS - sizeOfDeck];
        sizeOfDeck--;
        return retCard;
    }

    /**
     * Returns the size of the deck
     * @return - size of deck
     */
    public int getSizeOfDeck(){
        return sizeOfDeck;
    }

    /**
     * toString function of Deck class
     * @return
     */
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Card d : deck){
            str.append(d);
            str.append("\n");
        }

        return str.toString();

    }
}
