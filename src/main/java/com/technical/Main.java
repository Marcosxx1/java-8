package com.technical;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

public class Main {
    public static void main(String[] args) {

        


        // Declaratva

       var declarativeSum =  IntStream.rangeClosed(0,100).sum();

        System.out.println("Soma declarativa: " + declarativeSum);
    }
}