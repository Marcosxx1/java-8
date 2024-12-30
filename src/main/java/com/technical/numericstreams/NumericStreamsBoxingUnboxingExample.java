package com.technical.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnboxingExample {

    // Método para demonstrar o processo de Boxing (convertendo int para Integer)
    public static List<Integer> boxing() {
        return IntStream.rangeClosed(1, 5)
                .boxed() // Converte int para Integer
                .collect(Collectors.toList()); // Coleta em uma lista
    }

    // Método para demonstrar o processo de Unboxing (convertendo Integer para int)
    public static void unBoxing(List<Integer> integerList) {
        integerList.stream()
                .mapToInt(Integer::intValue) // Converte Integer para int
                .forEach(System.out::println); // Imprime os valores resultantes
    }

    public static void main(String[] args) {
        List<Integer> boxedList = boxing(); // Obtemos a lista com Integers (Boxing)
        System.out.println("Boxed List: " + boxedList); // Exibe a lista de Integers
        System.out.println("Unboxed Values: ");
        unBoxing(boxedList); // Aplica o unboxing e imprime os valores
    }
}
