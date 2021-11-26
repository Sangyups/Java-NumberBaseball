package utils;

import java.util.ArrayList;
import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int nextInt(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }

        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }

        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }

    public static ArrayList<Integer> nextArray(final int size) {
        ArrayList<Integer> randomNumber = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int rand = nextInt(1, 9);
            randomNumber.add(i, rand);
            if (randomNumber.stream().
                    distinct().
                    count() != randomNumber.size()) {
//                그냥 i--만 하면 자동으로 i번째 index에 overwrite할 줄 알았는데 무한루프에 빠짐.
                randomNumber.remove(i--);
            }
        }
//        for debug
//        randomNumber.forEach(System.out::println);

        return randomNumber;
    }
}
