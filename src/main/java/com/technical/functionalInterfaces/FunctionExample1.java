package com.technical.functionalInterfaces;

public class FunctionExample1 {

    public static String performConcat(String str){
        return FunctionExample.addSomeString.apply(str);
    }

    public static void main(String[] args) {

        String result = performConcat("Hello!");

        System.out.println(result);
    }
}
