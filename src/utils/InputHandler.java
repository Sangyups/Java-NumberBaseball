package utils;

public class InputHandler {
    private InputHandler(){
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
}
