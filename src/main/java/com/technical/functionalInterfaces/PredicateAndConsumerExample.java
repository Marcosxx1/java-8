package com.technical.functionalInterfaces;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    // 1 - Criamos os Predicate (com a lógica que será utilizada no ...)
    Predicate<Student> studentGrade = (student) -> student.getGradeLevel() >= 3;
    Predicate<Student> studentGpa = (student) -> student.getGpa() >= 3.9;

    // 2 - Criamos um BiConsumer para podermos utilizar dois valores ao invés de somente um:
    BiConsumer<String, List<String>> studentValues = (name, activities ) ->
        System.out.println(name + " : " + activities);

    // 3 - Criamos um Consumer para utilizarmos os Predicate e atribuir ao Biconsumer os valores necessários...
    Consumer<Student> studentConsumer = (student -> {
        if(studentGrade.and(studentGpa).test(student)){
            studentValues.accept(student.getName(), student.getActivities());
        }
    });

    // 4 - Criamos a função que irá utilizar tudo isso

    public void printNameAndActivities(List<Student> students){
        students.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> students = StudentDataBase.getAllStudents();

        new PredicateAndConsumerExample().printNameAndActivities(students);
    }
}


/*
BiPredicate<Integer, Double> test = ((studentGpa, studentGrade) ->
            studentGpa >= 3.9 && studentGrade >= 3
    );*/