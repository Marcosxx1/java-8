package com.technical.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class NumericStreamsExample {

    public static int sumOfNNumbers(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, (firstElement, secondElement) -> firstElement + secondElement); // Converte Integer para int

        /*      .reduce(Integer::sum); //Optional<Integer> retorno
                .reduce((firstElement, secondElement) -> Integer.sum(firstElement, secondElement)); */
    }

    public static int sumOfNNumbersgIntStream(){
        return IntStream.rangeClosed(1, 6 )  // Quando formos realizar operações relacionadas a números, podemos utilizar o IntStream
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(sumOfNNumbers(integerList));
        System.out.println(sumOfNNumbersgIntStream());
    }

}