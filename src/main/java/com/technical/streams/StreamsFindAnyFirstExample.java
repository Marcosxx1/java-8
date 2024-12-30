package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;
import java.util.Optional;

public class StreamsFindAnyFirstExample {

    public static List<Student> students = StudentDataBase.getAllStudents();

    public static Optional<Student> findFirst() {
        return students.stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findFirst();
    }

    public static Optional<Student> findAny() {
        return students.stream() // Encontra qualquer um, no caso a primeira ocorrência aceita pelo predicado
                .filter(student -> student.getGpa() >= 3.9)
                .findAny();
    }

    public static void main(String[] args) {
        System.out.println("findAny() :" + findAny());
        System.out.println("findFirst() :" + findFirst());
    }
}
