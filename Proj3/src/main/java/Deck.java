import java.util.*;
/**
 * Deck class consists of 52 unique objects of Card class
 */
public class Deck {

    private Card[] deck = new Card[52];
    private int numCardDrawn;
    private int sizeOfDeck;

    /**
     * Constructor of Deck class
     * Creates 52 unique Card objects
     */
    public Deck() {
        for (int i = 0; i < Rank.values().length; i++) {
            for (int j = 0; j < Suit.values().length; j++) {
                deck[Suit.values().length * i + j] = new Card(Rank.values()[i], Suit.values()[j]);
            }
        }
        numCardDrawn = 0;
        sizeOfDeck = deck.length;
    }

    /**
     * Shuffles the Deck
     * Assumes the deck is full
     */
    public void shuffle() {
        Random num = new Random();
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
        Card retCard = this.deck[numCardDrawn];
        numCardDrawn++;
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
