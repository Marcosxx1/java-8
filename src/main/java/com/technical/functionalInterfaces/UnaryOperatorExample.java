package com.technical.functionalInterfaces;

import com.technical.data.StudentDataBase;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    static UnaryOperator<String> unaryOperator = ((string) -> string.concat("Default"));

    // Criando um UnaryOperator para modificar o nome do aluno
    static UnaryOperator<String> applyProcessedOnStudentName = (string) -> {
        // Usando StringBuilder para adicionar um prefixo ao nome do aluno
        StringBuilder sb = new StringBuilder(string);
        sb.append(" (Processed)");
        return sb.toString();
    };
    public static void main(String[] args) {

        System.out.println( unaryOperator.apply("TESTE"));

        StudentDataBase.getAllStudents().forEach(student -> {
           var updatedStudentName =  applyProcessedOnStudentName.apply(student.getName());
            System.out.println(updatedStudentName);
        });


    }
}
