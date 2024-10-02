package TemplateMethod;

import java.util.Random;

public class DiceGame extends Game {

    private int[] scores;
    private int winningScore = 20;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        scores = new int[numberOfPlayers];
        System.out.println("Dice game initialized with " + numberOfPlayers + " players.");
    }

    @Override
    public boolean endOfGame() {
        for (int score : scores) {
            if (score >= winningScore) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        int diceRoll = random.nextInt(6) + 1;
        scores[player] += diceRoll;
        System.out.println("Player " + (player + 1) + " rolled a " + diceRoll + ". Total score: " + scores[player]);
    }

    @Override
    public void displayWinner() {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= winningScore) {
                System.out.println("Player " + (i + 1) + " wins by " + scores[i]);
                break;
            }
        }
    }
}

