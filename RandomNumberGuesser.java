/*
 * Class :CMSC203
 * Instructor: Dr. Monshi
 * Description: Generate a random number and have the user guess the number.
 * Program will show how low or high the guesses are compared to previous guesses.
 * Allows up to 7 guesses until the program terminates.
 * Due: 1/22/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Name: Alex Tseng
 */

import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
	
		// outer vars
		String response = "yes";
		Scanner keyboard = new Scanner(System.in);
		
		// title
		System.out.println("This application generates a random integer between 0 and 100\n"
				+ "  and ask the user to guess repeatedly until the guess is correct\n");
		
		// operation
		while (response.equals("yes")) {
			// guess vars
			int nextGuess = 0;
			int lowGuess = 0;
			int highGuess = 100;
			
			// resets whenever there is a new game
			RNG rng = new RNG();
			int answer = rng.rand();
			rng.resetCount();
			System.out.println("Enter your first guess:");
			nextGuess = keyboard.nextInt();
			
			// loop through the rest of the guesses until count = 7 or answer found
			while (rng.getCount() != 7) {
				// if guess is more than answer, validate it
				if (nextGuess > answer) {
					if (rng.inputValidation(nextGuess, lowGuess, highGuess) == true) {
						highGuess = nextGuess;
						System.out.println("Your guess is too high");
						rng.incrementCount();
						System.out.println("Number of guesses: " + rng.getCount());
						System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
						nextGuess = keyboard.nextInt();
					}
					else {
						nextGuess = keyboard.nextInt();
					}
				}
				// if guess is less than answer, validate it
				else if (nextGuess < answer) {
					if (rng.inputValidation(nextGuess, lowGuess, highGuess) == true) {
						lowGuess = nextGuess;
						System.out.println("Your guess is too low");
						rng.incrementCount();
						System.out.println("Number of guesses: " + rng.getCount());
						System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
						nextGuess = keyboard.nextInt();
					}
					else {
						nextGuess = keyboard.nextInt();
					}
				}
				// get response to try again, and break out of inner loop to test outer loop
				else if (nextGuess == answer) {
					System.out.println("Congradulations, you guessed correctly\n"
							+ "Try again? (yes or no)");
					keyboard.nextLine();
					response = keyboard.nextLine();
					break;
				}
				
				// terminate program when count = 7
				if (rng.getCount() == rng.getMaxGuessCount()) {
					System.out.println("You have exceeded the maximum number of guesses, 7. Try again");
					System.exit(0);
				}
			}
		}
		
		// end text
		System.out.println("Thanks for playing...\n\nProgrammer name: Alex Tseng");

	}

}
