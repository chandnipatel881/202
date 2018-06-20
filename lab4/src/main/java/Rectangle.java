public class Rectangle {

    private Point upperLeft, lowerLeft, lowerRight, upperRight;

    /**
     * Constructor of Rectangle class
     *
     * @param upperLeft  point of rectangle
     * @param lowerLeft  point of rectangle
     * @param lowerRight point of rectangle
     * @param upperRight point of rectangle
     */
    public Rectangle(Point upperLeft, Point lowerLeft, Point lowerRight, Point upperRight) {
        if (upperLeft.getX() != lowerLeft.getX() || upperRight.getX() != lowerRight.getX() ||
                upperLeft.getY() != upperRight.getY() || lowerLeft.getY() != lowerRight.getY())
            {
                throw new IllegalArgumentException("The given coordinates do not form rectangle");
            }
            this.upperLeft = upperLeft;
            this.lowerLeft = lowerLeft;
            this.lowerRight = lowerRight;
            this.upperRight = upperRight;
        }

        /**
         * Copy constructor of Rectangle class
         * which uses copy constructor of Point class
         * @param original
         */
    public Rectangle(Rectangle original)
        {
            upperLeft = new Point(original.upperLeft);
            lowerLeft = new Point(original.lowerLeft);
            lowerRight = new Point(original.lowerRight);
            upperRight = new Point(original.upperRight);
        }

        /**
         * Calculates the length of the rectangle
         * @return the length of the rectangle
         */
        public double getLength () {
            return upperLeft.distance(upperRight);
        }

        /**
         * Calculates the width of the rectangle
         * @return the width of the rectangle
         */
        public double getWidth ()
        {
            return upperLeft.distance(lowerLeft);
        }

        /**
         * Calculates the area of the rectangle
         * @return area of the rectangle
         */
        public double getArea ()
        {
            return this.getLength() * this.getWidth();
        }

        /**
         * Calculates the perimeter of the rectangle
         * @return perimter of the rectangle
         */
        public double getPerimeter ()
        {
            return 2 * (this.getWidth() + getLength());
        }

    }