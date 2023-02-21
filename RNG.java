
import java.util.Random;

/**
 * This is the utility class to accompany RandomNumberGuesser class.
 * It contains static methods to generate a random number, validate the guesses as being between
 * the previous low and high guesses, and maintain the number of guesses.
 * 
 * @author Farnaz Eivazi
 * @version 12/8/2022
 */
public class RNG {
	private static int count;
	private static final int MAX_GUESS = 7;

	/**
	 * Sets the count to zero
	 */
	public static void resetCount() {
		count = 0;
	}

	/**
	 * Generates a random integer between 1 and 100
	 * 
	 * @return the random number as an integer
	 */
	public static int rand() {
		Random rand = new Random();
		int randInt = rand.nextInt(100) + 1;
		return randInt;
	}

	/**
	 * Checks that nextGuess is strictly between lowGuess and highGuess inclusive
	 * 
	 * @param nextGuess
	 * @param lowGuess
	 * @param highGuess
	 * @return a boolean, true if the guess is with the bounds, false otherwise
	 */
	public static boolean inputValidation(int nextGuess, int lowGuess, int highGuess) {
		if (nextGuess >= highGuess || nextGuess <= lowGuess) {
			System.out.println("  >>>Guess must be between " + lowGuess + " and " + highGuess + ".  Try again");
			return false;
		}	
		return true;
	}

	/**
	 * Gets the number of guesses
	 * 
	 * @return an integer, the current value of count
	 */
	public static int getCount() {
		return count;
	}
	
	/**
	 * Increments the number of guesses
	 * 
	 */
	public static void incrementCount() {
		count++;
	}
	
	/**
	 * Gets the value of the MAX_GUESS attribute
	 * 
	 * @return an integer, the max value of count
	 */
	public static int getMaxGuessCount() {
		return MAX_GUESS;
	}
}
