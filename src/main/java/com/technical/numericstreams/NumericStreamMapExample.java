package com.technical.numericstreams;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class NumericStreamMapExample {

    // Método para retornar lista de Integers
    public static List<Integer> returnObj(){
        return IntStream.rangeClosed(1,5)
                .boxed()
                .toList();
    }

    // Método para mapear para Long
    public static void mapToLong(){
        IntStream.rangeClosed(1,5)
                .mapToLong(x -> x)  // Transforma int em long
                .sum();  // Soma dos valores
    }

    // Novo método para mapear para Double
    public static void mapToDouble(){
        IntStream.rangeClosed(1,5)
                .mapToDouble(x -> x)  // Transforma int em double
                .sum();  // Soma dos valores
    }

    public static void main(String[] args) {
        // Chama o método returnObj() e imprime o tipo do primeiro valor da lista
        var value = returnObj();
        System.out.println(value.get(0).getClass().getName());

        // Chama o método mapToDouble() para realizar a operação com DoubleStream
        mapToDouble();
    }
}
