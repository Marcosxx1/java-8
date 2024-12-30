package com.technical.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLimitSkipExample {

    public static Optional<Integer> sumLimit(List<Integer> integerList) {
        return integerList.stream()
                .limit(2)
                .reduce(Integer::sum);
    }

    public static Optional<Integer> sumSkip(List<Integer> integerList) {
        return integerList.stream()
                .skip(2)
                .reduce(Integer::sum);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);

        System.out.println("Sum limit: " + sumLimit(integerList)); //  Define o tamanho máximo para 2, ou seja (6,7) do array integerList [Linha 11]
        System.out.println("Sum skip: " + sumSkip(integerList)); //  Pula os 2 primeiros elementos do array, ou seja (6,7)  mantendo apenas (8, 9, 10)[Linha 17]
    }
}