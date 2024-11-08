import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * This program gets a constant number and four numbers from user. Then using
 * the "charming theory," the program calculates the best combination of
 * exponents to raise the four numbers to and getting the product as close as
 * possible to the constant. Then the program shows the approximated answer and
 * relative error.
 *
 * @author A. Singh
 *
 */
public final class ABCDGuesser1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser1() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {

        //Prompting user to enter a positive real number
        out.print("Enter a postive real number (eg. constant): ");
        String input = in.nextLine();

        //Declaring & initializing a double variable
        double x = 0;

        //If statement to check if the first input is a number
        if (FormatChecker.canParseDouble(input)) {
            //Storing input in variable
            x = Double.parseDouble(input);
        }

        //While loop to check if the variable is a positive real number
        while (x <= 0) {
            //Prompting user again to enter a positive real number
            out.print(
                    "Please enter a postive real number only (eg. constant): ");
            input = in.nextLine();

            //If statement to check if the input is a number
            if (FormatChecker.canParseDouble(input)) {
                //Storing input in variable
                x = Double.parseDouble(input);
            }
        }

        //Returning number
        return x;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        //Prompting user to enter a positive real number greater than 1
        out.print(
                "Enter postive real number greater than 1 (eg. favorite number): ");
        String input = in.nextLine();

        //Declaring and initializing variable
        double x = 0;

        //If statement to check if the initial response was a number
        if (FormatChecker.canParseDouble(input)) {
            //Storing number in variable
            x = Double.parseDouble(input);
        }

        //While loop to check if the number is positive real number but not 1
        while (x <= 0.0 || x == 1.0) {
            //Prompting user again to enter a positive real number but not 1
            out.print("Please enter postive real number greater than 1 only "
                    + "(eg. favorite number): ");
            input = in.nextLine();

            //If statement to check if the input is number
            if (FormatChecker.canParseDouble(input)) {
                //Storing number in variable
                x = Double.parseDouble(input);
            }
        }

        //Returning number
        return x;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        //Declaring variables with reference to class SimpleReader1
        //and SimpleWriter1L for output and input
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //Storing theory numbers in array
        final double[] values = { -5, -4, -3, -2, -1, -1 / 2.0, -1 / 3.0,
                -1 / 4.0, 0, 1 / 4.0, 1 / 3.0, 1 / 2.0, 1, 2, 3, 4, 5 };

        //Declared variables
        final double percentageMultiplier = 100.0;
        double lowestDifference = -1.0;
        int bestA = 0;
        int bestB = 0;
        int bestC = 0;
        int bestD = 0;

        //Calling methods to get mu, w, x, t, z
        double mu = getPositiveDouble(in, out);
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        //Entering a series of nested loops to check for every possible combination
        int a = 0;
        while (a < values.length) {
            int b = 0;
            while (b < values.length) {
                int c = 0;
                while (c < values.length) {
                    int d = 0;
                    while (d < values.length) {

                        //A variable that stores value of the difference between
                        //mu and current combination in decimal form
                        double difference = Math.abs(((Math.pow(w, values[a])
                                * Math.pow(x, values[b])
                                * Math.pow(y, values[c])
                                * Math.pow(z, values[d])) - mu) / mu);

                        //If statement to check if difference is less than the
                        //current lowest difference, or statement used to ensure
                        //the first execution to set the lowest difference
                        if (difference < lowestDifference
                                || lowestDifference == -1.0) {

                            //Setting lowest difference to the difference
                            lowestDifference = difference;

                            //Storing best exponents combination
                            bestA = a;
                            bestB = b;
                            bestC = c;
                            bestD = d;
                        }
                        d++;
                    }
                    c++;
                }
                b++;
            }
            a++;
        }

        //Printing the best combination and the value it equals
        out.println();
        out.print("Best Combination: " + w + "^" + values[bestA] + " * " + x
                + "^" + values[bestB] + " * " + y + "^" + values[bestC] + " * "
                + z + "^" + values[bestD] + " = ");
        out.print((Math.pow(w, values[bestA]) * Math.pow(x, values[bestB])
                * Math.pow(y, values[bestC]) * Math.pow(z, values[bestD])), 2,
                false);

        //Printing the relative error of the approximation
        out.println();
        out.print("Relative Error: ");
        out.print((lowestDifference * percentageMultiplier), 2, false);
        out.print("%");

    }
}
