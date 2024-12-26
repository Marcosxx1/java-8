package com.technical.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsVsStream {

    public static void main(String[] args) {

        /*Como sabemos, coleçoes podem ser modificadas a qualquer momento*/
        ArrayList<String> names = new ArrayList<>();

        names.add("Aline");
        names.add("Marcos");
        names.add("Olivia");

        names.removeFirst();
        System.out.println(names);

        names.add("Peter");

        for (String name : names) { // Podemos iterar uma
            System.out.println(name);
        }

        for (String name : names) { // ou duas vezes
            System.out.println(name);
        }

        var nameStream = names.stream();

        // Consumindo a Stream pela primeira vez
        nameStream.forEach(System.out::println);

        // Tentando consumir novamente (vai lançar IllegalStateException)
        nameStream.forEach(System.out::println);
    }

}
