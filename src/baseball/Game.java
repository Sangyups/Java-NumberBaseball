package baseball;


import utils.InputUtils;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private ArrayList<Integer> randomNumber;
    private Integer sizeOfNum;

    Game() {
        this.sizeOfNum = 3;
    }

    public int getSize() {
        return sizeOfNum;
    }

    private void generateNumber() {
        randomNumber = IntStream.generate(() -> RandomUtils.nextInt(1, 9))
                .distinct()
                .limit(sizeOfNum)
                .mapToObj(i -> i)
                .collect(Collectors.toCollection(ArrayList::new));

//        for debug
//        randomNumber.forEach(System.out::print);
//        System.out.println();
    }

    private ArrayList<Integer> sliceInput(int inputNumber) {
        ArrayList<Integer> slicedInput = new ArrayList<>();
        for (int i = sizeOfNum - 1; i >= 0; i--) {
            int div = (int) Math.pow(10, i);
            int index = sizeOfNum - 1 - i;
            int digit = inputNumber / div;
            slicedInput.add(index, digit);
            inputNumber %= div;
        }
        return slicedInput;
    }

    private void printResult(int[] scores) {
        String result = "";
        if (scores[2] > 0) {
            result += scores[2] + "볼 ";
        }
        if (scores[1] > 0) {
            result += scores[1] + "스트라이크";
        }
        if (scores[1] == 0 && scores[2] == 0) {
            result = "낫싱";
        }
        System.out.println(result);
        if (scores[1] == sizeOfNum) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private boolean guessNumber(int inputNumber) {

        ArrayList<Integer> slicedInput = sliceInput(inputNumber);

//        current index, strikes, balls
        int[] scores = {0, 0, 0};

        slicedInput.forEach(i -> {
            if (randomNumber.indexOf(i) == scores[0]++) scores[1]++;
            else if (randomNumber.indexOf(i) != -1) scores[2]++;
        });

        printResult(scores);

        return scores[1] == sizeOfNum;
    }

    public void startGame() {
        int guess;
        do {
            guess = InputUtils.userGuessInteraction(sizeOfNum);
        } while (!guessNumber(guess));
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    public void initializeGame() {
        generateNumber();
        startGame();
    }
}
