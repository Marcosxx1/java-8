package com.technical.lambdas;

import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;

public class ComparatorLambda {

    public static void main(String[] args) {
        //antes do java 8
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1.compareTo(o2); // 0 => 0
            }
        };

        System.out.println("Resultado do comparator é :" + comparator.compare(3,2));



        // Lambda Comparator

        Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> {return a.compareTo(b);};

        System.out.println("Resultado Comparator lambda: "+ comparatorLambda.compare(3,2));
    }



}
