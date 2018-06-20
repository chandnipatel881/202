import java.util.Scanner;

    /**
     * FractionDriver.java - driver to test the Fraction class.
     * @version
     * @author
     * @Lab CMSC 202 - Spring 2012
     * @section
     */

    public class FractionDriver {

        /**
         * Driver to test the Fraction class.
         * Precondition: None
         * Postcondition: None
         * @param radius: args Command-line arguments
         * @return: None
         */
        public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numerator = 1;
        int denominator = 1;

        System.out.println("Enter the numerator of the first fraction ");
        numerator = scanner.nextInt();
        System.out.println("Enter the denominator of the first fraction ");
        denominator = scanner.nextInt();

        Fraction firstFraction = new Fraction(numerator, denominator);
        System.out.println("The first fraction is " + firstFraction.toString());

        Fraction reciprocalFirstFraction = new Fraction(denominator, numerator);
        System.out.println("The reciprocal of first fraction is " + reciprocalFirstFraction);

        System.out.println("Enter the numerator of the second fraction ");
        numerator = scanner.nextInt();
        System.out.println("Enter the denominator of the second fraction ");
        denominator = scanner.nextInt();

        Fraction secondFraction = new Fraction(numerator, denominator);
        System.out.println("The Second Fraction is " + secondFraction.toString());


        Fraction reciprocalSecondFraction = new Fraction(denominator, numerator);
        System.out.println("The reciprocal of the second fraction is " +
                reciprocalSecondFraction);


       System.out.printf("The decimal value of the first fraction is %.2f\n",
                firstFraction.decimalValue());
        System.out.printf("The decimal value of the second fraction is %.2f\n",
                secondFraction.decimalValue());


        System.out.println("The product of the two fractions is " +
                firstFraction.multiply(secondFraction).toString());
        System.out.println("Are these fractions equivalent? " +
                firstFraction.equals(secondFraction));

        }

    }

