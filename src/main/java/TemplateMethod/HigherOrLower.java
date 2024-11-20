package TemplateMethod;

import java.util.Random;
import java.util.Scanner;

public class HigherOrLower extends Game {
    private int currentRoll;
    private int lives;
    private Random random;
    private Scanner scanner;

    @Override
    public void initializeGame(int numberOfPlayers) {
        lives = 3;
        random = new Random();
        scanner = new Scanner(System.in);
        currentRoll = random.nextInt(6) + 1; // roll the die
        System.out.println("Game initialized! You have " + lives + " lives. Starting roll is: " + currentRoll);
    }

    @Override
    public boolean endOfGame() {
        return lives <= 0;  // Game ends when lives run out
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("Guess if the next roll is higher or lower than " + currentRoll + " (h/l): ");
        String guess = scanner.nextLine().toLowerCase();

        int nextRoll = random.nextInt(6) + 1;  // Roll the die again
        System.out.println("Next roll is: " + nextRoll);

        if ((guess.equals("h") && nextRoll > currentRoll) || (guess.equals("l") && nextRoll < currentRoll)) {
            System.out.println("Correct!");
            currentRoll = nextRoll;  // Update the current roll
        } else {
            lives--;  // Miinukset
            System.out.println("Incorrect guess! Lives left: " + lives);
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("Game over! You have lost all your lives.");
    }
}
