package baseball;

import utils.InputHandler;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        int size = game.getSize();
        int number = InputHandler.userGuessInteraction(size);
        game.startGame(number);
    }
}