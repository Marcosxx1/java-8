package com.technical.numericstreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangeExample {


    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 50); // (x, y) x -> <y [Ou seja, começa com X e vai até y-1]
        IntStream intStreamRangeClosed = IntStream.rangeClosed(1, 50); // (x, y) x -> <=y [Ou seja, começa com X e vai até y]

        System.out.println(intStream.count()); // contagem de todos os items da stream
        System.out.println(intStreamRangeClosed.count());// contagem de todos os items da stream

        LongStream.rangeClosed(1,10).forEach(System.out::println);
    }
}
