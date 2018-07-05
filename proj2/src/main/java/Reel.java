import java.util.HashSet;
import java.util.Random;

public class Reel {

    //Array holding reel's symbols
    private Symbol[] currentReel = new Symbol[Symbol.values().length];

    /**
     * Helper function to set Reel's symbols using the random number generator
     * Reel's symbols are set randomly for each instance of reel
     * Pre-conditions : None
     * Post-conditions : None
     * @param seed - Takes the seed from the constructor
     */
    private void fillReel(int seed){
        Random generator = new Random(seed);
        HashSet<Integer> usedNum = new HashSet<Integer>();
        int randomNum;
        for (int i = 0; i < Symbol.values().length; i++) {

            randomNum = generator.nextInt(Symbol.values().length);

            while(true){
                if(!usedNum.contains(randomNum)){
                    usedNum.add(randomNum);
                    break;
                }
                else{
                    randomNum = generator.nextInt(Symbol.values().length);
                }
            }
            currentReel[i] = Symbol.values()[randomNum];
        }
    }

    /**
     * Reel Constructor
     * Pre-conditions : None
     * Post-conditions : None
     * Reel symbols are set
     * @param seed - random number generator seed
     *
     */
    public Reel(int seed){
        fillReel(seed);
    }

    /**
     * Accessor for reel's symbols
     * Pre-conditions : None
     * Post-conditions : None
     * Reel symbols are returned
     * @return - A reel's symbols
     */

    public Symbol[] getSymbols(){
        return currentReel;
    }

    /**
     * Returns a string containing a reel's state
     * Preconditions: None
     * Postconditions: String containing reel's state is constructed
     * @return - string containing reel's state
     */
    public String toString(){
        StringBuffer returnString = new StringBuffer();
        for(Symbol s : currentReel){
            returnString.append(s);
            returnString.append('\n');
        }
        return returnString.toString();
    }

    public static void main (String [] args){
        Reel reel = new Reel(10);
            System.out.println(reel);
    }

}
