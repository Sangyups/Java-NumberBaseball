package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        ArrayList<Integer> randomNumber =
                IntStream.generate(() -> nextInt(1, 9))
                        .distinct()
                        .limit(3)
                        .mapToObj(i -> i)
                        .collect(Collectors.toCollection(ArrayList::new));

//        for debug
//        randomNumber.forEach(System.out::print);
//        System.out.println();

        return randomNumber;
    }
}
