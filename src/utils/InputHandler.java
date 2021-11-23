package utils;

import java.util.Scanner;

public class InputHandler {
    private InputHandler() {
    }

    private static void checkDigit(int number, int size) {
        if (number / Math.pow(10, size - 1) >= 10 || number / Math.pow(10, size - 1) < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputNumberHandler(String inputNumber, int size) {
        int number = -1;
        try {
//            사용자가 숫자를 입력했는가
            number = Integer.parseInt(inputNumber);
//            자릿수가 일치하는가
            checkDigit(number, size);
        } catch (Exception e) {
            return -1;
        }
        return number;
    }

    public static int userGuessInteraction(int size) {
        final Scanner scanner = new Scanner(System.in);
        int number = 0;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = scanner.next();
            number = InputHandler.inputNumberHandler(inputNumber, size);
        } while (number == -1);
        return number;
    }
}
