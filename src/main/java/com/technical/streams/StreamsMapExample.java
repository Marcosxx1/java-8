package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMapExample {
    // collect all the student names in a list and print it

    public static List<Student> studentss = StudentDataBase.getAllStudents();

    public static List<String> getStudentNamesList() {

        return studentss.stream()
                // Map recebe um Function<Tipo, Retorno>
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String>
                .toList(); // Converte par alista
    }

    public static Set<String> getStudentNamesSet(){

        return studentss.stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }
    public static void main(String[] args) {

        System.out.println(getStudentNamesList());
        System.out.println("\n");
        System.out.println(getStudentNamesSet());

    }
}
