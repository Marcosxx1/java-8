package com.technical.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

    public static Function<String, String> function = (name) -> name.toUpperCase();

    public static Function<String, String> addSomeString = (name) -> name.toUpperCase().concat("DEFAULT");

    public static void main(String[] args) {

        System.out.println("Result is: " + function.apply("java8")); // Saída: "JAVA8"

        System.out.println("Result is: " + function.andThen(addSomeString).apply("java8"));
        System.out.println("Result is: " + function.compose(addSomeString).apply("java8"));


    }

    /*
    public static Integer stringLength (String str){
        return str.length();
    }
    Function<String, Integer> stringLength = String::length;
    Function<String, Integer> stringLength = (s -> s.length());*/
}
