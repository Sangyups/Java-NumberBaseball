package baseball;


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
            if(randomNumber.stream().
                    distinct().
                    count() != randomNumber.size()){
//                그냥 i--만 하면 자동으로 i번째 index에 overwrite할 줄 알았는데 무한루프에 빠짐.
                randomNumber.remove(i--);
            }
        }
    }

    private int checkInput(String inputNumber) {
        int number = -1;
        try {
//            사용자가 숫자를 입력했는가?
            number = Integer.parseInt(inputNumber);
        } catch (Exception e) {
            System.err.println("Invalid Input");
            return number;
        }
//        숫자가 size만큼의 자리수가 아닐때
        if(number / Math.pow(10, size-1) > 9 || number / Math.pow(10, size-1) < 1 ) return -1;
        return number;
    }
    private ArrayList<Integer> sliceInput(int inputNumber) {
        ArrayList<Integer> slicedInput = new ArrayList<>();
        for(int i = size -1; i >= 0; i--) {
            int div = (int)Math.pow(10, i);
            slicedInput.add(size-1-i, inputNumber / div);
            inputNumber %= div;
        }
        return slicedInput;
    }
    public String guessNumber(String inputNumber) {
        int gotNumber = checkInput(inputNumber);
        ArrayList<Integer> slicedInput = new ArrayList<>();
        if(gotNumber == -1){
            throw new IllegalArgumentException();
        } else {
            slicedInput = sliceInput(gotNumber);
        }
        for(Integer i: slicedInput) {
            System.out.println(i);
        }
        return "asd";
    }
}
