package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    // O resultado da soma de todos os números

    public static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    //public static BiFunction<Integer, Integer, Integer> sum = ((a,b) -> a * b);

    public static Integer performMultiplicationWithIdentity(List<Integer> numbers) {
        return numbers.stream()
                .reduce(numbers.getFirst(), (a, b) -> a * b);  // primeiro parâmetro da função é o valor que começará ex, .reduce(10, (a,b) -> a+b)  10,1,2,3,4,5,6
        // a = valor inicial. b = valor da coleção. 1,2,3,4,5,6
    }

    public static Optional<Integer> performMultiplicationWithOutIdentity(List<Integer> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a * b);
    }

    public static Optional<Student> getStudentWithHighestGpa() {
        return StudentDataBase.getAllStudents().stream()
                .reduce(((student, student2)
                        -> (student.getGpa() > student2.getGpa()) ? student : student2));
    }


    public static void main(String[] args) {

        Optional<Integer> resultWithOutIdentity = performMultiplicationWithOutIdentity(numbers);

        System.out.println("Resultado Optional.isPresent(): " + resultWithOutIdentity.isPresent());
        System.out.println("Resultado Optional.get: " + resultWithOutIdentity.get());

        System.out.println("A multiplicação de " + numbers + " é " + performMultiplicationWithIdentity(numbers));
        System.out.println("A multiplicação de " + numbers + " sem o 'Identity<T> é " + resultWithOutIdentity);
        System.out.println("Estudante com o maior GPA é:  " + getStudentWithHighestGpa().get());

    }
}
