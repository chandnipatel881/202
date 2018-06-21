public class Fraction {

    private int numerator;
    private int denominator;

    /**
     * Constructs a new Fraction with a provided numerator and denominator
     * Precondition: denominator must not be zero
     * Postcondition: None
     * @param n the numerator of the new Fraction
     * @param d the denominator of the new Fraction
     * @return None
     */
    public Fraction( int numerator, int denominator )
    {
        //A Fraction cannot have a zero denominator.
        if (denominator == 0)
            throw new RuntimeException("Divide By Zero Exception");
        else
        {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    /**
     * Retrieves the value of the numerator
     * Precondition: None
     * Postcondition: None
     * @param None
     * @return An int representing the numerator
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * Returns a String representation of this Fraction.
     * Precondition: None
     * Postcondition: None
     * @param None
     * @return A String representation of this Fraction
     */
    public String toString()
    {
        return "\n" + "numerator = " + this.numerator + "\n" + "denominator = " + this.denominator;
    }

    /**
     * Returns the decimal value of the Fraction
     * Precondition: None
     * Postcondition: None
     * @param None
     * @return A double representing the decimal value of this Fraction
     */
    public double decimalValue()
    {
        return ((double)this.numerator/this.denominator);
    }

    /**
     * Multiples this Fraction by a given Fraction
     * Precondition: None
     * Postcondition: None
     * @param otherFraction the Fraction to multiply by
     * @return A Fraction that is the result of multiplying this Fraction by the given Fraction
     */
    public Fraction multiply( Fraction otherFraction )
    {
        Fraction multiplyFraction = new Fraction(otherFraction.numerator * this.numerator, otherFraction.denominator * this.denominator);
        return multiplyFraction;
    }

    /**
     * Returns whether this Fraction is equal to a given Fraction.
     * Precondition: None
     * Postcondition: None
     * @param other The Fraction to check equality against
     * @return A boolean signifying whether or not this Fraction and the given Fraction are equal
     */
    public boolean equals(Fraction secondFraction) {
        if ((this.numerator * secondFraction.denominator) == (this.denominator* secondFraction.numerator)) {
            return true;
        }
        return false;
    }
}
