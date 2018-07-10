public class Card {

    private Rank rank;
    private Suit suit;

    /**
     * Card Constructor
     * Class Invariant : Rank and Suit cannot be null
     * @param rank of the card
     * @param suit of the card
     */
    public Card(Rank rank,Suit suit){
        if(rank == null || suit == null){
            throw new RuntimeException("Rank or Suit cannot be null");
        }
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Accessor of the Rank
     * @return rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Accessor of the Suit
     * @return suit
     */
    public Suit getSuit() {
        return suit;
    }
}
