package com.technical.imperativevsdeclarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ImperativeVsDeclarativeSecondExample {

    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(1,2,3,4,4,5,6,7,7,8,9,0,9);

        /*Imperativa: */
        List<Integer> listaComNumerosUnicos = new ArrayList<>();

        for(Integer numero : listOfNumbers){
            if(!listaComNumerosUnicos.contains(numero)){
                listaComNumerosUnicos.add(numero);
            }
        }

        System.out.println("Imperativa: " + listaComNumerosUnicos);


        /*Declarativa: */
        List<Integer> uniqueListDeclarative = listOfNumbers.stream()
                .distinct()
                .toList();

        System.out.println("Declarativa: " + uniqueListDeclarative);
    }
}
