package com.technical.imperativevsdeclarative;

import java.util.stream.IntStream;

public class ImperativeVsDeclarativeFirstExample {
    public static void main(String[] args) {

        /*Imperativa*/
        int sumImperative = 0;
        for (int i = 0; i <= 100; i++) {
            sumImperative += i;
        }
        System.out.println(sumImperative);


        /*Declarativa*/
        var declarativeSum = IntStream.rangeClosed(0, 100) // Separa os valores
                .parallel()
                .sum();

        System.out.println("Soma declarativa: " + declarativeSum);
    }
}
