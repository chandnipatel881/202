public class Garage {

    private boolean isDoorOpen; //false means isDoorOpen is closed, true means isDoorOpen is open
    private boolean hasCar;  //false means there is no hasCar in the garage, true means there is a hasCar in the garage
    private boolean isOperating; //false means the isDoorOpen is broken, true means the isDoorOpen is isOperating fine
    private boolean metAccident; //true means the door has met accident, false is otherwise

    /**
     * Garage constructor
     */
    public Garage(){
        this.isDoorOpen = false;
        this.hasCar  = false;
        this.isOperating = true;
        this.metAccident = false;
    }

    /**
     * checks if the garage is empty or not
     * @return true if the garage is empty else false
     */
    public boolean isEmpty(){
        return !this.hasCar && this.isOperating && !this.metAccident;
    }

    /**
     * Adds the car in the garage.
     * pre-conditions : The door should be operating well
     *                  The door should be open
     *                  The door isn't broken
     *                  The garage hasn't met accident
     *
     * post-conditions : The garage door is already broken
     *                   The garage door might get broken
     *                   The garage door might get into an accident
     *                   The car was able to pull in
     *
     * @return : 1 if the garage door is not operational
     *           2 if someone broke the garage door
     *           3 if someone got the garage into an accident
     *           4 if the car was able to pull in
     *
     */
    public int pullCarIn() {
        if (!this.isOperating) {
            return 1;
        } else if (!this.isDoorOpen) {
            this.isOperating = false;
            return 2;
        } else if (this.hasCar) {
            this.metAccident = true;
            this.isOperating = false;
            return 3;
        } else {
            this.hasCar = true;
            return 4;
        }
    }

    /**
     * Removes the car from the garage
     * pre-conditions : The door should be operating well
     *                  The door should be open
     *                  The door isn't broken
     *                  The garage hasn't met accident
     *
     *post-conditions : The garage door might get broken
     *                  The garage door can become in-operational
     *                  There was no car in the garage
     *                  The car was able to back out
     *
     *@return : 1 if the garage door is not operational
     *          2 if someone broke the garage door
     *          3 if there is no car in the garage to back out
     *          4 if the car was able to back out
     */
    public int backCarOut(){
        //the door was closed and you tried to back out the car
        if (!this.isOperating) {
            return 1;
        } else if (!this.isDoorOpen){
            this.isOperating = false;
            return 2;
        } else if (!this.hasCar) {
            return 3;
        } else {
            this.hasCar = false;
            return 4;
        }
    }

    /**
     * opens the garage door
     * pre-conditions : the door should be operating and closed
     * post-conditions : the door will be open
     * @return : returns true if the operation was successful
     *           else returns false
     */
    public boolean openDoor(){
        if (this.isOperating && !this.isDoorOpen){
            this.isDoorOpen = true;
            return true;
        }
        else if(!this.isOperating){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * closes the garage door
     * pre-conditions : the door should be operating and open
     * post-conditions : the door will be closed
     * @return : returns true if the operation was successful
     *           else returns false
     */
    public boolean closeDoor(){
        if (this.isOperating && this.isDoorOpen){
            this.isDoorOpen = false;
            return true;
        }
        else if (!this.isOperating) {
            return false;
        }
        else{
            return true;
        }
    }




    public String toString(){
        String returnOutput = "";

        if (this.isDoorOpen){
            returnOutput = returnOutput + "Door is open\n";
        }
        else{
            returnOutput = returnOutput + "Door is closed\n";
        }
        if (this.hasCar){
            returnOutput = returnOutput + "There is a Car in the garage \n";
        }
        else{
            returnOutput = returnOutput + "There is no Car in the garage \n";
        }
        if (this.isOperating){
            returnOutput = returnOutput + "The Door is Operating well \n";
        }
        else{
            returnOutput = returnOutput + "The Door is broken \n";
        }
        if(!this.metAccident){
            returnOutput = returnOutput + "Garage has not met an accident\n";
        }
        return returnOutput;
    }
}
