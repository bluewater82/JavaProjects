import java.util.Random;
import java.util.Scanner;


/**
 * Project 2 - Number Guesser revisited
 * <p>Author - Andre DeHerrera
 * <p>This program will simulate a guessing game where a number is chosen at
 * random and the user will be asked to guess the number.
 */

public class NumberGuesser {

    public static void main(String[] args) {

        // instantiate both random and scanner utils
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // play again response
        String replay = "y";

        // selects random number between
        int targetNumber = random.nextInt(1,101);

        // initializes counter for guesses
        int counter = 1;

        // initializes counter for times played
        int timesPlayed = 1;

        // prompts user for name
        System.out.println("Hello, human. What is your name?");

        // scanner obtains user input
        String userName = scanner.nextLine();

        while (replay.equals("y")) {

            // prompts for first guess, addresses using user's name
            if (timesPlayed == 1) {
                System.out.println("Hello " + userName + ". Please guess a number " +
                        "between 1 and 100.");
            } else {
                System.out.println("Awesome! Go ahead with your first guess.");
            }

            // scanner obtains user's guess
            int userGuess = scanner.nextInt();

            // logic for guessing loop
            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed it on your " +
                        "first try!");
            } else {
                while (userGuess != targetNumber) {
                    if (userGuess < targetNumber) { // too low
                        System.out.println("Your guess was too low. Guess again!");
                        counter += 1;
                        userGuess = scanner.nextInt();
                    }
                    if (userGuess > targetNumber) { // too high
                        System.out.println("Your guess was too high. Guess again!");
                        counter += 1;
                        userGuess = scanner.nextInt();
                    }
                    if (userGuess == targetNumber) { // correct
                        if (counter < 6) { // quick guess response
                            System.out.println("You guessed it very quickly! It " +
                                    "only took you " + counter + " tries! " +
                                    "Lucky!");
                        } else { // took more than 5 guesses
                            System.out.println("You got it! It took you " +
                                    counter + " tries.");
                        }
                    }
                }
            }
            System.out.println("Would you like to play again?");
            System.out.println("Please type 'y' for yes and 'n' for no.");
            replay = scanner.next();
            timesPlayed += 1;
        }
    }
}
