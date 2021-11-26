package utils;

import java.util.Scanner;

public class InputUtils {

    static Scanner scanner = new Scanner(System.in);

    private InputUtils() {
    }

    private static void checkDigit(String number, int size) {
        if (number.length() != 3) throw new IllegalArgumentException();
    }

    private static int getNumberOrException(String input) {
        int parsedInput;
        try {
            parsedInput = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return parsedInput;
    }

    public static int getNumberIfValid(String inputNumber, int size) {
        int number = -1;
        try {
//            자릿수가 일치하는가
            checkDigit(inputNumber, size);
//            사용자가 숫자를 입력했는가
            number = getNumberOrException(inputNumber);
        } catch (IllegalArgumentException e) {
            return -1;
        }
        return number;
    }

    public static int inputRestartHandler(String inputNumber) {
        int number = -1;
        try {
//            사용자가 숫자를 입력했는가
            number = Integer.parseInt(inputNumber);
            if (number != 1 && number != 2) throw new IllegalArgumentException();
        } catch (Exception e) {
            System.err.println("맞는 값을 입력해주세요");
            return -1;
        }
        return number;
    }

    public static int userGuessInteraction(int size) {
        int number = -1;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = scanner.nextLine();
            number = getNumberIfValid(inputNumber, size);
        } while (number == -1);
        return number;
    }

    public static int userRestartInteraction() {
        final Scanner scanner = new Scanner(System.in);
        int restart = 0;
        do {
            String inputNumber = scanner.next();
            restart = inputRestartHandler(inputNumber);
        } while (restart == -1);
        return restart;
    }
}
