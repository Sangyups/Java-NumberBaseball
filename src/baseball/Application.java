package baseball;

import utils.InputHandler;

import java.util.Scanner;

public class Application {
    public static int userInteraction(Scanner scanner, int size) {
        int number = 0;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = scanner.next();
            number = InputHandler.inputNumberHandler(inputNumber, size);
        } while (number == -1);
        return number;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        int size = game.getSize();
        int number = userInteraction(scanner, size);
        game.startGame(number);
    }
}