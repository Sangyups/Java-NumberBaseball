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
                i--;
            }
        }
    }
    public ArrayList<Integer> getNumber() {
        for(Integer i: randomNumber) {
            System.out.println(i);
        }
        return randomNumber;
    }
}
