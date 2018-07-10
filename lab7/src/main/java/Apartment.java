public class Apartment extends Residence {

    private int story;

    public Apartment(int story, boolean hasWasher){
        super(4,4,hasWasher);
        this.story = story;
    }

    @Override
    public double propertyValue() {
        return super.propertyValue() + (this.hasWasher()? 100 : 0);
    }

    public int getStory(){
        return this.story;
    }

    @Override
    public String toString() {
        return super.toString() + "\nStory : " + this.story;
    }
}
