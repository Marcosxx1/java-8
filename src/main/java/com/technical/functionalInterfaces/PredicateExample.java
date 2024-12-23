package com.technical.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {


    /*Quando temos apenas uma declaração, podemos omitir o return, como no exemplo abaixo:
     *         Predicate<Integer> predicate = (i) ->  i % 2 == 0;
     */
    static Predicate<Integer> predicateIsEven = (i) -> {
        return i % 2 == 0;
    };

    static Predicate<Integer> predicateIsDividedByFive = (i) -> i % 5 == 0;

    public static void predicateAnd(){
        System.out.println("Predicated '.and()' result is: " + predicateIsEven.and(predicateIsDividedByFive).test(10));
    }

    public static void predicateOr(){
        System.out.println("Predicated '.or()' result is: " + predicateIsEven.or(predicateIsDividedByFive).test(1));
    }

    public static void predicatedNegate(){
        System.out.println("Predicated '.negate()' result is: " + predicateIsEven.or(predicateIsDividedByFive).negate().test(10));
    }

    public static void main(String[] args) {


        System.out.println(predicateIsEven.test(1));
        predicateAnd();
        predicateOr();
        predicatedNegate();

    }
}
