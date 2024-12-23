package com.technical.functionalInterfaces;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static List<Student> listStudent = StudentDataBase.getAllStudents();

    public static void printUserNameAndUserActivities() {
        BiConsumer<String, List<String>> studentNameAndActivities = (studentName, studentActivities) -> {
            System.out.println("Student name: " + studentName + ", " + "Student Activities: " + studentActivities);
        };

        /*forEach espera um Consumer
        *
        * BiConsumer precisa de dois parâmetros
        * O lambda '(student) -> studentNameAndActivities.accept(student.getName(), student.getActivities())' funciona como
        * um adaptador, pegando um Student e extraindo os dois argumentos necessários para o BiConsumer
        *
        * */
        listStudent.forEach((student) -> studentNameAndActivities.accept(student.getName(), student.getActivities()));
    }


    public static void main(String[] args) {

        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println("a : " + a + ", b: " + b);
        };

        biConsumer.accept("Java 8", "JAVA!");

        BiConsumer<Double, Double> biconsumerMultiplication = (a, b) -> {
            System.out.println(a + " x " + b + " = " + a * b);
        };
        biconsumerMultiplication.accept(2.0, 3.0);

        BiConsumer<Double, Double> biconsumerDivision = (a, b) -> {
            if (b == 0) {
                System.out.println("Division by 0 not allowed");
            } else {
                System.out.println(a + " / " + b + " = " + a / b);
            }
        };


        biconsumerMultiplication.andThen(biconsumerDivision).accept(3.0, 9.0);

        printUserNameAndUserActivities();


    }
}
