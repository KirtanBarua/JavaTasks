import javax.swing.*;
import java.util.Random;

public class NumberGuessingGame {
    private static final int MAX_TRIES = 10;
    private static int totalScore = 0;

    public static void main(String[] args) {
        String playAgain;
        do {
            int targetNumber = new Random().nextInt(100) + 1;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            while (attemptsUsed < MAX_TRIES && !guessedCorrectly) {
                String input = JOptionPane.showInputDialog("Guess the number (1 to 100):");
                int userGuess;

                try {
                    userGuess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                    continue;
                }

                attemptsUsed++;

                if (userGuess < 1 || userGuess > 100) {
                    JOptionPane.showMessageDialog(null, "Out of range! Please choose a number between 1 and 100.");
                } else if (userGuess == targetNumber) {
                    guessedCorrectly = true;
                    totalScore += (MAX_TRIES - attemptsUsed + 1); // Score based on remaining attempts
                    JOptionPane.showMessageDialog(null, "Well done! You guessed the number " + targetNumber + "!");
                } else if (userGuess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low. Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Out of attempts! The correct number was " + targetNumber + ".");
            }

            playAgain = JOptionPane.showInputDialog("Would you like to play again? (yes/no)").toLowerCase();
        } while (playAgain.equals("yes"));

        JOptionPane.showMessageDialog(null, "Your total score: " + totalScore);
    }
}
