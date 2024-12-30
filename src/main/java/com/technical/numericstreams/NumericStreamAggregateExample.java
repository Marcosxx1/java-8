package com.technical.numericstreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreamAggregateExample {


    public static void main(String[] args) {
        // utilizar sum de IntStream para somar todos os valores em uma faixa
        int somaTotal = IntStream.range(1,50).sum();

        // Utilizar max de IntStream para verificar o valor máximo da faixa
        OptionalInt valorMaximo = IntStream.range(1,50).max(); // IntStream.range(1,50).max() retorna um OptionalInt, semelhante a Optional<T>

        if(valorMaximo.isPresent()){
            System.out.println("Valor máximo entre 1 e 50: " + valorMaximo);
        } else {
            System.out.println("Sem valor máximo");
        }

        OptionalInt valorMin = IntStream.range(1,50).min(); // IntStream.range(1,50).max() retorna um OptionalInt, semelhante a Optional<T>
        if(valorMin.isPresent()){
            System.out.println("Valor mínimo entre 1 e 50: " + valorMin);
        } else {
            System.out.println("Sem valor mínimo");
        }


        OptionalDouble average = IntStream.range(1,50).average();
        if(average.isPresent()){
            System.out.println("Média: " + average);
        } else {
            System.out.println("Sem média");
        }
        System.out.println(somaTotal);

    }
}
