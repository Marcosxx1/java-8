package com.technical.functionalInterfaces;

import com.technical.data.StudentDataBase;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    static UnaryOperator<String> toUpperCaseUnary = ((string) -> string.toUpperCase());
    static UnaryOperator<Integer> numberSquared = (x -> x * x);
    static UnaryOperator<String> concatUnary = (s -> s.concat("Default!"));
    static UnaryOperator<String> applyProcessedOnStudentName = (string) -> {

        StringBuilder sb = new StringBuilder(string);
        sb.append(" (Processed)");
        return sb.toString();
    };

    public static void main(String[] args) {

        System.out.println(concatUnary.apply("TESTE"));

        StudentDataBase.getAllStudents().forEach(student -> {
            var updatedStudentName = applyProcessedOnStudentName.apply(student.getName());
            System.out.println(updatedStudentName);
        });

        System.out.println("Number squared (2): " + numberSquared.apply(2));
        System.out.println("convert this phrase to uppercase | "+ toUpperCaseUnary.apply("convert this phrase to uppercase")) ;

    }
}
