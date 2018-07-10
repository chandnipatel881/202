public class Residence {

    private int numWalls;
    private int numRooms;
    private boolean hasWasher;

    public Residence(int numWalls, int numRooms, boolean hasWasher){
        this.numWalls = numWalls;
        this.numRooms = numRooms;
        this.hasWasher = hasWasher;
    }

    protected boolean hasWasher(){
        return this.hasWasher;
    }

    public double propertyValue(){
        return this.numRooms * 10000;
    }

    public int numWindows(){
        return this.numWalls * 2;
    }

    public String toString(){
        StringBuffer returnString = new StringBuffer();
        returnString.append("Number of Rooms: ");
        returnString.append(this.numRooms);
        returnString.append("\nNumber of Walls: ");
        returnString.append(this.numWalls);
        returnString.append("\nWasher: ");
        returnString.append(this.hasWasher);
        returnString.append("\nNumber of Windows: ");
        returnString.append(numWindows());
        returnString.append("\nProperty Value: ");
        returnString.append(propertyValue());

        return returnString.toString();
    }
}
