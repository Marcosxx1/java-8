package com.technical.methodreference;

import java.util.function.Function;

public class FunctionMethodReferenceExample {

    // Utilizando lambda SEM Method Reference
    static Function<String, String> toUpperCaseLambda = (string) -> string.toUpperCase();

    // Utilizando Method Reference
    static Function<String, String> toUpperCaseLambdaReference = (String::toUpperCase);

    public static void main(String[] args) {

    }
}
