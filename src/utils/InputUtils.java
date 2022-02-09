package utils;

import java.util.Scanner;

public class InputUtils {

  static Scanner scanner = new Scanner(System.in);

  private InputUtils() {}

  private static void checkDigit(String number, int size) {
    if (number.length() != size)
      throw new IllegalArgumentException();
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
      // 자릿수가 일치하는가
      checkDigit(inputNumber, size);
      // 사용자가 숫자를 입력했는가
      number = getNumberOrException(inputNumber);
    } catch (IllegalArgumentException e) {
      return -1;
    }
    return number;
  }

  public static int userInteraction(int size, String message) {
    int number = -1;
    do {
      System.out.print(message);
      String inputNumber = scanner.nextLine();
      number = getNumberIfValid(inputNumber, size);
    } while (number == -1);
    return number;
  }
}
