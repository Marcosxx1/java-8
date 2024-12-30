package com.technical.streams;


import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateInterateExample {


    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("adam", "dan", "Julie");
        stringStream.forEach(System.out::println);

        Stream.iterate(1, value -> value * 2)
                .limit(5)
                .forEach(System.out::println);

        Supplier<Integer> integerSupplier = new Random()::nextInt;

        Stream.generate(integerSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}
