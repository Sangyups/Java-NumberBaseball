package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        boolean isError;
        int number = 0;
        do {
            try {
                isError = false;
                String inputNumber = scanner.next();
                number = game.checkInput(inputNumber);
            } catch (Exception e) {
                System.err.println("적절한 숫자를 입력해주세요.");
                isError = true;
            }
        } while (isError);
        game.guessNumber(number);
    }
}