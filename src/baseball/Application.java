package baseball;

import utils.InputHandler;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        boolean isError;
        int number = 0;
        int size = game.getSize();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = scanner.next();
            number = InputHandler.inputNumberHandler(inputNumber, size);
        } while (number == -1);

        game.startGame(number);
    }
}