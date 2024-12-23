package com.technical.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

    // Define uma função que transforma o texto em letras maiúsculas
    public static Function<String, String> function = (name) -> name.toUpperCase();

    // Define uma função que transforma o texto em letras maiúsculas e adiciona a ‘string’ "default"
    public static Function<String, String> addSomeString = (name) -> name.toUpperCase().concat("DEFAULT");

    public static void main(String[] args) {

        // Aplica a função 'function' ao valor "java8" e exibe o resultado
        System.out.println("Result is: " + function.apply("java8")); // Saída: "JAVA8"

        // Aplica 'function' primeiro, depois 'addSomeString' (sequência definida por 'andThen')
        System.out.println("Result is: " + function.andThen(addSomeString).apply("java8"));
        // Explicação:
        // 1. 'function' converte "java8" para "JAVA8".
        // 2. 'addSomeString' adiciona "DEFAULT" ao resultado de 'function'.
        // Saída: "JAVA8DEFAULT"

        // Aplica 'addSomeString' primeiro, depois 'function' (sequência definida por 'compose')
        System.out.println("Result is: " + function.compose(addSomeString).apply("java8"));
        // Explicação:
        // 1. 'addSomeString' transforma "java8" em "JAVA8DEFAULT".
        // 2. 'function' converte "JAVA8DEFAULT" novamente para letras maiúsculas (não altera, pois já está em maiúsculas).
        // Saída: "JAVA8DEFAULT"
    }
}
