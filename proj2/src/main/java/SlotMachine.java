import java.util.HashSet;

public class SlotMachine {
    public final int MAX_BET = 3;
    private final int MAX_REEL = 3;
    private Reel[] reels = new Reel[MAX_REEL];
    private int BetAmount;
    private int Credits;
    private int Wins;
    private int Losses;
    private int Payout;
    private int NumOfGamesPlayed;
    private int winnings;

    /**
     * Constructor
     * Preconditions: Number of reels must be == 3
     * Postcondition: Machine's reels symbols are initialized based off the machine's id, machineid+1, machineid+2
     * @param machineID - the unique ID for a slot machine
     */
    public SlotMachine(int machineID) {
        for (int i = 0; i < reels.length ; i ++){
            reels[i] = new Reel(machineID + i);
        }
        this.BetAmount = 0;
        this.Credits = 10;
        this.Wins = 0;
        this.Losses = 0;
        this.Payout = 0;
        this.NumOfGamesPlayed = 0;
    }

    /**
     * Accessor for player bet amount
     * Preconditions: None
     * Postcondition: Bet amount is returned
     * @return - Player Bet Amount
     */
    public int getBetAmount() {
        return this.BetAmount;
    }

    /**
     * Accessor for number of player credits
     * Preconditions: None
     * Postcondition: Number of player credits is returned
     * @return - Number of Player Credits
     */
    public int getCredits() {
        return this.Credits;
    }

    /**
     * Accessor for reel
     * Precondition: Reel requested must be >=0 and < maximum in machine
     * Postcondition: Reel is returned
     * @param index - index - - Number of reel being accessed, beginning with 0
     * @return Reel - a deep copy of the requested
     */
    public Reel getReel(int index){
        if (index >= 0 && index < MAX_REEL){
            return reels[index];
        }else{
            throw new RuntimeException("Reel Index must be 1,2 or 3");
        }
    }

    /**
     * Computes and returns machine statistics
     * Preconditions: None
     * Postcondition: Returns string containing machine statistics
     * @return - A string containing the number of wins, losses, and average payout per play
     */
    public String getMachineStatistics(){
        return "Number of wins : " + this.Wins + "\nNumber of losses : " + this.Losses + "\nAverage number of payout : "
                + (double)this.Payout/this.NumOfGamesPlayed;
    }

    /**
     * Determines if player has won
     * Preconditions: All symbols must not be null
     * Postcondition: - If player has won, number of wins is incremented, winnings are computed and added to credits,
     *                  and winnings are deducted from machine. - If player has lost, number of losses are incremented
     *                  and bet amount is added to machine. In either case, number of games played is incremented and
     *                  bet amount is reset to zero.
     * @param one - - symbol from first reel
     * @param two - - symbol from second wheel
     * @param three - - symbol from third wheel
     * @return true if player has won, otherwise false
     */
    public boolean isWinner(Symbol one,
                            Symbol two,
                            Symbol three){

        if(one == null || two == null || three == null){
            throw new RuntimeException("Symbols must not be null");
        }
        this.NumOfGamesPlayed++;
        if(one.equals(two) && one.equals(three)){
            this.Wins++;
            this.Payout += this.BetAmount * one.getPayout();
            this.Credits += this.BetAmount * one.getPayout();
            this.BetAmount = 0;
        }
        else if(one.equals(two) || one.equals(three)){
            this.Wins++;
            this.Payout += this.BetAmount * one.getPayout() * 0.5;
            this.Credits += this.BetAmount * one.getPayout() * 0.5;
            this.BetAmount = 0;
        }
        else if(two.equals(three)){
            this.Wins++;
            this.Payout += this.BetAmount * two.getPayout() * 0.5;
            this.Credits += this.BetAmount * two.getPayout() * 0.5;
            this.BetAmount = 0;
        }
        else{
            this.Losses++;
            this.BetAmount = 0;
            return false;
        }
        return true;

    }

    /**
     * Increases bet by specified amount
     * Preconditions: Amount must be > 0
     * Postcodition: Bet is increased by specified amount
     * @param amt - Amount to increase bet by
     */
    public void increaseBet(int amt){
        if(amt <= 0){
            throw new RuntimeException("Bet amount must be greater than zero");
        }
        if((Credits - amt) >= 0) {
            this.BetAmount += amt;
            this.Credits -= amt;
        }
    }

    /**
     * Resets bet amount to zero
     * Preconditions: None
     * Postcondition: Bet amount is reset to zero
     */
    public void resetBet(){
        this.Credits += this.BetAmount;
        this.BetAmount = 0;
    }

    /**
     * Add specified amount to player's credits
     * Preconditions: Amount must be > 0
     * Postcondition: Amount is added to player's credits
     * @param amount - Amount to be added
     */
    public void addCredits(int amount){
        if(amount < 0){
            throw new RuntimeException("Credit amount must be greater than zero");
        }
        this.Credits += amount;

    }

    /**
     * Provides text help on how to play the slot machine
     * Preconditions: None
     * Postcondition: Help string is returned
     * @return
     */
    public java.lang.String getHelpText(){
        return "Help";
    }

}
