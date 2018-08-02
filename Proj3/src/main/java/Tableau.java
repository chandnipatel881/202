public class Tableau {

    public Card[] tableau;
    public Deck deck;

    /**
     * Tableau constructor
     * Creates an array of cards with the provided row and columns
     * Class Invariant : Rows and Columns of Tableau must be greater than or equal to zero
     * @param tableauRows
     * @param tableauColumns
     */
    public Tableau(int tableauRows, int tableauColumns, Deck deck){
        this.deck = deck;
        if (tableauRows >= 0 && tableauColumns >= 0) {
            tableau = new Card[tableauRows * tableauColumns];
            for(int i = 0; i < tableau.length; i++){
                tableau[i] = deck.draw();
            }
        }
        else{
            throw new RuntimeException("Tableau Rows or Columns needs to be greater than 0");
        }
    }

    /**
     * Consolidates the tableau towards the top left and up
     * to replace the cards that were removed.
     */
    public void consolidate(){
        int numOfShifts = 0;
        for(int i = 0; i < tableau.length; i++){
            if(tableau[i] == null){
                numOfShifts++;
            }
            else{
                if(numOfShifts > 0){
                    tableau[i - numOfShifts] = tableau[i];
                    tableau[i] = null;
                }
            }
        }
        //replacing the cards that were removed
        for (int i = tableau.length - numOfShifts; i < tableau.length; i++){
            tableau[i] = deck.draw();
        }
    }



    /**
     * toString function to print tableau object
     * @return
     */
    public String toString(){
        StringBuffer str = new StringBuffer();
        for (Card t : tableau){
            str.append(t);
            str.append("\n");
        }
        return str.toString();
    }
}
