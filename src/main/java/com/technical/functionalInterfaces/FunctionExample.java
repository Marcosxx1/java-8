package com.technical.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

    public static Function<String, String> function = (name) -> name.toUpperCase();

    public static Function<String, String> addSomeString = (name) -> name.toUpperCase().concat("default");

    public static void main(String[] args) {

    }
}
