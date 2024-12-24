package com.technical.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    // Devemos usar BinaryOperator quando recebemos dois valores do mesmo tipo e retornaremos o mesmo tipo
    static BinaryOperator<Integer> binaryOperatorMultiplication = ((a,b) ->{
        return a * b;
    });

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

      int result = numbers.stream()
              .reduce(1, binaryOperatorMultiplication);

      /*
           Sem 'method reference'
        int resultWithOutMethodReference = numbers.stream()
                        .reduce(1, (a,b) -> a * b);
        System.out.println(resultWithOutMethodReference);*/

        System.out.println(result);
    }

}
