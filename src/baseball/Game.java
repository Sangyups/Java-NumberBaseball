package baseball;


import utils.InputHandler;
import utils.RandomUtils;

import java.util.ArrayList;

public class Game {
    private ArrayList<Integer> randomNumber = new ArrayList<>();
    private Integer size;
    Game(){
        size = 3;
        for(int i = 0; i < size; i++) {
            int rand = RandomUtils.nextInt(1, 9);
            randomNumber.add(i, rand);
            if (randomNumber.stream().
                    distinct().
                    count() != randomNumber.size()) {
//                그냥 i--만 하면 자동으로 i번째 index에 overwrite할 줄 알았는데 무한루프에 빠짐.
                randomNumber.remove(i--);
            }
        }
//        for debug
        randomNumber.forEach(System.out::println);
    }

    public int getSize() {
        return size;
    }

    private ArrayList<Integer> sliceInput(int inputNumber) {
        ArrayList<Integer> slicedInput = new ArrayList<>();
        for (int i = size - 1; i >= 0; i--) {
            int div = (int) Math.pow(10, i);
            slicedInput.add(size - 1 - i, inputNumber / div);
            inputNumber %= div;
        }
        return slicedInput;
    }

    private boolean guessNumber(int inputNumber) {

        ArrayList<Integer> slicedInput = new ArrayList<>();

        slicedInput = sliceInput(inputNumber);

//        current index, strikes, balls
        int[] scores = {0, 0, 0};

        slicedInput.forEach(i -> {
            if (randomNumber.indexOf(i) == scores[0]++) scores[1]++;
            else if (randomNumber.indexOf(i) != -1) scores[2]++;
        });
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
        if (scores[1] == size) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public void startGame(int inputNumber) {
        int guess = inputNumber;
        while (!guessNumber(guess)) {
            guess = InputHandler.userGuessInteraction(size);
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }
}
