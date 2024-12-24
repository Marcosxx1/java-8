package com.technical.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    // Devemos usar BinaryOperator quando recebemos dois valores do mesmo tipo e retornaremos o mesmo tipo
    static BinaryOperator<Integer> binaryOperatorMultiplication = ((a, b) -> {
        return a * b;
    });

    static BinaryOperator<Integer> multiply = (a, b) -> a * b;
    static BinaryOperator<Integer> sum = (a, b) -> a + b;
    static BinaryOperator<Integer> subtraction = (a, b) -> a - b;


    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int resultMultiplicationStream = numbers.stream().reduce(1, binaryOperatorMultiplication);
        int resultSumStream = numbers.stream().reduce(0, sum);
        int resultSubtraction = numbers.stream().reduce(0, subtraction);
        System.out.println(numbers.stream().reduce(multiply));

      /*
           Sem 'method reference'
        int resultWithOutMethodReference = numbers.stream()
                        .reduce(1, (a,b) -> a * b);
        System.out.println(resultWithOutMethodReference);*/

        System.out.println("Multiplication: " + resultMultiplicationStream);

        System.out.println("Sum in a stream: " + resultSumStream);
        System.out.println("Sum passing arguments: " + sum.apply(4, 4)); // 4 e 4 são argumentos

        System.out.println("Straction in a stream: "+ resultSubtraction);
        System.out.println("Straction passing arguments "+ subtraction.apply(3,2)); // 3 e 2 são argumentos
    }

}
