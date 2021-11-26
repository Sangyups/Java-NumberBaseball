package utils;

import java.util.Scanner;

public class InputUtils {

    Scanner scanner = new Scanner(System.in);

    private InputUtils() {
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
        final Scanner scanner = new Scanner(System.in);
        int number = 0;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = scanner.next();
            number = inputNumberHandler(inputNumber, size);
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
