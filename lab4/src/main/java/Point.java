public class Point {

    private int x;
    private int y;

    /**
     * Constructor of Point class
     * @param x - x-coordinate
     * @param y - y-coordinate
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * copy constructor
     * @param original point to copy
     */
    public Point(Point original)
    {
        this.x = original.x;
        this.y = original.y;
    }
    /**
     * accessor function
     * @return the x-coordinate of the point
     */
    public int getX(){
        return this.x;
    }

    /**
     * accessor funtion
     * @return the y-coordinate of the point
     */
    public int getY(){
        return this.y;
    }

    public double distance ( Point otherPoint) {
        return Math.sqrt(((otherPoint.x - this.x)*(otherPoint.x - this.x)) + ((otherPoint.y - this.y)*(otherPoint.y - this.y)));
    }
}


